package JavaProjects.AmazingNumbers;

import java.util.Scanner;

public class BuzzNumbers {
    final static Scanner scanner = new Scanner(System.in);

    static Boolean isNatural(int num) {
        if (num < 1)
            return false;
        return true;
    }

    static Boolean oddoreven(int num) {
        if (num % 2 == 0) {
            System.out.println("This number is Even.");
            return true;
        }
        System.out.println("This number is Odd.");
        return false;
    }

    static void isBuzz(int num) {
        System.out.println("Explanation:");
        if (num % 10 == 7 && num % 7 == 0)
            System.out.println("It is a Buzz number.\n" + num + " is divisible by 7 and ends with 7.");
        else if (num % 7 == 0)
            System.out.println("It is a Buzz number.\n" + num + " is divisible by 7.");
        else if (num % 10 == 7)
            System.out.println("It is a Buzz number.\n" + num + " ends with 7.");
        else
            System.out
                    .println("It is not a Buzz number.\n" + num + " is neither divisible by 7 nor does it end with 7.");
    }

    public static void main(String[] args) {
        System.out.println("Enter a natural number: ");
        int number = scanner.nextInt();
        System.out.println();
        if (isNatural(number) == true) {
            oddoreven(number);
            isBuzz(number);
        } else {
            System.out.println("This number is not natural!");
        }
    }
}
