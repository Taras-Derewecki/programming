public class Drama extends Movie {
    public Drama() {}

    @Override
    public double calculateLateFees(int daysLate) {
        double lateFee = 2.0;
        return lateFee * daysLate;
    }
}