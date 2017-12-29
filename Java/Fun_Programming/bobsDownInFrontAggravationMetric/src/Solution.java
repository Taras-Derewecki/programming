import java.util.Scanner;

/********************************************************************************************************************************************************
Created by Taras on 7/14/2017.


Nothing bothers Bob more than when taller people stand up in front and block his view at sporting events.
It bothers him so much, that he has developed a measure for the displeasure that a crowd feels because of this phenomenon.
Most days, he calls his measure the Index of Identifiable Inversions.
Although when his view is blocked by this phenomenon, he calls it the "Down In Front" Aggravation Metric.

The measure works as follows. In a line of standing people, the measure is equal to the number of people who are blocking others' views.
Person A is blocking B's view, if

1. A is taller than B

2. A is standing in front of B

3. There is no one of equal height or taller than A in line between A and B

Assuming that everyone is standing, the line below has a "Down in Front" Aggravation Measure of 5.
Bob's view is blocked by Alice, Chuck's view is blocked by Alice, Dave's view is blocked by both Chuck and Alice, and Eve's view is blocked by Alice.

Input Format:

    The input consists of an initial line with an integer n, 0 < n < 10,000 on a line by itself representing the number of people standing in line.
    The rest of the lines give the line configuration, starting at the front of the line and going in order, in the following format:

    Name Feet Inches

Where

    Name is a person's first name (an alphabetic string containing no spaces).
    Feet is a integer from 0 to 8, inclusive, that indicates the feet portion of a person's height.
    Inches is an integer between 0 and 11 inclusive that represents the inches portion of a person's height.

Output Format:

    The output of the program should be a single integer representing the Index of Indentifiable Inversions of the configuration.

Sample Input:

    5
    Alice 5 10
    Bob 5 8
    Chuck 5 8
    Dave 5 6
    Eve 5 8

Sample Output:

    5

Explanation:

    There are five aggravations:
    Bob is aggravated by Alice.
    Chuck is aggravated by Alice.
    Dave is aggravated by Alice and Chuck.
    Eve is aggravated by Alice.
********************************************************************************************************************************************************/

public class Solution
{
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);

        Integer aggravations = 0;
        Integer reps = scan.nextInt();

        Integer[] height = new Integer[reps]; // make a reps-sized array

        for (int i = 0; i < reps; i++) // get the input
        {
            String name = scan.next();
            Integer feet = scan.nextInt();
            Integer inches = scan.nextInt();
            height[i] = feet * 12 + inches;   // add to the array
            // System.out.println("Just added " + values[i] + " to the array");
        }


        // At this point, the values[] array is a list of
        // everyone's height in inches.


        // THIS version just counts raw inversions.
        //--------------------------------------------------
        //for (int i = 0; i < reps - 1; i++) // for every value in the list...
        //{
        //    for (int j = i + 1; j < reps; j++) // look at every SUBSEQUENT value
        //    {
        //        if (values[j] > values[i]) aggravations++;
        //    }
        //}
        //-------------------------------------------------



        for (int i = reps-1; i > 0; i--) // let i scan right-to-left
        {
            Integer maxInFront = height[i];         // How tall is THIS person?
            for (int j = i-1; j >= 0; j--)      // for everyone in front of them
            {
                if (height[j] > maxInFront)  // if they're taller than
                {                            // anyone we've seen so far,
                    maxInFront = height[j];  // then we have a new "tallest" so
                    aggravations++;          // far, AND another aggravation
                }
            }
        }

        System.out.println(aggravations);
    }
}