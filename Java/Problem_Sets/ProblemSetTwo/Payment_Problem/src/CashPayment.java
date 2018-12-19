public class CashPayment extends Payment {
    public CashPayment(double amount) {
        super.setAmount(amount);
    }
    public String paymentDetails() { return "Cash Payment: $"+ this.getAmount(); }
}