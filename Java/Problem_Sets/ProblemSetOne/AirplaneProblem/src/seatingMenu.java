import java.awt.Choice;
import java.util.Scanner;

public class seatingMenu {
    //presents the main menu to end user with choices
    public static void displayMenu(String mainMenu) {
        System.out.println("Please choose the following choices:");
        System.out.println("1. Book a reservation");
        System.out.println("2. Cancel a reservation");
        System.out.println("3. Print current seating chart");
        System.out.println("4. press 0 to exit system\n");
    }

    public static char presentMenuResponse() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your choice.");

        String Tt = scan.nextLine();

        char choosing = Tt.charAt(0);
        return choosing;
    }

    //lets the user decide to book or cancel seating reservation
    public static void presentMenuResponse(char menuResponse, char[][] seatingChoice) {
        Scanner scan = new Scanner(System.in);
        String reserve;
        switch(menuResponse) {
            case '1':
                //System.out.println("Do you want to reserve a seat, y/n ?");
                //reserve = scan.nextLine();
                //System.out.println("Please enter Y for yes and N for no");

                displayTicketTypeMenu();
                break;
            case '2':
                System.out.println("Do you want to cancel a reservation?");
                scan.nextLine();
                break;
            case '3':
                System.out.println("Print out a seating chart");
                break;
            case '4':
                System.out.println("Press 1 to exit the system and back to the main menu.");
                System.exit(1);
                break;
            default:
                System.out.println("This is an invalid response.");
        }
    }

    //this method will display the seating choice menu
    public static int presentMenuResponse2(String menuId, int scChoiceMenu) {
        Scanner scan = new Scanner(System.in);

        if(menuId.equalsIgnoreCase("scChoiceMenu")) {
            System.out.println("Seating Choice Menu");
            System.out.println("1) Choose ticket type (First Class, Business, Economy)");
            System.out.println("2) Exit to main menu");
            System.out.println("Choose an option to go to the next section or '2' to go back to the main menu");
            scChoiceMenu = scan.nextInt();
        }

        int sChoice = scChoiceMenu;
        return sChoice;
    }

    //this method returns the seating choice menu
    public static int getcChoice(int scChoice) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Your Choice");
        String s = scan.nextLine();
        int ClassChoice = s.charAt(0);
        return scChoice;
    }

    //this method will return the ticket type menu
    public static void displayTicketTypeMenu() {
        System.out.println("Please choose a ticket type:");
        System.out.println("First Class");
        System.out.println("Business Class");
        System.out.println("Economy");
        System.out.println("0, exits to the main menu");
        System.out.println();
    }

    public static char getCChoice(char ClassChoice) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your class choice");
        String c = scan.nextLine();
        char Classchoice = c.charAt(0);
        return ClassChoice;
    }

    // This method and switch statement will let the user to pick what row they want to assigned to e.g if they
    //want to be seated in first class they will type a 1.
    public static int presentMenuResponse3(String menuId, int rwChoiceMenu) {
        Scanner scan = new Scanner(System.in);
        if(menuId.equalsIgnoreCase("rwChoice"));

        System.out.println("Row Choice Menu");
        System.out.println("1) For first class please type '1-2'");
        System.out.println("2) For business class please type '3-4'");
        System.out.println("3) For Economy please type '5-7'");
        System.out.println("Choose an option to continue to column choice.");

        rwChoiceMenu = scan.nextInt();

        int rwChoice = rwChoiceMenu;
        return rwChoice;
    }

    public static char getRCChoice(char ClassChoice) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Your class choice");
        String c = scan.nextLine();
        char Classchoice = c.charAt(0);
        return ClassChoice;
    }

    // This method and switch statement will let the user select what column of seats they want to be assigned to
    public static String presentMenuResponse4(String menuId, String cwChoiceMenu) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Seat Choice Menu");
        if(menuId.equalsIgnoreCase("cwChoiceMenu==1"));
        {
            System.out.println("1) For First Class type letters A, B, C, D");
            System.out.println("2) For Business Class type letters A, B, C, D");
            System.out.println("3) For Economy type letters A, B, C, D");
            System.out.println("Choose an option to proceed || Press 0 to exit to the main menu");
            cwChoiceMenu = scan.next();

            String cwChoice = cwChoiceMenu;
            return cwChoice;
        }
    }
}
