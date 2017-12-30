import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import java.text.DateFormatSymbols;

/**
 * Created by Taras on 10/7/2016.
 */
public class DateFormatter
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a valid integer value of a month(valid integer values are 1 - 12): ");
        int obtainMonth = scan.nextInt();

        while(obtainMonth < 1 || obtainMonth > 12)
        {
            try {validateMonth(obtainMonth);}
            catch(MonthException ex){System.err.print(ex.getMessage() + " ");}
            obtainMonth = scan.nextInt();
        }



        System.out.print("Enter a valid day(valid days are integer values of 1-31): ");
        int obtainDay = scan.nextInt();

        while(obtainDay < 1 || obtainDay > 31)
        {
            try{validateDay(obtainDay);}
            catch(DayException ex){System.err.print(ex.getMessage() + " ");}
            obtainDay = scan.nextInt();
        }



        System.out.print("Enter a valid year(valid integer values for years range from 1000 - 3000): ");
        int obtainYear = scan.nextInt();

        while(obtainYear < 1000 || obtainYear > 3000)
        {
            try{validateYear(obtainYear);}
            catch(YearException ex){System.err.print(ex.getMessage() + " ");}
            obtainYear = scan.nextInt();
        }



        System.out.println("You've entered: " + obtainMonth + "/" + obtainDay + "/" + obtainYear);
        System.out.println("OR");
        System.out.println(formatMonth(obtainMonth, Locale.ENGLISH) + " " + obtainDay + ", " + obtainYear);

    }

    public static boolean validateMonth(Integer value)
        throws MonthException
    {
        Integer val;

        try {val = Integer.valueOf(value);}
        catch(InputMismatchException e){throw new MonthException();}

        if(val < 1 || val > 12){throw new MonthException();}

        return true;
    }

    public static boolean validateDay(Integer value)
            throws DayException
    {
        Integer val;

        try {val = Integer.valueOf(value);}
        catch(InputMismatchException e){throw new DayException();}

        if(val < 1 || val > 31){throw new DayException();}

        return true;
    }

    public static boolean validateYear(Integer value)
            throws YearException
    {
        Integer val;

        try {val = Integer.valueOf(value);}
        catch(InputMismatchException e){throw new YearException();}

        if(val < 1000 || val > 3000){throw new YearException();}

        return true;
    }

    public static String formatMonth(int month, Locale locale)
    {
        DateFormatSymbols symbols = new DateFormatSymbols(locale);
        String[] monthNames = symbols.getMonths();
        return monthNames[month - 1];
    }
}
