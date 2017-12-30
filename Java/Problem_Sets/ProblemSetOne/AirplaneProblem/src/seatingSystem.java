public class seatingSystem {
    public static int seatingChart;
    //this public variable will make the all switch statement work
    //this method will be a boolean statement to make what seats are available and return if it is
    //true or false.
    public static boolean seatAvailable(char[][] seatingchart, int rwChoice, int cwChoice, int seChoice, boolean x) {
        switch(seatingChart) {
            case '1':
                System.out.println("seatingChart");
                System.out.println("rwChoice-1");
                break;
            case '2':
                System.out.println("seatingChart");
                System.out.println("cwChoice-1");
                break;
            case '3':
                System.out.println("seatingChart");
                System.out.println("seChoice-1");
                break;
            case '4':
                if(x) return true;
                break;
        }
        otherwise:
        return false;
    }

    // This method will be an integer and a char statement with a nested
    //if else statement to assign the seat
    public static int seatAssign(char[][] seatingChart, int rwChoice, int seChoice, int seatingChart2) {
        switch(rwChoice) {
            case '1':
                if(seatingChart[rwChoice-1][(seChoice-1)] == '*' && rwChoice != -1 && seChoice != -1);
                else seatingChart[(rwChoice-1)][(seChoice-1)] = '*';
                break;
            case '2':
                if(seatingChart[rwChoice-1][(seChoice-1)] == '*' && rwChoice != -1 && seChoice != 0);
                else seatingChart[(rwChoice-1)][(seChoice-1)] = '*';
                break;
            default:
                return 0;
        }

        otherwise: return 1;
    }

    // this method will display and print the seating chart
    public static void displaySeatingChart(char[][] seatingChart) {
        char x=0;
        char y=0;
        int count = 0;
        System.out.println("\n A B C D");
        for (x = 0; x < seatingChart.length -1; x++)
            if (x <= 7) {
                System.out.println("rwChoice" + (x+1)+ " ");
            } else
                System.out.println("colChoice" + (x+y)+ " ");
        for (y = 0; y < seatingChart[x].length; y++);
        {
            System.out.println(seatingChart[x][y] + " ");
        }
        if(y + 1% 6 == 0) {
            System.out.println(seatingChart[x][y] + " ");
        } else {
            System.out.println("*---------Available");
        }
        {
            System.out.println("x---------Occupied");
            System.out.println(" ");
        }
        count++;

    }
}