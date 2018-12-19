import java.util.ArrayList;

public class RecursiveArray {
    public static void main (String [] args) {
        ArrayList<String>ans = new ArrayList<String>();

        String [][] a = {
                {"A", "B"},
                {"1", "2"},
                {"XX", "YY", "ZZ"}
        };

        String [][]b = {
                {"A"},
                {"1"},
                {"2"},
                {"XX", "YY"}
        };


        System.out.println("A = ");
        permute(a,0, ans);
        System.out.println();

        System.out.println("B = ");
        permute(b,0, ans);
        System.out.println();
    }

    public static void permute(String array[][], int ndx, ArrayList<String> ans)
    {
        if (ndx == array.length)
            System.out.println(ans.toString());

        else {
            for(int i = 0 ; i < array[ndx].length; i++) {
                ans.add(array[ndx][i]);
                permute(array,ndx + 1, ans);
                ans.remove(ans.size() - 1);
            }
        }
    }
}