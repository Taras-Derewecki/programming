public class Action extends Movie {
    public Action() {}

    @Override
    public double calculateLateFees(int daysLate) {
        double lateFee = 3.0;
        return lateFee * daysLate;
    }
}