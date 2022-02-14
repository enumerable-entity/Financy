package com.financy.financyapp.models.dto;

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


}
