import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Calendar {

    public static void main(String[] args){

        final String[] weekdays = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        final String[] months = {"January", "February", "March", "April", "May", "June", "July", "August",
                "September", "October", "November", "December"};
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        Scanner scanner = new Scanner(System.in);
        int year;
        do {
            System.out.print("Please input the year you want a calendar for: ");
            year = scanner.nextInt();
        } while(year <= 0);

        System.out.println("                  " + year);
        System.out.println();
        for(int month = 1; month <= 12; month++) {
            //Prints the month
            System.out.println("                " + months[month - 1]);

            //Sets the starting weekday of the month
            Date date = new GregorianCalendar(year,month - 1,1).getTime();
            int startingDayForMonth = date.getDay();

            //Prints the weekdays
            for(int j = 0; j < weekdays.length; j++) {
                System.out.print(weekdays[j]);
                System.out.print("   ");
            }
            System.out.println();

            //The needed spaces so that the first day is on the proper weekday
            for(int i = 0; i < startingDayForMonth; i++) {
                System.out.print("      ");
            }

            //Checks if it's a leap year and sets the days for February if it is such
            if(((year % 100 != 0 && year % 4 == 0) || (year % 400 == 0)) && month == 2) {
                days[month - 1] = 29;
            }

            for(int k = 1; k <= days[month - 1]; k++) {
                System.out.print(k);
                if(k < 10) {
                    System.out.print("     ");
                }
                else {
                    System.out.print("    ");
                }
                if((k + startingDayForMonth ) % 7 == 0) {
                    System.out.println();
                }
            }


            System.out.println();
            System.out.println();
        }

    }
}