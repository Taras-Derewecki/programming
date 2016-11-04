/**
 * Created by Taras on 10/7/2016.
 */
public class YearException extends Exception
{
    public YearException(){super("The year you entered is outside the range of 1000 - 3000, try re-entering the year: ");}
    public YearException(String message){super(message);}
}
