/**
 * Created by Taras on 9/20/2016.
 */

public class PaymentProblemMain
{
    public static void main(String[] args)
    {
        CashPayment cash_payment = new CashPayment(500.00);
        cash_payment.paymentDetails();

        CashPayment cash_payment_one = new CashPayment(250.00);
        cash_payment_one.paymentDetails();

        CreditCardPayment credit_payment = new CreditCardPayment("Tom", "08/24", 999999999,300.00);
        credit_payment.paymentDetails();

        CreditCardPayment credit_payment_one = new CreditCardPayment("Mike", "01/20", 666666666, 400.00);
        credit_payment_one.paymentDetails();


    }
}
