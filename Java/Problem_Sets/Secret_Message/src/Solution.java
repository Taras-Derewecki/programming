import java.util.Scanner;
import java.lang.*;

import static java.lang.StrictMath.ceil;
import static java.lang.StrictMath.sqrt;

/**
 * Created by Taras on 3/22/2017.
 */

/*

Jack and Jill developed a special encryption method, so they can enjoy conversations without worrying about eavesdroppers.

Here is how:
    let L be the length of the original message, and M be the smallest square number greater than or equal to L.
    Add (M - L) asterisks to the message, giving a padded message with length M.
    Use the padded message to fill a table of size K × K, where K2 = M.
    Fill the table in row-major order (top to bottom row, left to right column in each row).
    Rotate the table 90 degrees clockwise.
    The encrypted message comes from reading the message in row-major order from the rotated table, omitting any asterisks.

For example, given the original message ‘iloveyouJack’, the message length is L = 12.
Thus the padded message is ‘iloveyouJack**’, with length M = 16. Below are the two tables before and after rotation.

___________________
|| i | l | o | v ||
|-----------------|
|| e | y | o | u ||
|-----------------|
|| J | a | c | k ||
|-----------------|
|| * | * | * | * ||
___________________

        |
        v

___________________
|| * | J | e | i ||
|-----------------|
|| * | a | y | l ||
|-----------------|
|| * | c | o | o ||
|-----------------|
|| * | k | u | v ||
___________________


Then we read the secret message as ‘Jeiaylcookuv’.

Input Format:
    The first line of input is the number of original messages, N.
    The following N lines each have a message to encrypt.
    Each message contains only characters a–z (lower and upper case), and has length L.

Constraints:
    1 ≤ N ≤ 100
    1 ≤ L ≤ 10,000

Output Format:
    For each original message, output the secret message.

    Sample Input 0:

        2
        iloveyoutooJill
        TheContestisOver


    Sample Output 0:

        iteiloylloooJuv
        OsoTvtnheiterseC

 */
public class Solution
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String numOfMessages = scan.next();
        Integer numOfRealMessages = Integer.parseInt(numOfMessages); // attempt at getting rid of the extra "/n"
        Boolean done = false;

        while(numOfRealMessages != 0)
        {
            String originalMessage = scan.next();                       // What's the message??
            Integer n = (int) ceil(sqrt(originalMessage.length()));     // This is how long the n x n matrix should be based on user input of the originalMessage
            Character[][] message = new Character[n][n];                // First element is rows, second element is columns
            Integer index = 0;                                          // Keep track of all the letters pushing through the matrix

            // Creating the matrix, and populating it with the original message:
            for(int r = 0; r < n && !done; r++)
            {
                for(int c = 0; c < n && !done; c++)
                {
                    // Pushing the characters of the string, "originalMessage" into the matrix:
                    if(index < originalMessage.length()) {message[r][c] = originalMessage.charAt(index++);}
                    else {message[r][c] = '*';}
                    //System.out.print(message[r][c]); // Prints what's in the matrix
                }
//                System.out.println(); // See where the characters are in the matrix for debugging purposes
            }

            // Read the matrix from bottom to top to simulate rotation
            for(int c = 0; c < n && !done; c++)
            {
                for (int r = (n - 1); r >= 0 && !done; r--)
                {
                   if(message[r][c]!='*') {System.out.print(message[r][c]);}
                }
            }
            numOfRealMessages--;
            System.out.println();
        }
    }
}