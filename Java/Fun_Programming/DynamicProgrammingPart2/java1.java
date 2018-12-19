import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;



public class Solution {

    public static int result(int a){
        if(a<2)
            return 0;
        if(a==2 || a==3 || a==6 || a==7 || a==8)
            return (1 + result(a-2) + result(a-3) + result(a-6) + result(a-7) + result(a-8));
        else
            return (result(a-2) + result(a-3) + result(a-6) + result(a-7) + result(a-8));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(result(n));
    }
}
