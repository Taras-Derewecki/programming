import java.io.BufferedReader;

import java.io.FileReader;

import java.io.IOException;

import java.util.ArrayList;

import java.util.LinkedHashMap;

import java.util.Map.Entry;

public class movieRatings {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("movieRatings.txt"));
        LinkedHashMap<String, ArrayList<Integer>> hmap = new LinkedHashMap<>();

        try {
            int numberOfMovies = Integer.valueOf((br.readLine().trim())); // reading number of movies

            for(int i = 0; i < numberOfMovies; i++) {
                String title = br.readLine().trim();                // read movie's name from file
                int rating = Integer.valueOf((br.readLine().trim()));    // read movie's rating from file
                ArrayList<Integer> arr;

                /*
                 If hmap doesn't contain a movie of this name,
                 then its # of reviews will start with one,
                 and total rating will be rating of this only movie
                */
                if(!hmap.containsKey(title)) {
                    arr = new ArrayList<>();
                    arr.add(1);                                         // add # of reviews
                    arr.add(rating);                                    // and the ratings for first time
                }

                // if the movie isn't new, then update total reviews and total ratings
                else {
                    arr = hmap.get(title); // get previous reviews' count and ratings

                    // update review count and rating
                    arr.set(0, arr.get(0) + 1);
                    arr.set(1, arr.get(1) + rating);
                }

                hmap.put(title, arr); // put updated values of reviews count and rating in hmap
            }

        // now traverse over all of the movies and output its # of reviews w/ the average rating
        // average rating = total rating / # of review(s)

            for (Entry<String, ArrayList<Integer>> entry : hmap.entrySet()) {
                ArrayList<Integer> arr = entry.getValue();
                double avg = Math.round(arr.get(1) * 10.0 / arr.get(0)) / 10.0;

                if(arr.get(0) == 1) System.out.println(entry.getKey() + ": " + arr.get(0) + " review averaging " + avg + " / 5 stars.");
                else System.out.println(entry.getKey() + ": " + arr.get(0) + " reviews averaging " + avg + " / 5 stars.");
            }
        }

        finally{ br.close(); }
    }
}