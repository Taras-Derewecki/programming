/**
 * Created by Taras on 9/20/2016.
 */
import java.util.Scanner;

public class Movie
{
    protected double rating;
    protected int id;
    protected int idOne;
    protected String title;
    protected int days;

    public Movie(double rating, int id, String title)
    {
        this.rating = rating;
        this.id = id;
        this.title = title;
    }

    public double getRating() {return rating;}
    public int getId() {return id;}
    public int getIdOne() {return idOne;}
    public String getTitle() {return title;}
    public int getDays() {return days;}

    public void setRating(double rating) {this.rating = rating;}
    public void setId(int id) {this.id = id;}
    public void setIdOne(int idOne) {this.idOne = idOne;}
    public void setTitle(String title) {this.title = title;}
    public void setDays(int days) {this.days = days;}

//    @Override
    public boolean equals(Movie identification) {return this.id == identification.getId() && this.idOne == identification.getIdOne();}

    public void calculateLateFees()
    {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter how many days your movie was late: ");
        int daysLate = scan.nextInt();

        if(daysLate > 0) System.out.println("Late Fee: $" + daysLate * 2.00);

        else System.out.println("Good news! Your movie isn't late, so there is no late fee!");

        System.out.println();
    }
}
