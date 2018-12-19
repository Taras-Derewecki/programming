import java.util.Arrays;
import java.util.Scanner;

public class Airplane {

    public static void main(String[] args) {
        char[][] airplane = new char[7][4];
        Scanner scan = new Scanner(System.in);
        String rowAndColumn;
        for(int i = 0; i < 32; i++){

            System.out.print("Enter the airplane row and column you would like to occupy, " +
                    "then hit enter (Format: 0 5): ");
            rowAndColumn = scan.nextLine(); // 0 5
            System.out.println();

            int row = Integer.parseInt(rowAndColumn.substring(0, rowAndColumn.indexOf(' ')));
            int column = Integer.parseInt(rowAndColumn.substring(2));

            if(airplane[row][column] == 'X'){
                throw new RuntimeException("Airplane seat is occupied!");
            }

            else airplane[row][column] = 'X';

            for (char[] mainRow : airplane){
                System.out.println(Arrays.toString(mainRow));
            }
        }
    }
}