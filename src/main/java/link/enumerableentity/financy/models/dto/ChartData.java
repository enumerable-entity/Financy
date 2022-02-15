package link.enumerableentity.financy.models.dto;

public class ChartData {

    /**
     * Array that holds sums for incomes by day. Index 0 = sum of today incomes. Next index = one day to past
     */
    private final double[] incomingSumsByDay;
    private final double[] outgoingSumsByDay;


    public ChartData(double[] incomingSumsByDay, double[] outgoingSumsByDay) {
        this.incomingSumsByDay = incomingSumsByDay;
        this.outgoingSumsByDay = outgoingSumsByDay;
    }

    public double[] getIncomingSumsByDay() {
        return incomingSumsByDay;
    }
    public double[] getOutgoingSumsByDay() {
        return outgoingSumsByDay;
    }
}
