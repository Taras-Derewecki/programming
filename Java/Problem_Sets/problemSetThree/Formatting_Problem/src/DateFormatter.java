import java.util.Scanner;

public class DateFormatter {
    public static void main(String[] args) {

        int month, day, year, daysInMonth = 0;
        String date="";
        String month_name[]={"January", "February", "March", "April",
                             "May", "June", "July", "August", "September",
                             "October", "November", "December"};

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter Date: ");
        date = scan.next();

        String datee[] = date.split("/");
        month = Integer.parseInt(datee[0]);

        while (true) {
            try {
                if (month < 1 || month > 12)
                    throw new MonthException("ERROR: Month Exception must be inclusively between 1 - 12.");
                else break;
            }

            catch (MonthException e) {
                System.out.print("Enter Month: ");
                month = scan.nextInt();
                continue;
            }
        }

        day = Integer.parseInt(datee[1]);
        year = Integer.parseInt(datee[2]);

        while (true) {
            if (year < 1000 || year > 3000) {
                try {
                    throw new YearException("** Year Exception.Must be between 1000-3000 **");
                }

                catch (YearException e) {
                    System.out.print("Enter Year: ");
                    year = scan.nextInt();
                    continue;
                }
            }

            else break;
        }

        switch(month){
            case 2:
                if (year % 400 == 0) daysInMonth = 29;
                else if (year % 100 == 0) daysInMonth = 28;
                else if (year % 4 == 0) daysInMonth = 29;
                else daysInMonth = 28;
                break;
            case 4: daysInMonth = 30; break;
            case 6: daysInMonth = 30; break;
            case 9: daysInMonth = 30; break;
            case 11: daysInMonth = 30; break;
            default: daysInMonth = 31; break;
        }

        while (true) {
            if (day < 1 || day > daysInMonth) {
                try {
                    throw new DayException("ERROR: Day Exception must be inclusively between 1 - " + daysInMonth + ".");
                }

                catch (DayException e) {
                    System.out.print("Enter Day: ");
                    day = scan.nextInt();
                    continue;
                }
            }

            else break;
        }

        System.out.print("\nDate: "+ month_name[month - 1] + " " + day + ", " + year);
    }
}