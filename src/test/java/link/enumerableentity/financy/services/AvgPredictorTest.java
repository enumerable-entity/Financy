package link.enumerableentity.financy.services;

import link.enumerableentity.financy.enums.Type;
import link.enumerableentity.financy.models.Category;
import link.enumerableentity.financy.models.Transaction;
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

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AvgPredictorTest {

    @Mock
    private TransactionsRepository transactionsRepository;

    @InjectMocks
    private AvgPredictor avgPredictor;

    private static List<Transaction> incomesTransactionsTestList;
    private static List<Transaction> outgoingsTransactionsTestList;

    @BeforeAll
    static void setUp() {
        incomesTransactionsTestList = Arrays.asList(
                new Transaction(1L,
                        "TestTransaction1",
                        Type.INCOMING,
                        new Category(1L,"TestCategory1", Type.INCOMING, null),
                        null,
                        200.50,
                        LocalDate.of(2022,01,13)),
                new Transaction(2L,
                        "TestTransaction1",
                        Type.INCOMING,
                        new Category(2L,"TestCategory2", Type.INCOMING, null),
                        null,
                        100.50,
                        LocalDate.of(2022,01,13)));
        outgoingsTransactionsTestList = Arrays.asList(
                new Transaction(3L,
                        "TestTransaction1",
                        Type.OUTGOING,
                        new Category(3L,"TestCategory3", Type.OUTGOING, null),
                        null,
                        200.50,
                        LocalDate.of(2022,01,13)),
                new Transaction(4L,
                        "TestTransaction1",
                        Type.OUTGOING,
                        new Category(4L,"TestCategory4", Type.OUTGOING, null),
                        null,
                        260.50,
                        LocalDate.of(2022,01,13)));

    }

    @Test()
    @DisplayName("Predicted data for user test")
    void getPredictedDataForUserTest() {

        when(transactionsRepository.findAllByDateBetweenAndTypeAndUser(
                LocalDate.now().minusMonths(6),
                LocalDate.now(),
                Type.INCOMING,
                null))
                .thenReturn(incomesTransactionsTestList);
        when(transactionsRepository.findAllByDateBetweenAndTypeAndUser(
                LocalDate.now().minusMonths(6),
                LocalDate.now(),
                Type.OUTGOING,
                null))
                .thenReturn(outgoingsTransactionsTestList);

        Assertions.assertEquals(150.5, avgPredictor.getPredictedDataForUser(null).getPredictedMonthIncomes());
        Assertions.assertEquals(230.5, avgPredictor.getPredictedDataForUser(null).getPredictedMonthExpenses());
    }
}