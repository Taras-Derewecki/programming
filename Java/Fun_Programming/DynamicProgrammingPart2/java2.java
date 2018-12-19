import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;



public class Solution {

    static int MOD = 1000000009;

    public static int result(int a, int ways[]){
        if(a<0)
            return 0;
        if(ways[a] >= 0)
            return ways[a];
        if(a==2 || a==3 || a==6 || a==7 || a==8){
            ways[a] = (1 + (result(a-2,ways) + result(a-3,ways))%MOD + ((result(a-6,ways) + result(a-7,ways))%MOD + result(a-8,ways))%MOD)%MOD;
            return ways[a];
        }
        else{
            ways[a] = ((result(a-2,ways) + result(a-3,ways))%MOD + ((result(a-6,ways) + result(a-7,ways))%MOD + result(a-8,ways))%MOD)%MOD;
            return ways[a];
        }
    }

    public static void main(String[] args) {
        int SIZE = 100000001;
        int ways[] = new int[SIZE];
        int seq[] = {2,3,6,7,8};
        for(int i = 0; i< SIZE; i++){
            ways[i] = -1;
        }
        ways[0] = 0;
        ways[1] = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(result(n,ways));
    }
}
