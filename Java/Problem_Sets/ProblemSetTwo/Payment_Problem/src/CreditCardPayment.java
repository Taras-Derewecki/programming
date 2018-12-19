public class CreditCardPayment extends Payment {

    private String name;
    private String expiryDate;
    private long cardNumber;

    public String getName() { return name; }
    public String getExpiryDate() { return expiryDate; }
    public long getCardNumber() { return cardNumber; }

    public void setExpiryDate(String expiryDate) { this.expiryDate = expiryDate; }
    public void setName(String name) { this.name = name; }
    public void setCardNumber(long cardNumber) { this.cardNumber = cardNumber; }


    public CreditCardPayment(double amount,String name, String expiryDate, long cardNumber) {
        super.setAmount(amount);
        this.name = name;
        this.expiryDate = expiryDate;
        this.cardNumber = cardNumber;
    }

    public String paymentDetails() {
        return "Payment: $" + this.getAmount() +
                "\nPayment made by " + this.getName() +
                "\nCredit Card Number: "+ this.getCardNumber() +
                "\nExpiration Date: " + this.getExpiryDate() + "\n";
    }

    public static void main(String args[]) {
        CashPayment p1 = new CashPayment(1199.99);
        System.out.println(p1.paymentDetails() +"\n");

        CashPayment p2 = new CashPayment(699.99);
        System.out.println(p2.paymentDetails() +"\n");

        CreditCardPayment p3 = new CreditCardPayment(799.99, "Melusky",
                "09/2017",8473645893010233l) ;
        System.out.println(p3.paymentDetails());

        CreditCardPayment p4 = new CreditCardPayment(1542.12, "Mike",
                "07/2021",2998880987652341l) ;
        System.out.println(p4.paymentDetails());
    }
}