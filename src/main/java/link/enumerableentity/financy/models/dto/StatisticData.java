package link.enumerableentity.financy.models.dto;

import java.util.Objects;

public class StatisticData {

    private final double lastWeekTotalIncomesAmount;
    private final double lastWeekTotalExpensesAmount;

    private final double lastMonthTotalIncomesAmount;
    private final double lastMonthTotalExpensesAmount;

    private final double lastSixMonthTotalIncomesAmount;
    private final double lastSixMonthTotalExpensesAmount;

    public StatisticData(double lastWeekTotalIncomesAmount,
                         double lastWeekTotalExpensesAmount,
                         double lastMonthTotalIncomesAmount,
                         double lastMonthTotalExpensesAmount,
                         double lastSixMonthTotalIncomesAmount,
                         double lastSixMonthTotalExpensesAmount) {
        this.lastWeekTotalIncomesAmount = lastWeekTotalIncomesAmount;
        this.lastWeekTotalExpensesAmount = lastWeekTotalExpensesAmount;
        this.lastMonthTotalIncomesAmount = lastMonthTotalIncomesAmount;
        this.lastMonthTotalExpensesAmount = lastMonthTotalExpensesAmount;
        this.lastSixMonthTotalIncomesAmount = lastSixMonthTotalIncomesAmount;
        this.lastSixMonthTotalExpensesAmount = lastSixMonthTotalExpensesAmount;
    }

    public double getLastWeekTotalIncomesAmount() {
        return lastWeekTotalIncomesAmount;
    }

    public double getLastWeekTotalExpensesAmount() {
        return lastWeekTotalExpensesAmount;
    }

    public double getLastMonthTotalIncomesAmount() {
        return lastMonthTotalIncomesAmount;
    }

    public double getLastMonthTotalExpensesAmount() {
        return lastMonthTotalExpensesAmount;
    }

    public double getLastSixMonthTotalIncomesAmount() {
        return lastSixMonthTotalIncomesAmount;
    }

    public double getLastSixMonthTotalExpensesAmount() {
        return lastSixMonthTotalExpensesAmount;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatisticData that = (StatisticData) o;
        return Double.compare(that.lastWeekTotalIncomesAmount, lastWeekTotalIncomesAmount) == 0 && Double.compare(that.lastWeekTotalExpensesAmount, lastWeekTotalExpensesAmount) == 0 && Double.compare(that.lastMonthTotalIncomesAmount, lastMonthTotalIncomesAmount) == 0 && Double.compare(that.lastMonthTotalExpensesAmount, lastMonthTotalExpensesAmount) == 0 && Double.compare(that.lastSixMonthTotalIncomesAmount, lastSixMonthTotalIncomesAmount) == 0 && Double.compare(that.lastSixMonthTotalExpensesAmount, lastSixMonthTotalExpensesAmount) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastWeekTotalIncomesAmount, lastWeekTotalExpensesAmount, lastMonthTotalIncomesAmount, lastMonthTotalExpensesAmount, lastSixMonthTotalIncomesAmount, lastSixMonthTotalExpensesAmount);
    }
}
