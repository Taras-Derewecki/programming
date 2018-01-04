/*
Let’s face it... you are not that handy. When you need to make a major home repair, you often need to hire someone to help.
When they come for the first visit, they make an estimate of the cost. Here they must be careful: if they overestimate the cost,
it might scare you off, but if they underestimate, the work might not be worth their time.

Because the worker is so careful, it can take a long time for them to produce the estimate.
But that’s frustrating — when you ask for an estimate, you really are asking for the magnitude of the cost.
Will this be 10 or 100 or 1 000? That’s all you really want to know on a first visit.

Please help the worker make the type of estimate you desire.
Write a program that, given the worker’s estimate, reports just the magnitude of the cost —
the number of digits needed to represent the estimate

Input Format:

    Input begins with a line containing an integer N (1 ≤ N ≤ 100).
    The next N lines each contain one estimated cost, which is an integer between 0 and 10100.
    (Some of the workmen overcharge quite a bit.)

Output Format:

    For each estimated cost, output the number of digits required to represent it.

Sample Input:

5
314
1
5926
5
35897

Sample Output:

3
1
4
1
5
 */

import java.math.BigInteger;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args)
    {
        BigInteger job;
        int magnitude;

        Scanner scan = new Scanner(System.in);
        int numOfJobs = scan.nextInt();

        for ( int i = 0; i < numOfJobs; i++ )
        {
            job = scan.nextBigInteger();
            String jobInStringFormat = String.valueOf(job);
            magnitude = jobInStringFormat.length();
            System.out.println(magnitude);
        }
    }
}