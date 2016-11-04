/**
 * Created by Taras on 10/7/2016.
 */
//import java.util.InputMismatchException;
import java.util.Scanner;

public class AverageMain
{
    public static void main(String[] args)
    {
        String totalNum, scores = null;
        double avg;
        double sum = 0.00; // makes the outcome a real double for the average

        Scanner scan = new Scanner(System.in);
        Integer total = 0;
        boolean valid;

        do
        {
            System.out.print("Total # of Average(s)(Integer format... ex: 5): ");
            totalNum = scan.nextLine();
            total = Integer.parseInt(totalNum);
            valid = validate((double) total);
        }

        while (!valid);

        if (total > 0)
        {
            for (int i = 0; i < total; i++)
            {
                System.out.print("Enter Score(Double format... ex: 52.20): ");
                scores = scan.nextLine();
                Double score = Double.parseDouble(scores);
                valid = validate(score);

                if (!valid)
                {
                    System.out.println("The number should be reentered.");
                    --i;
                }

                else sum += score;
            }

            avg = sum / total;
            System.out.print("Average Score: " + avg);
            System.out.println();
        }

//        else
//        {
//            try
//            {
//                Double result = validate(totalNum, scores);
//            }
//
//            catch(Average e){System.err.println(e.getMessage());}
//        }
    }

    public static boolean validate(double score)
    {

            try
            {
                if(score < 0.0)
                    throw new Average(score + " is negative. Please enter a positive number");
            }

            catch (Average average)
            {
                System.out.println(average.getMessage());
                return false;
            }

            return true;
    }
}

