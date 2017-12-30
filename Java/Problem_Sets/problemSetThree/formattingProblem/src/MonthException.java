/**
 * Created by Taras on 10/7/2016.
 */
public class MonthException extends Exception
{
    public MonthException(){super("The month you entered is outside the range of 1 - 12, try re-entering the month: ");}
    public MonthException(String message){super(message);}
}
