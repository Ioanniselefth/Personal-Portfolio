package JavaProjects;

import java.util.Scanner;

public class DayOfBirth {
    public static void main(String[] args) {
        int dd = 32, mm = 13, yyyy = -1, NYYYY, NMM, IDAY, day, flag = 0;
        String month[] = { "January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December" };
        System.out.println("Give the Day/Month/Year when you were born!");
        Scanner scanner = new Scanner(System.in);
        dd = scanner.nextInt();
        mm = scanner.nextInt();
        yyyy = scanner.nextInt();
        while (dd == 32 && mm == 13 && yyyy == -1) {
            System.out.println("Please enter your birthday int this format(including spaces):");
            System.out.println("\t DD MM YYYY (ex:22 01 1997)");
            dd = scanner.nextInt();
            mm = scanner.nextInt();
            yyyy = scanner.nextInt();
        }

    }
}
