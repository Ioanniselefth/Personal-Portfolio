package JavaProjects;

import java.util.Scanner;

public class RepeatChar {
    final static Scanner scanner = new Scanner(System.in);

    // function that returns
    public static String repeat(String str) {
        String doubled = "";
        for (int i = 0; i < str.length(); i++) {
            doubled += str.charAt(i);
            doubled += str.charAt(i);
        }
        return doubled;
    }

    // main function
    public static void main(String[] args) {
        System.out.println("Please enter the string you want to double it's characters");
        String input = scanner.nextLine();
        String temp = repeat(input);
        System.out.println("Starting string: " + input);
        System.out.println("Doubled string: " + temp);
    }
}
