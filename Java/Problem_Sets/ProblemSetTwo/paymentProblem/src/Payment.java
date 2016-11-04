/**
 * Created by Taras_Derewecki on 9/20/16.
 */
public class Payment
{
    protected double storePayment; // instance data

    public Payment(double storePayment) {this.storePayment = storePayment;} // constructor

    public double getStorePayment() {return storePayment;} // getter

    public void setStorePayment(double storePayment) {this.storePayment = storePayment;} // setter

    public void paymentDetails() // method
    {
        System.out.print("Your payment was: ");
        System.out.println(getStorePayment());
    }

}
