/**
 * Created by Taras on 2/9/2017.
 * <p>
 * Description:
 * A pangram is a phrase that includes at least one occurrence of each of the 26 letters, ‘a’...‘z’. You’re probably familiar with this one: “The quick brown fox jumps over the lazy dog.”
 * <p>
 * Your job is to recognize pangrams. For phrases that don’t contain every letter, report what letters are missing. We’ll say that a particular letter occurs in the phrase if it occurs as either upper case or lower case.
 * <p>
 * Input Format
 * <p>
 * Input starts with a line containing an integer N. The next N lines are each a single phrase, possibly containing upper and lower case letters, spaces, decimal digits and punctuation characters ‘.’, ‘,’, ‘?’, ‘!’, ‘’’ and ‘"’.
 * <p>
 * Constraints
 * <p>
 * 1 ≤ N ≤ 50
 * <p>
 * Each phrase contains at least one and no more than 100 characters.
 * <p>
 * Output Format
 * <p>
 * For each input phrase, output “pangram” if it qualifies as a pangram. Otherwise, output the word “missing” followed by a space and then the list of letters that didn’t occur in the phrase. The list of missing letters should be reported in lower case and should be sorted alphabetically.
 * <p>
 * Sample Input 0
 * <p>
 * 3
 * The quick brown fox jumps over the lazy dog.
 * ZYXW, vu TSR Ponm lkj ihgfd CBA.
 * .,?!'" 92384 abcde FGHIJ
 * Sample Output 0
 * <p>
 * pangram
 * missing eq
 * missing klmnopqrstuvwxyz
 */

/**
 Description:
 A pangram is a phrase that includes at least one occurrence of each of the 26 letters, ‘a’...‘z’. You’re probably familiar with this one: “The quick brown fox jumps over the lazy dog.”

 Your job is to recognize pangrams. For phrases that don’t contain every letter, report what letters are missing. We’ll say that a particular letter occurs in the phrase if it occurs as either upper case or lower case.

 Input Format

 Input starts with a line containing an integer N. The next N lines are each a single phrase, possibly containing upper and lower case letters, spaces, decimal digits and punctuation characters ‘.’, ‘,’, ‘?’, ‘!’, ‘’’ and ‘"’.

 Constraints

 1 ≤ N ≤ 50

 Each phrase contains at least one and no more than 100 characters.

 Output Format

 For each input phrase, output “pangram” if it qualifies as a pangram. Otherwise, output the word “missing” followed by a space and then the list of letters that didn’t occur in the phrase. The list of missing letters should be reported in lower case and should be sorted alphabetically.

 Sample Input 0

 3
 The quick brown fox jumps over the lazy dog.
 ZYXW, vu TSR Ponm lkj ihgfd CBA.
 .,?!'" 92384 abcde FGHIJ
 Sample Output 0

 pangram
 missing eq
 missing klmnopqrstuvwxyz
 */

import java.util.*;

public class Solution
{
    public static void main(String[] args)
    {
        //Init scanner
        Scanner scan = new Scanner(System.in);

        //Get amount of sentences
        int words = Integer.parseInt(scan.nextLine());

        //Run pangramOrNot for each sentence, and show its return (output) in the console
        for (int i = 0; i < words; ++i) {
            String sentence = scan.nextLine();
            System.out.println(pangramOrNot(sentence));
        }
    }

    public static String pangramOrNot(String word)
    {
        //HashSet that will hold each letter in our string (hash sets ignore duplicates, thats why its useful for this exercise)
        HashSet<Character> letters = new HashSet<>();

        //This hashset will contain the full alphabet
        HashSet alphabet = getAlphabet();

        //set the word to lowercase to not be bothered by capital letters
        word = word.toLowerCase();

        //Remove all special characters and blank spaces
        word = word.replaceAll("[^a-zA-Z]+", "");

        //Convert the users input sentence to a character array
        char[] characters = word.toCharArray();

        //iterate through the characters in the users input
        for (char character : characters)
        {
            //add each letter to the hashSet, if duplicate, the hashSet will ignore it
            letters.add(character);

            //Remove each character from the hash set, so we can print it in the end, it will end up containing the remaining characters
            alphabet.remove(character);
        }

        if (letters.size() < 26)
        {
            String output = "missing ";

            for (Object myChar : alphabet) {output += myChar.toString();}

            return output;

        }

        else {return "pangram";}
    }

    public static HashSet getAlphabet()
    {
        //This hashSet contains the whole alphabet
        HashSet alphabet = new HashSet();
        alphabet.add('a');
        alphabet.add('b');
        alphabet.add('c');
        alphabet.add('d');
        alphabet.add('e');
        alphabet.add('f');
        alphabet.add('g');
        alphabet.add('h');
        alphabet.add('i');
        alphabet.add('j');
        alphabet.add('k');
        alphabet.add('l');
        alphabet.add('m');
        alphabet.add('n');
        alphabet.add('o');
        alphabet.add('p');
        alphabet.add('q');
        alphabet.add('r');
        alphabet.add('s');
        alphabet.add('t');
        alphabet.add('u');
        alphabet.add('v');
        alphabet.add('w');
        alphabet.add('x');
        alphabet.add('y');
        alphabet.add('z');
        return alphabet;
    }
}