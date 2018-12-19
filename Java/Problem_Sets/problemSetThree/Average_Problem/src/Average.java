import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = 0;

        while(true) {
            try {
                System.out.print("Enter the number of averages to be calculated: ");
                N = scan.nextInt();

                if(N <= 0)
                    throw new Exception();
                break;
            }

            catch(Exception e) { System.out.println("N has to be a positive integer"); }
        }

        System.out.println("Enter "+ N +" positive integers: ");

        int i = 0;
        double sum = 0;

        while(i < N) {
            int x = scan.nextInt();
            sum += x;
            i++;
        }

        System.out.println("Average: " + sum / N);
    }
}