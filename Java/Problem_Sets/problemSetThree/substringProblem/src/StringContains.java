/**
 * Created by Taras on 10/7/2016.
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringContains
{
    public static void main(String[] args)
    {
        String haystack = "Java programming";
        String needle = "ogr";
        String needle_1 = "grammy";

        contains(haystack, needle); // True
        contains(haystack, needle_1); // False
    }

    public static void contains(String haystack, String needle)
    {
        Pattern x = Pattern.compile(needle);
        Matcher y = x.matcher(haystack); // get a matcher object

        int count = 0;

        while(y.find()){count++;}

        if (count > 0){System.out.println("This is a needle in the haystack.");}
        else System.out.println("This is not a needle in the haystack.");
    }
}
