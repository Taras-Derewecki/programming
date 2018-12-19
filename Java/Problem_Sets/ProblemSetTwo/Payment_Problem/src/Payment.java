public class Payment {
    private double amount;
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public String paymentDetails() { return "Payment: $"+ this.getAmount(); }
}