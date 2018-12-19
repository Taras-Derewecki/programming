import java.util.Scanner;
import java.util.Arrays;

public class IntList {
    public static void main(String[] args) {
        // keyboard input
        Scanner kb = new Scanner(System.in);

        int[] input = new int[50];
        int idx = 0;

        do {
            // prompt for input
            System.out.print("Enter a number (or 'q' to quit): ");

            // check if int was entered
            if (kb.hasNextInt())
                input[idx++] = kb.nextInt();

            // if not, quit input
            else
                break;
        }

        while (idx < 50);

        System.out.println();

        // copy just the input into new array
        int[] data = new int[idx];

        for (int i = 0; i < idx; i++)
            data[i] = input[i];

        // sort input
        Arrays.sort(data);

        // output distinct elements only, starting at end
        outer:
        for (int i = idx - 1; i >= 0; i--) {
            // is distinct?
            for (int j = idx - 1; j > i; j--)
                if (data[j] == data[i])
                    continue outer;

            // count occurrences
            int count = 0;
            for (int j = 0; j < idx; j++)
                if (data[j] == data[i])
                    count++;

            System.out.println(data[i] + "\t" + count);
        }
    }
}