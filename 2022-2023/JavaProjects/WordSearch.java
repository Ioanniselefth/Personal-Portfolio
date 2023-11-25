package JavaProjects;

import java.util.Scanner;

class WordSearch {
    final static Scanner scanner = new Scanner(System.in);

    // function that returns true if the word is in the string
    static Boolean trueorfalse(String str, String wo) {
        Boolean temp = str.contains(wo);
        return temp;
    }

    // main function
    public static void main(String[] args) {
        System.out.println("Please insert the full string: ");
        String fullstring = scanner.nextLine();
        System.out.println("Enter the word you want to search for: ");
        String word = scanner.next();
        if (trueorfalse(fullstring, word) == false)
            System.out.println("Word not found");
        else
            System.out.println("Word found");
    }
}
