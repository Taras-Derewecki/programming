/**
 * Created by Taras_Derewecki on 9/20/16.
 */

public class CreditCardPayment extends Payment
{
    // instance data
    private String cardHolderName;
    private String expDate;
    private long ccNumber;

    // constructor
    public CreditCardPayment(String cardHolderName, String expDate, long ccNumber, double storePayment)
    {
        super(storePayment);
        this.cardHolderName = cardHolderName;
        this.expDate = expDate;
        this.ccNumber = ccNumber;
    }

    // setters (mutators)
    public void setCardHolderName(String cardHolderName){this.cardHolderName = cardHolderName;}
    public void setExpDate(String expDate){this.expDate = expDate;}
    public void setCcNumber(long ccNumber){this.ccNumber = ccNumber;}

    // getters (accessors)
    public String getCardHolderName() {return cardHolderName;}
    public String getExpDate() {return expDate;}
    public long getCcNumber() {return ccNumber;}

    // method
    public void paymentDetails()
    {
        System.out.println("Credit Card Information: ");
        System.out.println("Credit Card Payment: $" + getStorePayment());
        System.out.println("Card Holder Name: " + getCardHolderName());
        System.out.println("Expiration Date: " + getExpDate());
        System.out.println("Credit Card Number: " + getCcNumber());
        System.out.println();
    }
}
