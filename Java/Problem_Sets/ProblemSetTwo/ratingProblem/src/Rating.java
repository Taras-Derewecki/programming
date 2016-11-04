/**
 * Created by Taras_Derewecki on 9/20/16.
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader; //
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Stream;

public class Rating
{
    public static void main(String[] args) throws IOException
    {
//        Average avg = new Average()
        HashMap<String, Integer> hmap = new HashMap<>();

        // Try opening this file at a certain location (where the .iml starts)
        try
        {
            // Open this file
            BufferedReader read = new BufferedReader(new FileReader("ratings.txt"));

            // Process this file
            String line = read.readLine();
            System.out.println("Number of Ratings: " + line);

            while(line != null)// checks to see if the file contains content
            {


//                System.out.println(line);
                String title = line;
                Integer rating = Integer.parseInt(line);// grab primitive data of type string and turn it into an integer
//                hmap.put(title, rating);

                if (hmap.containsKey(title))
                {

                    hmap.put(title, hmap.get(title));
                    //System.out.println(title);
//                    hmap.put(title, hmap.get(title)); // (key + 1 to keep track of all ratings)
                  // System.out.println("ONE");
                    System.out.println(title);
                }

                if(hmap.containsValue(rating))
                {
                    hmap.put(String.valueOf(rating), rating + 1);// now keep track of all titles
//                    rating.valueOf(title);
                    System.out.println(rating);
                }

//                else
//                    {
//                        hmap.put(title, hmap.get(title));
//                    }

                if(line == null) // if nothing left to read, get the average which is total number of ratings divided by number of ratings
                {
                    double average = rating / hmap.get(rating);
                    System.out.println("Average review: " + average);
                }
            }
//            line = read.readLine();

        }

        catch (FileNotFoundException fileNotFound) {System.err.println("File not found " +  fileNotFound.getMessage());}
    }



}
