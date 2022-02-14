package com.financy.financyapp.services;

import com.financy.financyapp.enums.Type;
import com.financy.financyapp.models.Transaction;
import com.financy.financyapp.models.User;
import com.financy.financyapp.models.dto.ChartData;
import com.financy.financyapp.models.dto.StatisticData;
import com.financy.financyapp.repositories.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class StatisticService {

    private final TransactionsRepository transactionsRepository;

    @Autowired
    public StatisticService(TransactionsRepository transactionsRepository) {
        this.transactionsRepository = transactionsRepository;
    }

    public  StatisticData getStatisticDataForUser(User user) {
        return new StatisticData(calcLastWeekTotalIncomesAmount(user),
                calcLastWeekTotalExpensesAmount(user),
                calcLastMonthTotalIncomesAmount(user),
                calcLastMonthTotalExpensesAmount(user),
                calcLastSixMonthTotalIncomesAmount(user),
                calcLastSixMonthTotalExpensesAmount(user));

    }

    public  ChartData getChartDataForUser(User user) {
        double[] incomingSumsByDay = new double[7];
        double[] outgoingSumsByDay = new double[7];

        for (int i = 0; i < 7; i++){
            incomingSumsByDay[i] = transactionsRepository
                    .findAllByDateAndTypeAndUser(LocalDate.now().minusDays(i), Type.INCOMING, user)
                    .stream()
                    .map((x) -> x.getAmount())
                    .reduce(0.0, (a, b) -> a + b);
        }

        for (int i = 0; i < 7; i++){
            outgoingSumsByDay[i] = transactionsRepository
                    .findAllByDateAndTypeAndUser(LocalDate.now().minusDays(i), Type.OUTGOING, user).stream()
                    .map((x) -> x.getAmount())
                    .reduce(0.0, (a, b) -> a + b);
        }
        return new ChartData(incomingSumsByDay, outgoingSumsByDay);
    }

    private double calcLastWeekTotalIncomesAmount(User user) {
        return transactionsRepository
                .findAllByDateBetweenAndTypeAndUser(LocalDate.now().minusDays(7), LocalDate.now(),Type.INCOMING, user)
                .stream()
                .mapToDouble(Transaction::getAmount)
                .sum();
    }

    private double calcLastWeekTotalExpensesAmount(User user) {
        return transactionsRepository
                .findAllByDateBetweenAndTypeAndUser(LocalDate.now().minusDays(7), LocalDate.now(),Type.OUTGOING, user)
                .stream()
                .mapToDouble(Transaction::getAmount)
                .sum();
    }

    private double calcLastMonthTotalIncomesAmount(User user) {
        return transactionsRepository
                .findAllByDateBetweenAndTypeAndUser(LocalDate.now().minusMonths(1), LocalDate.now(),Type.INCOMING, user)
                .stream()
                .mapToDouble(Transaction::getAmount)
                .sum();
    }

    private double calcLastMonthTotalExpensesAmount(User user) {
        return transactionsRepository
                .findAllByDateBetweenAndTypeAndUser(LocalDate.now().minusMonths(1), LocalDate.now(),Type.OUTGOING, user)
                .stream()
                .mapToDouble(Transaction::getAmount)
                .sum();
    }

    private double calcLastSixMonthTotalIncomesAmount(User user) {
        return transactionsRepository
                .findAllByDateBetweenAndTypeAndUser(LocalDate.now().minusMonths(6), LocalDate.now(),Type.INCOMING, user)
                .stream()
                .mapToDouble(Transaction::getAmount)
                .sum();
    }

    private double calcLastSixMonthTotalExpensesAmount(User user) {
        return transactionsRepository
                .findAllByDateBetweenAndTypeAndUser(LocalDate.now().minusMonths(6), LocalDate.now(), Type.OUTGOING, user)
                .stream()
                .mapToDouble(Transaction::getAmount)
                .sum();
    }
}
