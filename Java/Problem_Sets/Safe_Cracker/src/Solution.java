/**
 * Created by Taras on 4/18/2017.
 */

/********************************************************************************************************************************************************************************************

Safe Cracker (find shortest unlock path)

In this problem you are to write a program that assists a safecracker in opening a digital lock. The digital lock has an n-digit code (0 < n ≤ 7).
The interface to the lock with a 4-digit code looks as in Figure 1. For each slot in the lock there are two buttons for scrolling the digit up or down.
Each press of a button will scroll the corresponding digit up or down by one. Through inside information, our safecracker knows what the secret code is.
We call this secret code the target code. She also knows a list of forbidden n-digit codes that she should avoid while manipulating the lock.
If the lock digits are set to one of these forbidden codes an alarm will sound, which is not a good thing for safecrackers.
Your task is to write a program that will figure out the fastest way for our safe-cracker to get from the current combination on the lock,
called the starting code, to the n-digit target code without going through any of the forbidden codes.



(Up Button)          (Up Button)             (Up Button)          (Up Button)
     0                    3                       1                    4
(Down Button)        (Down Button)           (Down Button)        (Down Button)



Input Format:
    The program takes, via standard input, the following information:
        On the first line is the integer n specifying the number of digits in the lock.
        On the next line is the n-digit starting code.
        On the third line is the n-digit target code.
        On the fourth line is an integer f, 0 ≤ f ≤ 10n.
        On the following f lines are the forbidden codes, specified one per line.

Output Format:
The program must write to standard output. The format is as follows.
    If it is not possible to reach the target code from the starting code without using a forbidden code, the program writes a −1 to the standard output and terminates.
    Note this should also be the output if the starting code or target code is a forbidden code.
    Otherwise, the program writes to the standard output a number k, representing the minimum number of steps to get from the starting code to the target code without using a forbidden code.
    At each step one of the buttons is pushed. Each of the next k output lines shows the k steps and the result of each step.

    Each line has the following format:
        mB code

        where B is taken from the set {1, 2, …, n}, and represents the digit position with 1 being the leftmost, m is taken from the set {U,D},
        and represents the button, up (U) or down (D), and code represents the resulting code after the indicated button is pushed.
        Note that if a digit is currently 0, pushing the down button will bring up 9. Similarly, if a digit is currently 9, pushing the up button will bring up 0.
        Furthermore, if there is more than one sequence of steps with which you can reach the target, you should output the one that is lexicographically smallest.

Sample Input 0:

4
5555
7777
4
6555
5655
5565
5556

Sample Output 0:

10
D1 4555
U2 4655
U2 4755
U1 5755
U1 6755
U1 7755
U3 7765
U3 7775
U4 7776
U4 7777

Explanation 0:
    There are multiple sequences of steps that can move us from our start state to our target state in 10 steps. Here are a few of them:

        D1, U2, U2, U1, U1, U1, U3, U3, U4, U4
        D1, U2, U2, U1, U1, U1, U3, U4, U4, U3
        D1, U2, U2, U1, U1, U3, U3, U4, U4, U1
        D1, U2, U3, U1, U1, U1, U3, U4, U4, U2

        Out of all of the possible sequences of length 10 that crack the safe, the one that comes first in lexicographical order is the one the first one specified in the list above,
        so this is the one that we use in the output.

Sample Input 1:

2
44
99
0

Sample Output 1:

10
D1 34
D1 24
D1 14
D1 04
D1 94
D2 93
D2 92
D2 91
D2 90
D2 99

Sample Input 2:

7
9196623
1978441
0

Sample Output 2:

14
D2 9096623
D2 9996623
D3 9986623
D3 9976623
D5 9976523
D5 9976423
D7 9976422
D7 9976421
U1 0976421
U1 1976421
U4 1977421
U4 1978421
U6 1978431
U6 1978441

Sample Input 3:

7
1234567
2345678
3
2222222
1234567
3333333

Sample Output 3:

-1

Sample Input 4:

7
1234567
2345678
10
0000000
1111111
2222222
4444444
2345678
3333333
5555555
6666666
7777777
9999999

Sample Output 4:

-1

Sample Input 5:

3
222
888
0

Sample Output 5:

12
D1 122
D1 022
D1 922
D1 822
D2 812
D2 802
D2 892
D2 882
D3 881
D3 880
D3 889
D3 888

********************************************************************************************************************************************************************************************/
import java.util.*;

public class Solution
{

    public static void reverse(String string, int d)
    {
        if(string.equals(beginning)) {return;}

        Integer j = Integer.parseInt(string);

        reverse(parent[j],d - 2);

        System.out.println(tree[j].substring(tree[j].length() - 2, tree[j].length()) + " " + string);
    }

    static String[] parent, tree;
    static String beginning, last;
    static String answer_string = "";
    static Integer alarmCode, number, answer;

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        Integer x;
        answer = 10000000;
        number = scan.nextInt();
        beginning = scan.next();
        last = scan.next();
        alarmCode = scan.nextInt();
        boolean[] bannedArray = new boolean[(int)Math.pow(10, number) + 1];
        parent = new String[(int)Math.pow(10, number) + 1];
        tree = new String[(int)Math.pow(10, number) + 1];

        for(x = 0; x < (int)Math.pow(10, number) + 1; x++)
        {
            bannedArray[x] = false;
            parent[x] = "";
            tree[x] = "";
        }

        for(x = 0; x < alarmCode; x++) {bannedArray[scan.nextInt()]=true;}

        if(bannedArray[Integer.parseInt(beginning)] == true || bannedArray[Integer.parseInt(last)] == true)
        {
            System.out.println("-1");
            return;
        }

        Queue<String> queue = new LinkedList<>();

        queue.add(beginning);
        int[] counter = new int[(int)Math.pow(10, number) + 1];
        counter[Integer.parseInt(beginning)] = 0;

        while(!queue.isEmpty())
        {
            String string = queue.remove();
            int g = Integer.parseInt(string);

            if(counter[g] > answer) {break;}

            for(x = 0; x < number; x++)
            {
                char[] arr = string.toCharArray();
                arr[x]--;

                if(arr[x]<'0') {arr[x]='9';}

                String f = new String(arr);
                Integer d = Integer.parseInt(f);

                if(parent[d] == "" && bannedArray[d] == false)
                {
                    parent[d] = string;
                    tree[d] = tree[g]+ "D" + Integer.toString(x + 1);
                    counter[d] = counter[g] + 1;
                    queue.add(f);
                }

                else if(parent[d] != "" && counter[g] + 1 <= counter[d] && tree[g].compareTo(tree[Integer.parseInt(parent[d])]) < 0)
                {
                    if(d == 9976421) {System.out.println("2");}
                    parent[d] = string;
                    tree[d] = tree[g] + "D" + Integer.toString(x + 1);
                    counter[d] = counter[g] + 1;
                    queue.add(f);
                }

                if(f.equals(last))
                {
                    if(counter[d] < answer)
                    {
                        answer = counter[d];
                        answer_string = tree[d];
                    }

                    else if(counter[d] == answer && answer_string.compareTo(tree[d]) < 0) {answer_string = tree[d];}
                }

                arr = string.toCharArray();
                arr[x]++;
                if(arr[x]> '9') {arr[x] = '0';}

                f = new String(arr);
                d = Integer.parseInt(f);

                if(parent[d] == "" && bannedArray[d] == false)
                {
                    parent[d] = string;
                    tree[d] = tree[g]+ "U" + Integer.toString(x + 1);
                    counter[d] = counter[g] + 1;
                    queue.add(f);
                }

                else if(parent[d] != "" && counter[g] + 1 <= counter[d] && tree[g].compareTo(tree[Integer.parseInt(parent[d])]) < 0)
                {
                    parent[d] = string;
                    tree[d] = tree[g] + "U" + Integer.toString(x + 1);
                    counter[d] = counter[g] + 1;
                    queue.add(f);
                }

                if(f.equals(last))
                {
                    if(counter[d] < answer)
                    {
                        answer = counter[d];
                        answer_string = tree[d];
                    }
                    else if(counter[d] == answer && answer_string.compareTo(tree[d]) < 0) {answer_string = tree[d];}
                }
            }
        }
        if(answer == 10000000)
        {
            System.out.println("-1");
            return;
        }

        System.out.println(answer);

        reverse(last,answer_string.length() - 2);
    }
}