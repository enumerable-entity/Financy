package com.financy.financyapp.services;

import com.financy.financyapp.enums.Type;
import com.financy.financyapp.models.Transaction;
import com.financy.financyapp.models.User;
import com.financy.financyapp.models.dto.PredictorData;
import com.financy.financyapp.repositories.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class AvgPredictor implements Predictor{

    private final TransactionsRepository transactionsRepository;

    @Autowired
    public AvgPredictor(TransactionsRepository transactionsRepository) {
        this.transactionsRepository = transactionsRepository;
    }

    @Override
    public PredictorData getPredictedDataForUser(User user) {
        return new PredictorData(getPredictedMonthExpensesForUser(user),getPredictedMonthIncomesForUser(user));
    }

    private double getPredictedMonthExpensesForUser(User user) {
        return transactionsRepository.findAllByDateBetweenAndTypeAndUser(LocalDate.now().minusMonths(6), LocalDate.now(), Type.OUTGOING, user)
                .stream()
                .mapToDouble(Transaction::getAmount)
                .average()
                .orElse(0d);
    }

    private double getPredictedMonthIncomesForUser(User user) {
        return transactionsRepository.findAllByDateBetweenAndTypeAndUser(LocalDate.now().minusMonths(6), LocalDate.now(), Type.INCOMING, user).stream()
                .mapToDouble(Transaction::getAmount)
                .average()
                .orElse(0d);
    }
}
