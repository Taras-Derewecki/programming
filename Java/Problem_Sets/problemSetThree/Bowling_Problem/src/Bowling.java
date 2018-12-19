import java.util.Scanner;

public class Bowling {
    static void getPins(int numOfRows, int i) {
        printSpace(numOfRows, 0, i);
        printStar(numOfRows, numOfRows, i);
        System.out.println();

        if (i++ < numOfRows - 1) getPins(numOfRows, i);
    }

    static void printSpace(int row, int c, int i) {
        if (c < (row - i - 1)) {
            System.out.print(" ");
            printSpace(row, c + 1, i);
        }
    }

    static void printStar(int row, int c, int i) {
        if (c > (row - i - 1)) {
            System.out.print("* ");
            printStar(row, c - 1, i);
        }
    }

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.print("Enter number of rows: ");

        int num = scanner.nextInt();
        getPins(num,0);
    }
}