package JavaProjects.AmazingNumbers;

import java.util.Scanner;

public class DuckNumbers {
    final static Scanner scanner = new Scanner(System.in);

    static Boolean isNatural(int num) {
        if (num < 1)
            return false;
        return true;
    }

    static Boolean oddoreven(int num, String str) {
        if (num % 2 == 0 && str == "even")
            return true;
        else if (num % 2 == 0 && str == "odd")
            return false;
        else if (num % 2 == 1 && str == "even")
            return false;
        else
            return true;
    }

    static Boolean isBuzz(int num) {
        if (num % 10 == 7 && num % 7 == 0)
            return true;
        else if (num % 7 == 0)
            return true;
        else if (num % 10 == 7)
            return true;
        else
            return false;
    }

    static Boolean isDuck(int num) {
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

    public static void main(String[] args) {
        System.out.println("Enter a natural number: ");
        int number = scanner.nextInt();
        if (isNatural(number) == true) {
            System.out.println("Properties of " + number);
            System.out.println("        even: " + oddoreven(number, "even"));
            System.out.println("         odd: " + oddoreven(number, "odd"));
            System.out.println("        buzz: " + isBuzz(number));
            System.out.println("        duck: " + isDuck(number));
        } else {
            System.out.println("This number is not natural!");
        }
    }
}
