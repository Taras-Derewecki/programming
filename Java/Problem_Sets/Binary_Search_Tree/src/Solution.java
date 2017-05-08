/**
 * Created by Taras on 4/2/2017.
 */

/*

In this problem, you are to write a binary search tree program that supports sequential access.
There are two different accessing concepts in computer science: random access and sequential access.

The sequential access is a way of accessing elements in a data set in a predetermined and ordered sequence.
The typical example that uses sequential access is the linked list. For example, you can access the 3rd element in a list by sequentially visiting 1st and 2nd and 3rd.
Therefore, accessing an element in a data set supporting only sequential access requires O(n) time, where n is the number of elements in the data set.

The random access (or direct access) is a way of accessing an element in a data set in a constant time O(1), independent of its location and the size of the data set.
The random access is required in many algorithms such as binary search or sorting.
Since only few data structures can guarantee the direct access except arrays, there are many compromising alternatives,
such as self-balancing binary search tree that support accessing an element in O(log⁡n ) where n is the size of the data set.

The binary search tree (BST) does not guarantee the tree is balanced, and its worst-case running time is O(n).
However, the expected height of the tree is O(log⁡n ) when the binary search tree is built by inserting a sequence of unique elements in random order.
In this problem, we may consider that the binary search tree is balanced since a sequence of unique elements will be inserted in random order.

Your task is to write a program that has the following operations:

Inserting dataues into a binary search tree if they are not in BST, or doing nothing otherwise;
Deleting dataues from a binary search tree if they are in BST, or doing nothing otherwise;
Writing a sequence of k dataues in increasing orders that starts from a given input dataue;
Writing a sequence of k dataues in decreasing orders that starts from a given input dataue.

Input Format:

    The program takes, via standard input, the following information:

    On the first line is the integer n specifying the number of operations.

    On the next n lines contains

    OP: the operation id (1 for insertion, 2 for deletion, 3 for writing a sequence in increasing order, and 4 for writing a sequence in decreasing order),
    KEY: the integer dataue to insert into BST, to delete from BST, or to write a sequence that start from,
    SIZE (optional): the size of sequence to write when OP is 3 or 4.
    For example, “1 3” means inserting 3 (KEY) into BST if BST does not have 3, “2 3” means deleting 3 (KEY) from BST
    if the BST has 3, “3 4 5” means writing 5 (KEY) sequential dataues in BST that starts from 4 (SIZE) in increasing order,
    and “4 5 6” means writing 6 (KEY) sequential dataues in BST that starts from 5 (SIZE) in decreasing order.

Constraints:

    Do not use any built-in data structures in Java, C++ stl, and C#, such as Hashtable, Dictionary, Vector, etc.

Output Format

    If there are m number of 3 or 4 **OP**s, the output must have m lines.

    If KEY is not in BST, you should write “no key found”.

    If OP is 3 (or 4), if KEY is in BST, and if BST has more than or equal to SIZE number of dataues that are greater than or equal to (or smaller than equal to) KEY,
    then write SIZE number of dataues in BST in increasing (or decreasing) order starting from KEY.

    If OP is 3 (or 4), if KEY is in BST, and if BST has lesser than SIZE number of dataues that are greater than or equal to (or smaller than equal to) KEY,
    then write all of them in increasing (or decreasing) order from KEY.

Sample Input 0:

    14
    1 5
    1 2
    1 7
    1 1
    1 3
    1 4
    1 6
    1 8
    3 5 1
    4 2 1
    3 5 3
    4 6 3
    3 1 8
    4 8 8

Sample Output 0:

    5,
    2,
    5,6,7,
    6,5,4,
    1,2,3,4,5,6,7,8,
    8,7,6,5,4,3,2,1,

Explanation 0

First 8 operation builds a tree such that:

    For a line with "3 5 1", your program should print 1 number from 5 in increasing order, which is "5,".
    For a line with "4 2 1", your program should print 1 number from 2 in decreasing order, which is "2,".
    For a line with "3 5 3", your program should print 3 numbers from 5 in increasing order, which is "5,6,7,".
    For a line with "4 6 3", your program should print 3 numbers from 6 in decreasing order, which is "6,5,4,".
    For a line with "3 1 8", your program should print 8 numbers from 1 in increasing order, which is "1,2,3,4,5,6,7,8,".
    For a line with "4 8 8", your program should print 8 numbers from 8 in decreasing order, which is "8,7,6,5,4,3,2,1,".

Sample Input 1:

    10
    1 5
    1 2
    1 7
    1 1
    1 3
    1 4
    1 6
    1 8
    3 5 8
    4 5 8

Sample Output 1:

    5,6,7,8,
    5,4,3,2,1,

Explanation 1:

First 8 operation builds a tree such that:

    For a line with "3 5 8", your program should print 8 number from 5 in increasing order, but your program can print only "5,6,7,8,".
    For a line with "4 5 8", your program should print 8 number from 5 in decreasing order, but your program can print only "5,4,3,2,1,".

Sample Input 2:

    15
    1 50
    1 20
    1 70
    1 10
    1 30
    1 40
    1 60
    1 80
    2 50
    2 10
    2 30
    3 70 2
    4 40 2
    3 40 5
    4 70 9000

Sample Output 2

    70,80,
    40,20,
    40,60,70,80,
    70,60,40,20,

Explanation 2:

First 11 operations builds a tree such that:

For a line with "3 70 2", your program should print 2 number from 70 in increasing order, that is "70,80,".
For a line with "4 40 2", your program should print 2 number from 40 in decreasing order, that is "40,20,".
For a line with "3 40 5", your program should print 5 number from 40 in increasing order, but your program can print only "40,60,70,80,".
For a line with "4 70 9", your program should print 9 number from 70 in decreasing order, but your program can print only "70,60,40,20,".

Sample Input 3

13
1 5
1 2
1 7
1 1
1 3
1 4
1 6
1 8
2 5
2 1
2 3
3 5 1
4 9 10
Sample Output 3

no key found
no key found
Explanation 3

First 11 operations builds a tree such that:

image

For a line with "3 5 1", your program should print 1 number from 5 in increasing order, but "5" is not in the tree, and your program should write "no key found".
For a line with "4 9 10", your program should print 10 number from 9 in decreasing order, but "9" is not in the tree, and your program should write "no key found".
Sample Input 4

18
1 5
1 2
3 5 2
1 3
4 5 2
1 5
2 9
1 1
2 3
3 3 2
4 3 1
1 7
1 6
1 9
3 7 3
4 7 4
3 1 4
4 1 3
Sample Output 4

5,
5,3,
no key found
no key found
7,9,
7,6,5,2,
1,2,5,6,
1,
Explanation 4

From the above input,

Line 1 specifies there are 18 operations.
In lines 2-3, the binary tree will have {2,5}.
In line 4 that is “3 5 2”, your program tries to write 2 numbers from 5 in increasing order, and will write “5,” because there is no dataue next to 5.
In lines 5, your program will add 3 into BST, and BST will have {2,3,5}.
In line 6 that is “4 5 2”, your program tries to write 2 numbers from 5 in decreasing order, and will write “5,3,”.
In lines 7, since 5 is already in BST, your program will ignore adding 5 into BST, and it will have {2,3,5}.
In line 8, your program will try to remove 9. However, because 9 is not in BST, BST will not be changed.
In a similar manner, after running lines 9-10, BST will have {1,2,5}.
In line 11 that is “3 3 2”, your program will try to write 2 numbers from 3 in increasing order. Because 3 is not in BST, your program must write “no key found”.
In a similar manner, your program must handle the rest of inputs.

Sample Input 5

5
1 0
1 1
1 2
1 3
1 4
3 0 10
Sample Output 5

0,1,2,3,4
Explanation 5

This is just an additional test case that will not be used for score.

 */

import java.util.*;

/***********************************************************************************************************************
                                                    BINARY TREE COMPONENTS
***********************************************************************************************************************/

class node
{
    public node leftChild, rightChild;
    public int data;

    public node(int x)
    {
        leftChild = null;
        rightChild = null;
        data = x;
    }
}

/***********************************************************************************************************************
                                                    BINARY TREE COMPONENTS
***********************************************************************************************************************/





/***********************************************************************************************************************
                                                FUNCTIONS FOR BINARY TREE
***********************************************************************************************************************/

class Binary_Search_Tree
{
    private node root;
    int number;
    boolean x;

    public Binary_Search_Tree() {root = null;}

    public boolean isEmpty() {return root == null;}

    public void add(int data) {root = add(root, data);}


    private node add(node x, int data)
    {
        if (x == null) {x = new node(data);}

        else
        {
            if (data == x.data) {return x;}

            if (data <= x.data) {x.leftChild = add(x.leftChild, data);}

            else {x.rightChild = add(x.rightChild, data);}
        }

        return x;
    }



    public void delete(int x)
    {
        if (isEmpty()) {return;}

        else if (search(x) == false) {return;}

        else {root = delete(root, x);}
    }



    private node delete(node root, int data)
    {
        node a;
        node b;
        node c;

        if (root.data == data)
        {
            node leftChild_node, rightChild_node;
            leftChild_node = root.leftChild;
            rightChild_node = root.rightChild;

            if (leftChild_node == null && rightChild_node == null) {return null;}

            else if (leftChild_node == null)
            {
                a = rightChild_node;
                return a;
            }

            else if (rightChild_node == null)
            {
                a = leftChild_node;
                return a;
            }

            else
            {
                b = rightChild_node;
                a = rightChild_node;

                while (a.leftChild != null) {a = a.leftChild;}

                a.leftChild=leftChild_node;
                return b;
            }
        }

        if (data < root.data)
        {
            c = delete(root.leftChild, data);
            root.leftChild = c;
        }

        else
        {
            c = delete(root.rightChild, data);
            root.rightChild = c;
        }

        return root;
    }


    public boolean search(int value) {return search(root, value);}


    private boolean search(node root, int data)
    {
        boolean isFound = false;
        node x = root;

        while ((x != null) && !isFound)
        {
            int gdata = x.data;

            if (data < gdata) {x = x.leftChild;}

            else if (data > gdata) {x = x.rightChild;}

            else
            {
                isFound = true;
                break;
            }
        }

        return isFound;
    }



    public void maximize(int value, int number)
    {
        if(search(value) == false)
        {
            System.out.println("no key found");
            return;
        }

        x = false;
        this.number = number;
        ascending(root,value);
        System.out.println();
    }



    private void ascending(node y, int data)
    {
        if (y != null)
        {
            ascending(y.leftChild, data);

            if(y.data >= data) {x = true;}

            if(x == true && number > 0)
            {
                System.out.print(y.data + ",");
                number--;
            }

            if(number == 0) {return;}

            ascending(y.rightChild, data);
        }
    }



    public void minimize(int data, int number)
    {
        if(search(data)==false)
        {
            System.out.println("no key found");
            return;
        }

        x = false;
        this.number = number;

        descend(root, data);
        System.out.println();
    }



    private void descend(node y, int data)
    {
        if (y != null)
        {
            descend(y.rightChild, data);

            if(y.data <= data) {x = true;}

            if(x == true && number > 0)
            {
                System.out.print(y.data +",");
                number--;
            }

            if(number == 0) {return;}

            descend(y.leftChild, data);
        }
    }
}

/***********************************************************************************************************************
                                            FUNCTIONS FOR BINARY TREE
***********************************************************************************************************************/





/***********************************************************************************************************************
                                                        MAIN
***********************************************************************************************************************/

public class Solution
{
    public static void main(String[] args)
    {
        Binary_Search_Tree Binary_Search_Tree = new Binary_Search_Tree();
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt(), x, y;

        while(input != 0)
        {
            input--;
            int choice = scan.nextInt();

            if(choice == 1)
            {
                x =  scan.nextInt();
                Binary_Search_Tree.add(x);
            }

            else if(choice == 2)
            {
                x = scan.nextInt();
                Binary_Search_Tree.delete(x);
            }

            else if(choice == 3)
            {
                x = scan.nextInt();
                y = scan.nextInt();
                Binary_Search_Tree.maximize(x,y);
            }

            else
            {
                x = scan.nextInt();
                y = scan.nextInt();
                Binary_Search_Tree.minimize(x,y);
            }
        }
    }
}

/***********************************************************************************************************************
                                                            MAIN
***********************************************************************************************************************/