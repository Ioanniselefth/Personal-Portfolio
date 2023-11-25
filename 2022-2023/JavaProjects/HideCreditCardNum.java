package JavaProjects;

import java.util.Scanner;

public class HideCreditCardNum {
    final static Scanner scanner = new Scanner(System.in);

    // function that returns the number's only last 4 digits
    public static String hideCreditCardNum(String number) {
        String temp = "";
        for (int i = number.length() - 4; i < number.length(); i++)
            temp += number.charAt(i);
        return temp;
    }

    // Main function
    public static void main(String[] args) {
        System.out.println("Give your credit card number: ");
        String creditcard = scanner.nextLine();
        String temp = hideCreditCardNum(creditcard);
        System.out.println("Your credit card number ends with: " + temp);
    }
}
