/**
 * Created by Taras_Derewecki on 9/20/16.
 */
public class CashPayment extends Payment
{
    private double cashPayment; // instance data

    //public CashPayment() {super.setStorePayment(getCashPayment());} // constructor

    public CashPayment(double cashPayment)  // constructor
    {
        super(cashPayment);
    }

//    public void setCashPayment(double cp) {this.cashPayment = cp;} // setter

//    public double getCashPayment() {return cashPayment;} // getter

    public void paymentDetails() // method
    {
        System.out.print("Cash Payment: $");
        System.out.println(getStorePayment());
        System.out.println();
    }
}
