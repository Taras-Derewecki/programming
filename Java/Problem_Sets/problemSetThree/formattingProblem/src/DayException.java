/**
 * Created by Taras on 10/7/2016.
 */
public class DayException extends Exception
{
    public DayException(){super("The day you entered is outside the range of 1- 31, try re-entering the day: ");}
    public DayException(String message){super(message);}
}
