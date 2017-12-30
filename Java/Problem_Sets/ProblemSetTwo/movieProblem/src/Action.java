import java.util.Scanner;

/**
 * Created by Taras on 9/20/2016.
 */
public class Action extends Movie
{

    public Action(double rating, int id, String title)
    {
        super(rating, id, title);
    }

    @Override
    public void calculateLateFees()
    {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter how many days your movie was late: ");
        int daysLate = scan.nextInt();

        if(daysLate > 0) System.out.println("Late Fee: $" + daysLate * 3.00);

        else System.out.println("Good news! Your movie isn't late, so there is no late fee!");

        System.out.println();
    }
}
