import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ways[] = new int[9];
        int seq[] = {2,3,6,7,8};
        for(int i = 0; i<= 8; i++){
            ways[i] = 0;
        }
        ways[2] = 1;
        ways[3] = 1;
        ways[6] = 1;
        ways[7] = 1;
        ways[8] = 1;
        for(int i = 1; i<= 8; i++){
            for(int j = 0; j < 5; j++){
                if(i-seq[j]>=0){
                    ways[i] = (ways[i] + ways[i-seq[j]])%1000000009;
                }
            }
        }

        if(n > 8){
            for(int i = 9; i<= n; i++){
                for(int j=0; j<8; j++){
                    ways[j] = ways[j+1];
                }
                ways[8] = 0;
                for(int j = 0; j < 5; j++){
                    ways[8] = (ways[8] + ways[8-seq[j]])%1000000009;
                }
            }
            System.out.println(ways[8]);
        }
        else
            System.out.println(ways[n]);
    }
}
