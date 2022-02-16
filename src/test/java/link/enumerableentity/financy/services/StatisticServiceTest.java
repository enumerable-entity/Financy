package link.enumerableentity.financy.services;

import link.enumerableentity.financy.enums.Type;
import link.enumerableentity.financy.models.Category;
import link.enumerableentity.financy.models.Transaction;
import link.enumerableentity.financy.models.User;
import link.enumerableentity.financy.models.dto.StatisticData;
import link.enumerableentity.financy.repositories.TransactionsRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StatisticServiceTest {

    @Mock
    private TransactionsRepository transactionsRepository;

    @InjectMocks
    private StatisticService statisticService;

    private static List<Transaction> incomingTransactionsTestList;
    private static List<Transaction> outgoingTransactionsTestList;

    private static List<Transaction> incomingTransactionsTestListWeek;
    private static List<Transaction> outgoingTransactionsTestListWeek;

    private static List<Transaction> incomingTransactionsTestListMonth;
    private static List<Transaction> outgoingTransactionsTestListMonth;

    private static List<Transaction> incomingTransactionsTestList6Month;
    private static List<Transaction> outgoingTransactionsTestList6Month;

    private static StatisticData statisticTestData;
    private static User emptyUser;

    @BeforeAll
    static void setUp() {
        incomingTransactionsTestList = Arrays.asList(new Transaction(1L, "TestTransaction1", Type.INCOMING, new Category(1L,"TestCategory1", Type.INCOMING, null), null, 200.50, LocalDate.now()),
                new Transaction(2L, "TestTransaction1", Type.INCOMING, new Category(2L,"TestCategory2", Type.INCOMING, null), null, 100.50, LocalDate.now()));

        outgoingTransactionsTestList = Arrays.asList(new Transaction(3L, "TestTransaction1", Type.OUTGOING, new Category(3L,"TestCategory3", Type.OUTGOING, null), null, 200.50, LocalDate.now()),
                new Transaction(4L, "TestTransaction1", Type.OUTGOING, new Category(4L,"TestCategory4", Type.OUTGOING, null), null, 260.50, LocalDate.now()));

        incomingTransactionsTestListWeek = Arrays.asList(new Transaction(1L, "TestTransaction1", Type.INCOMING, new Category(1L,"TestCategory1", Type.INCOMING, null), null, 200.00, LocalDate.now()),
                new Transaction(2L, "TestTransaction1", Type.INCOMING, new Category(2L,"TestCategory2", Type.INCOMING, null), null, 100.00, LocalDate.now()));
        outgoingTransactionsTestListWeek = Arrays.asList(new Transaction(3L, "TestTransaction1", Type.OUTGOING, new Category(3L,"TestCategory3", Type.OUTGOING, null), null, 50.00, LocalDate.now()),
                new Transaction(4L, "TestTransaction1", Type.OUTGOING, new Category(4L,"TestCategory4", Type.OUTGOING, null), null, 150.00, LocalDate.now()));

        incomingTransactionsTestListMonth = Arrays.asList(new Transaction(1L, "TestTransaction1", Type.INCOMING, new Category(1L,"TestCategory1", Type.INCOMING, null), null, 1200.00, LocalDate.now()),
                new Transaction(2L, "TestTransaction1", Type.INCOMING, new Category(2L,"TestCategory2", Type.INCOMING, null), null, 1800.00, LocalDate.now()));
        outgoingTransactionsTestListMonth = Arrays.asList(new Transaction(3L, "TestTransaction1", Type.OUTGOING, new Category(3L,"TestCategory3", Type.OUTGOING, null), null, 50.00, LocalDate.now()),
                new Transaction(4L, "TestTransaction1", Type.OUTGOING, new Category(4L,"TestCategory4", Type.OUTGOING, null), null, 950.00, LocalDate.now()));

        incomingTransactionsTestList6Month = Arrays.asList(new Transaction(1L, "TestTransaction1", Type.INCOMING, new Category(1L,"TestCategory1", Type.INCOMING, null), null, 12000.0, LocalDate.now()),
                new Transaction(2L, "TestTransaction1", Type.INCOMING, new Category(2L,"TestCategory2", Type.INCOMING, null), null, 3000.0, LocalDate.now()));
        outgoingTransactionsTestList6Month = Arrays.asList(new Transaction(3L, "TestTransaction1", Type.OUTGOING, new Category(3L,"TestCategory3", Type.OUTGOING, null), null, 5000.0, LocalDate.now()),
                new Transaction(4L, "TestTransaction1", Type.OUTGOING, new Category(4L,"TestCategory4", Type.OUTGOING, null), null, 7000.0, LocalDate.now()));

        statisticTestData = new StatisticData(300.0,200.0,3000.0,1000.0,15000.0,12000.0);
        emptyUser = new User();
    }

    @Test
    @DisplayName("Statistic data for user test")
    void getStatisticDataForUser() {
        when(transactionsRepository.findAllByDateBetweenAndTypeAndUser(eq(LocalDate.now().minusDays(7)), eq(LocalDate.now()),eq(Type.INCOMING),any())).thenReturn(incomingTransactionsTestListWeek);
        when(transactionsRepository.findAllByDateBetweenAndTypeAndUser(eq(LocalDate.now().minusDays(7)), eq(LocalDate.now()),eq(Type.OUTGOING),any())).thenReturn(outgoingTransactionsTestListWeek);

        when(transactionsRepository.findAllByDateBetweenAndTypeAndUser(eq(LocalDate.now().minusMonths(1)), eq(LocalDate.now()),eq(Type.INCOMING),any())).thenReturn(incomingTransactionsTestListMonth);
        when(transactionsRepository.findAllByDateBetweenAndTypeAndUser(eq(LocalDate.now().minusMonths(1)), eq(LocalDate.now()),eq(Type.OUTGOING),any())).thenReturn(outgoingTransactionsTestListMonth);

        when(transactionsRepository.findAllByDateBetweenAndTypeAndUser(eq(LocalDate.now().minusMonths(6)), eq(LocalDate.now()),eq(Type.INCOMING),any())).thenReturn(incomingTransactionsTestList6Month);
        when(transactionsRepository.findAllByDateBetweenAndTypeAndUser(eq(LocalDate.now().minusMonths(6)), eq(LocalDate.now()),eq(Type.OUTGOING),any())).thenReturn(outgoingTransactionsTestList6Month);

        Assertions.assertEquals(statisticTestData, statisticService.getStatisticDataForUser(emptyUser));
    }

    @Test
    @DisplayName("Char data for user test")
    void getChartDataForUser() {

        when(transactionsRepository.findAllByDateAndTypeAndUser(eq(LocalDate.now()), eq(Type.INCOMING),any())).thenReturn(incomingTransactionsTestList);
        //when(transactionsRepository.findAllByDateAndTypeAndUser(eq(LocalDate.now()), eq(Type.OUTGOING),any())).thenReturn(outgoingTransactionsTestList);

        Assertions.assertArrayEquals(new double[]{301.0,0.0,0.0,0.0,0.0,0.0,0.0}, statisticService.getChartDataForUser(emptyUser).getIncomingSumsByDay());

        //Assertions.assertArrayEquals(new double[]{461.0,0.0,0.0,0.0,0.0,0.0,0.0}, statisticService.getChartDataForUser(emptyUser).getOutgoingSumsByDay());
        // TODO: Figure out why "PotentialStubbingProblem" exception is happening
    }
}