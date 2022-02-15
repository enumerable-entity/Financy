package link.enumerableentity.financy.services;

import link.enumerableentity.financy.enums.Type;
import link.enumerableentity.financy.models.Transaction;
import link.enumerableentity.financy.models.User;
import link.enumerableentity.financy.models.dto.PredictorData;
import link.enumerableentity.financy.repositories.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
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
