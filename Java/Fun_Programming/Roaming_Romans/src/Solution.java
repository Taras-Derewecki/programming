/***********************************************************************************************************************
The English word “mile” derives from the Latin “mille passus”, meaning “a thousand paces”.
A Roman mile was the distance a soldier would walk in 1000 paces (a pace being two steps, one with each foot).

Over time, the actual distance referred to as a “mile” has changed. The modern English mile is 5,280 (modern) feet.
The Roman mile is believed to have been about 4,854 (modern) feet.

Write a program to convert distances in English miles into Roman miles and paces.

Input Format:

    Input will consist of one or more lines,
    each containing a single positive floating point number denoting a distance in English miles.
    End of input is indicated by a value of 0.0.

Output Format:

    For each input value, print a line of output of the form:

        X English miles equals Y Roman miles or K paces.

    where X is the value from the input, Y is the equivalent distance in Roman miles.
    Each of these should be printed to 2 decimal digits precision.
    K is an integer denoting the number of paces, and should be rounded to the closest integer.

Sample Input 0:

1.0
20.267
454
0.0

Sample Output 0:

1.00 English miles equals 1.09 Roman miles or 1088 paces.
20.27 English miles equals 22.05 Roman miles or 22046 paces.
454.00 English miles equals 493.84 Roman miles or 493844 paces.

 **********************************************************************************************************************/

import java.util.*;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        double romanMiles;
        double numOfPaces;
        int numOfRoundedPaces;
        boolean isNotZero = true;

        while( isNotZero )
        {
            double englishMiles = scan.nextDouble();
            if( englishMiles != 0.0 )
            {
                romanMiles = ((englishMiles * 5280) / 4854); // Print to 2 decimal digits of precision.
                numOfPaces = romanMiles * 1000;              // Round to the closest integer.

                numOfRoundedPaces = (int) Math.round(numOfPaces);

                System.out.printf( "%.2f", englishMiles );
                System.out.print( " English miles equals " );
                System.out.printf( "%.2f", romanMiles );
                System.out.println( " Roman miles or " + numOfRoundedPaces +" paces." );
            }

            else isNotZero = false;
        }
    }
}