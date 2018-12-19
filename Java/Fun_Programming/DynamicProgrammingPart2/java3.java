import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        int SIZE = 100000001;
        int ways[] = new int[SIZE];
        int seq[] = {2,3,6,7,8};
        for(int i = 0; i< SIZE; i++){
            ways[i] = 0;
        }
        ways[2] = 1;
        ways[3] = 1;
        ways[6] = 1;
        ways[7] = 1;
        ways[8] = 1;
        for(int i = 1; i< SIZE; i++){
            for(int j = 0; j < 5; j++){
                if(i-seq[j]>=0){
                    ways[i] = (ways[i] + ways[i-seq[j]])%1000000009;
                }
            }
        }
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(ways[n]);
    }
}
