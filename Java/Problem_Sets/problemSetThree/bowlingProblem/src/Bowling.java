/**
 * Created by Taras on 10/7/2016.
 */

import java.util.Scanner;

public class Bowling
{
   public static void main(String[] args)
   {
       Scanner scan = new Scanner(System.in);

       System.out.print("# of Pyramid Rows: ");
       int rows = scan.nextInt();
       System.out.print("Total # of pins: " + pyramid(rows));
   }

   public static int pyramid(int rows)
   {
       if(rows == 1){return 1;} // base case

       else return (pyramid(rows-1)+rows); // All other cases
   }
}
