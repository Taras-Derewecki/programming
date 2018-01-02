/*************************************************************************************************************************************************************
You have a set of N blocks, where each block contains a unique integer greater than 0 and less than or equal to N. You like to line them up on the floor to
create the sequence 1, 2, 3, …, (N - 1), N. However your cat Monte also likes to play with these blocks and randomly steals and hides one and only one block
and then rearranges the remaining blocks in order to hide his crime. You need to write a program to determine which number is missing from the sequence.

Notes: Since you may have a lot of input to read, please do the following:
    If you are using C++, put the following line as the first statement in your main method: std::ios_base::sync_with_stdio (false);
    If you are using Java, use the Reader class to read input. It is provided in the template for Java.

Input Format:
    Input will consist of a single integer M on the first line, where 1 ≤ M ≤ 10,000,000, where M represents the number of blocks remaining. This will be
    followed by M unique integers, one per line, where each integer is at least 1 and at most M + 1, representing the numbers remaining.

Output Format:
    Output should consist of a single integer representing the number that is missing from the sequence.

Sample Input:
10
7
3
11
9
2
8
6
1
5
10

Sample Output:
4
 **************************************************************************************************************************************************************/
import java.io.*;
import java.util.*;
import java.io.IOException;


public class Solution
{
    public static void main(String[] args) throws IOException
    {
        Reader.init(System.in);
        int m = Reader.nextInt();
        int initTotal = 0;
        
        for( int i = (m + 1); i > 0; i-- ) 
            initTotal = initTotal + i;
        
        int missing = initTotal;

        for( int i = m; i > 0; i-- ) 
            missing -= Reader.nextInt(); 
        
        System.out.println(missing);       
    }
}

/** Class for buffered reading int and double values */
class Reader
{
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input)
    {
        reader = new BufferedReader(
                new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String next() throws IOException
    {
        while ( !tokenizer.hasMoreTokens() )
        {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                    reader.readLine() );
        }

        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException
        { return Integer.parseInt( next() ); }

    static double nextDouble() throws IOException
        { return Double.parseDouble( next() ); }
}