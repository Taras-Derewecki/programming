public class Comedy extends Movie {
    public Comedy() {}

    @Override
    public double calculateLateFees(int daysLate) {
        double lateFee = 2.5;
        return lateFee * daysLate;
    }
}