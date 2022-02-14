package com.financy.financyapp.services;

import com.financy.financyapp.emums.Type;
import com.financy.financyapp.models.User;
import com.financy.financyapp.models.dto.PredictorData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AvgPredictor implements Predictor{

    private final TransactionRepository transactionRepository;

    @Autowired
    public AvgPredictor(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
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
