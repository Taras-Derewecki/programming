import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Set<String> dictionary = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader("words.txt"))) {
            String s;

            while ((s = br.readLine()) != null)
                dictionary.add(s);
        }

        catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print("Enter your first word: ");
        String firstWord = scan.nextLine();

        System.out.print("Enter your last word: ");
        String lastWord = scan.nextLine();

        Ladder result = getShortestTransformationI(dictionary, firstWord, lastWord);

        if(result != null)
            System.out.println("Length: "+ result.getLength() + "\n" + "Path: " + result.getTrail());

        else System.out.println("No path found.");
    }

    private static Ladder getShortestTransformationI(Set<String> dictionary, String firstWord, String lastWord) {
        if(dictionary.contains(firstWord) && dictionary.contains(lastWord)) {
            List<String> trail = new LinkedList<>();
            Queue<Ladder> queue = new LinkedList<>();
            queue.add(new Ladder(trail, 1, firstWord));

            dictionary.remove(firstWord);

            while(!queue.isEmpty() && !queue.peek().equals(lastWord)) {
                Ladder ladder = queue.remove();

                if(lastWord.equals(ladder.getFinalWord()))
                    return ladder;

                Iterator<String> i = dictionary.iterator();

                while (i.hasNext()) {
                    String string = i.next();

                    if(offByOne(string, ladder.getFinalWord())) {
                        List<String> list = new LinkedList<>(ladder.getTrail());
                        list.add(string);

                        queue.add(new Ladder(list, ladder.getLength() + 1, string));
                        i.remove();
                    }
                }
            }

            if(!queue.isEmpty()) return queue.peek();
        }
        return null;
    }

    private static void recursiveHelper(String firstWord, String lastWord, Set<String> dictionary, Ladder ladder, LinkedList<Ladder> totalPath, Ladder shortestPath) {
        if(ladder.getFinalWord().equals(lastWord)) {
            totalPath.add(new Ladder(new LinkedList<>(ladder.getTrail())));

            if(shortestPath.getTrail() == null || shortestPath.getTrail().size() > ladder.getTrail().size()) {
                shortestPath.setTrail(new LinkedList<>(ladder.getTrail()));
                shortestPath.setLength(ladder.getTrail().size());
            }
        }

        for (String string : dictionary) {
            if (offByOne(string, ladder.getFinalWord()) && !ladder.getTrail().contains(string)) {
                List<String> trail = ladder.getTrail();

                trail.add(string);
                recursiveHelper(firstWord, lastWord, dictionary, new Ladder(trail, ladder.getLength() + 1, string), totalPath, shortestPath);
                trail.remove(trail.size() - 1);
            }
        }
    }

    private static boolean offByOne(String firstWord, String nextWord) {
        if (firstWord.length() != nextWord.length())
            return false;

        int diffCount = 0;

        for (int i = 0; i < firstWord.length(); i++)
            if (firstWord.charAt(i) != nextWord.charAt(i))
                diffCount++;
        return (diffCount == 1);
    }
}