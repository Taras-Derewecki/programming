import java.util.ArrayList;
import java.util.List;

/**
 * Created by Taras on 10/7/2016.
 */
public class RecursiveArray
{
    public static void main(String[] args)
    {
        ArrayList<String> arrayList = new ArrayList<String>();

        String[][] data =
        {
                {"A", "B"},
                {"1", "2"},
                {"XX","YY","ZZ"}
        };

        permute(data, 0, arrayList);
    }

    public static void permute(String array[][], int index, ArrayList<String> output)
    {

        if(index == array.length){
            System.out.println(output.toString());
        }


        else
        {
            for(int i = 0 ; i < array[index].length ; i++)
            {
                output.add(array[index][i]);
                permute(array,index+1,output);
                output.remove(output.size() - 1);
            }
        }
    }
}
