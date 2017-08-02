/**
 * Created by Taras on 2/9/2017.
 */

/**
    Description:
        A New Alphabet has been developed for Internet communications. While the glyphs of the new alphabet don’t necessarily improve communications in any meaningful way, they certainly make us feel cooler.

        You are tasked with creating a translation program to speed up the switch to our more elite New Alphabet by automatically translating ASCII plaintext symbols to our new symbol set.

        The new alphabet is a one-to-many translation (one character of the English alphabet translates to anywhere between 1 and 6 other characters), with each character translation as follows:

        translate.png

        For instance, translating the string “Hello World!” would result in:

        [-]3110 \/\/0|Z1|)!

        Note that uppercase and lowercase letters are both converted, and any other characters remain the same (the exclamation point and space in this example).

        Input Format:

        Input contains one line of text, terminated by a newline. The text may contain any characters in the ASCII range 32–126 (space through tilde), as well as 9 (tab). Only characters listed in the above table (A–Z, a–z) should be translated; any non-alphabet characters should be printed (and not modified). Input has at most 10 000 characters.

        Output Format:

        Output the input text with each letter (lowercase and uppercase) translated into its New Alphabet counterpart.

        Sample Input:

        All your base are belong to us.

        Sample Output:

        @11 ‘/0|_||Z 8@$3 @|Z3 8310[]\[]6 ’][’0 |_|$.


 */

import java.io.*;
import java.util.*;

public class Solution
{
    public static void main(String[] args)
    {
        String[] alphabet = {"@", "8", "(", "|)", "3", "#", "6", "[-]", "|", "_|", "|<", "1", "[]\\/[]", "[]\\[]",
                             "0", "|D", "(,)", "|Z", "$", "']['", "|_|",
                             "\\/", "\\/\\/", "}{", "`/", "2"};

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine().toLowerCase();

        for(char c : input.toCharArray())
        {
            if(c <= 'z' && c >= 'a')
            {
                System.out.print(alphabet[c-'a']);
            }

            else
            {
                System.out.print(c);
            }
        }
        System.out.println();
    }
}