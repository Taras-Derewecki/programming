/**
 * Created by Taras on 9/20/2016.
 */
public class Movie_Main
{
    public static void main(String[] args)
    {
        Action movieOne = new Action(8.9, 999, "Pirates of the Caribbean");
        Action movieTwo = new Action(7.3, 999, "Pirates of the Caribbean II");
        Drama movieThree = new Drama(5.2, 343, "Titanic");
        Comedy movieFour = new Comedy(7.9, 123, "Mr. Bean's Holiday");

        Boolean isEqual = movieOne.equals(movieTwo);
        Boolean isEqualOne = movieThree.equals(movieFour);

        movieOne.calculateLateFees();
        movieTwo.calculateLateFees();
        System.out.println(isEqual);

        movieThree.calculateLateFees();
        movieFour.calculateLateFees();
        System.out.println(isEqualOne);

        //movieOne.equals(movieTwo);

    }


}
