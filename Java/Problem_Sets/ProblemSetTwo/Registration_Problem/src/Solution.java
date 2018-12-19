import java.util.*;
import java.io.*;

public class Solution
{
    public static void main(String args[])
    {
        Map<Integer, ArrayList<String>> hmap = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //try and catch I/O exceptions as we are reading from console
        try
        {
            //input until -1 comes through
            while(true)
            {
                System.out.println("Enter your ID and Class: ");
                String idAndClass = br.readLine();

                String[] values = idAndClass.split(" ");
                int key = Integer.parseInt(values[0]);

                if(key == -1) break;

                String val = values[1];


                if (hmap.get(key) == null)
                {
                    hmap.put(key, new ArrayList<>());
                    hmap.get(key).add(val);
                }

                else hmap.get(key).add(val);
            }
        }

        catch(IOException e) { System.out.println("IO Exception"); }

        for (Map.Entry<Integer, ArrayList<String>> entry : hmap.entrySet())
        {
             for(int i = 0; i < entry.getValue().size();i++)
                 System.out.println(entry.getKey()+ " " + entry.getValue().get(i));

            System.out.println();
        }
    }
}