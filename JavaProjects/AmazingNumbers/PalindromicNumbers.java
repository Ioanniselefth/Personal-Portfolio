package JavaProjects.AmazingNumbers;

import java.util.Scanner;
//import java.util.Formatter;

public class PalindromicNumbers {
    final static Scanner scanner = new Scanner(System.in);

    static void oddoreven(long num, String str) {
        if (num % 2 == 0 && str == "even")
            System.out.println("        even: " + true);
        else if (num % 2 == 0 && str == "odd")
            System.out.println("        odd: " + false);
        else if (num % 2 == 1 && str == "even")
            System.out.println("        even: " + false);
        else
            System.out.println("        odd: " + true);
    }

    static void isbuzz(long num) {
        if (num % 10 == 7 && num % 7 == 0)
            System.out.println("        buzz: " + true);
        else if (num % 7 == 0)
            System.out.println("        buzz: " + true);
        else if (num % 10 == 7)
            System.out.println("        buzz: " + true);
        else
            System.out.println("        buzz: " + false);
    }

    static Boolean isduck(long num) {
        String num2 = String.valueOf(num);
        int i = 0, n = num2.length();
        // Ignore leading 0
        while (i < n && num2.charAt(i) == '0')
            i++;
        // Check remaining digits
        while (i < n) {
            if (num2.charAt(i) == '0')
                return true;
            i++;
        }
        return false;
    }

    static Boolean ispalindromic(long num) {
        String str = Long.toString(num);
        int j = str.length() - 1;
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            j -= 1;
        }
        return true;
    }

    static void properties(long num) {
        System.out.printf("Properties of %,d%n", num);
        oddoreven(num, "even");
        oddoreven(num, "odd");
        isbuzz(num);
        System.out.println("        duck: " + isduck(num));
        System.out.println(" palindromic: " + ispalindromic(num));

    }

    static void isNatural(long num) {
        if (num < 0) {
            System.out.println("The first parameter should be a natural number or zero.");
        } else {
            properties(num);
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Amazing Numbers!");
        System.out.println();
        System.out.println("Supported requests:");
        System.out.println("- enter a natural number to know its properties;");
        System.out.println("- enter 0 to exit.");
        System.out.println();
        System.out.print("Enter a request: ");
        long input = scanner.nextLong();
        isNatural(input);
        while (input != 0) {
            System.out.print("Enter a request: ");
            input = scanner.nextInt();
            if (input == 0) {
                break;
            }
            isNatural(input);
        }
        System.out.println("Goodbye!");
    }
}
