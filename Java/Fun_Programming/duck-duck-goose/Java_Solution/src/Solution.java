import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    static boolean[][] possibilities; // possibilities[i][j] = true, iff bird i could appear at position j
    static ArrayList<Question> qs; // The questions

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = Integer.valueOf(sc.nextLine());

        for (int i = 0; i < t; i++) {
            sc.nextLine();
            String[] tokens = sc.nextLine().split(" ");
            int qCount = Integer.valueOf(tokens[0]);
            int lies = Integer.valueOf(tokens[1]);

            qs = new ArrayList<Question>();

            for (int j = 0; j < qCount; j++) {
                qs.add(new Question(sc.nextLine(), sc.nextLine()));
            }

            // Do an exhaustive search of all possible configurations
            possibilities = new boolean[4][10];
            search(0, new int[10], lies);

            // Format the output
            for (int j = 0; j < 10; j++) {
                StringBuffer out  = new StringBuffer();
                if (j > 0) out.append(" ");
                if (possibilities[1][j]) out.append("d");
                if (possibilities[2][j]) out.append("g");
                if (possibilities[3][j]) out.append("s");
                System.out.print(out.toString());
            }
            System.out.println();
        }
    }

    public static void search(int nextIdx, int[] configuration, int expectedLies) {
        // In base case, we check to see if the current configuration is feasible
        if (nextIdx == 10) {
            int lieCount = 0;

            for (int i = 0; lieCount <= expectedLies && i < qs.size(); i++) {
                if (!qs.get(i).isTruthful(configuration)) lieCount++;

            }
            if (lieCount == expectedLies) {
                for (int i = 0; i < 10; i++) {
                    possibilities[configuration[i]][i] = true;
                }
            }
            return;
        }

        // Try each bird in next possible slot in the configuration
        for (int i = 1; i <= 3; i++) {
            configuration[nextIdx] = i;
            search(nextIdx + 1, configuration, expectedLies);
        }
    }
}

/**
 * A Question and Answer from a game
 *
 */
class Question {
    ArrayList<Clause> sub = new ArrayList<>();  // The clauses making up this question
    boolean opOr = false;   // Whether clauses are connected with "or"
    boolean answer;      // Whether Alice answered "yes"

    /**
     * Parse the question into clauses
     *
     * @param question the question
     * @param answer the answer given for the question
     */
    Question(String question, String answer) {
        if (question.contains(" or ")) {
            opOr = true;
        }
        for (String clause: question.split(" (and|or) " )) {
            sub.add(new Clause(clause));
        }
        this.answer = answer.equals("yes");
    }

    /**
     * Evaluate whether a lie was told with respect to this question if the
     * configuration of birds was equal to the argument
     *
     * @param configuration the potential configuration of birds
     * @return whether Alice was truthful
     */
    boolean isTruthful(int[] configuration) {
        boolean retVal = true;
        if (opOr) retVal = false;

        for (Clause sq : sub) {
            if (opOr)
                retVal = retVal || sq.evaluate(configuration);
            else
                retVal = retVal && sq.evaluate(configuration);
        }
        return retVal == answer;
    }
}

/**
 * A question clause (i.e. the parts of a question that can be combined with 
 * logical operators "and" or "or"
 *
 */
class Clause {
    boolean countType = false;
    int bird;
    int count;
    int index;

    Clause(String input) {
        String[] tokens = input.split(" ");

        if (tokens[0].equals("total")) {
            countType = true;

            if (tokens[1].equals("d"))
                bird = 1;
            else if (tokens[1].equals("g"))
                bird = 2;
            else // tokens[1].equals("s")
                bird = 3;

            count = Integer.valueOf(tokens[2]);
        }
        else { // tokens[0].equals("bird")
            index = Integer.valueOf(tokens[1]) - 1;

            if (tokens[2].equals("d"))
                bird = 1;
            else if (tokens[2].equals("g"))
                bird = 2;
            else // tokens[2].equals("s")
                bird = 3;
        }
    }

    /**
     * Evaluate a configuration of birds with respect to this clause.
     *
     * @param birds
     * @return the result of the clause when applied to this configuration
     */
    boolean evaluate(int[] birds) {
        if (countType) {
            int c = 0;
            for (int i = 0; i < 10; i++) {
                if (birds[i] == bird) c++;
            }
            return c == count;
        }
        else {
            return (birds[index] == bird);
        }
    }

}