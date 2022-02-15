package link.enumerableentity.financy.models.dto;

public class PredictorData {

    private final double predictedMonthExpenses;
    private final double predictedMonthIncomes;

    public PredictorData(double predictedMonthExpenses, double predictedMonthIncomes) {
        this.predictedMonthExpenses = predictedMonthExpenses;
        this.predictedMonthIncomes = predictedMonthIncomes;
    }

    public double getPredictedMonthExpenses() {
        return predictedMonthExpenses;
    }

    public double getPredictedMonthIncomes() {
        return predictedMonthIncomes;
    }
}
