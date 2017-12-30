/**
 * Created by Taras on 2/9/2017.

       Description:
         Some numbers are just, well, odd. For example, the number 3 is odd, because it is not a multiple of two. Numbers that are a multiple of two are not odd, they are even. More precisely, if a number n can be expressed as n = 2 × k for some integer k, then n is even. For example, 6 = 2 × 3 is even.

         Some people get confused about whether numbers are odd or even. To see a common example, do an internet search for the query “is zero even or odd?” (Don’t search for this now! You have a problem to solve!)

         Write a program to help these confused people.

         Input Format

         Input begins with an integer n on a line by itself, indicating the number of test cases that follow. Each of the following n lines contain a test case consisting of a single integer x.

         Constraints

         1 ≤ n ≤ 20

         −10 ≤ x ≤ 10

         Output Format

         For each x, print either ‘x is odd’ or ‘x is even’ depending on whether x is odd or even.

         Sample Input 0

         3
         10
         9
         -5
         Sample Output 0

         10 is even
         9 is odd
         -5 is odd
 */


import java.io.*;
import java.util.*;

public class Solution
{
    public static void main(String[] args)
    {
        System.out.print("Enter how many integers you want to determine if it is odd or even: ");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();


        for(int i = 0; i < n; i++)
        {
            System.out.print("Enter the requested integer: ");
            int x = scan.nextInt();
            if(x % 2 == 0) { System.out.println(x + " is even");}
            else {System.out.println(x + " is odd");}
        }
    }
}