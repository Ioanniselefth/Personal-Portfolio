package JavaProjects;

import java.util.Scanner;

public class WordReverse {
    final static Scanner scanner = new Scanner(System.in);

    // function that returns the String with its words reversed
    public static String wordreversal(String str) {
        String words[] = str.split("\\s");
        String reverseWord = "";
        for (String w : words) {
            StringBuilder sb = new StringBuilder(w);
            sb.reverse();
            reverseWord += sb.toString() + " ";
        }
        return reverseWord.trim();
    }

    // main function
    public static void main(String[] args) {
        System.out.println("Give your sentence that you want to reverse");
        String input = scanner.nextLine();
        String temp = wordreversal(input);
        System.out.println("Starting string: " + input);
        System.out.println("Finished result: " + temp);
    }
}
