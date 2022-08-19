package JavaPersonalProjects;

import java.util.Random;
import java.util.Scanner;

public class Hangman {
    final static Random random = new Random();
    final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("H A N G M A N");
        String[] guessWord = { "python", "java", "kotlin", "javascript", "html", "css", "cplusplus", "c", "csharp" };
        Boolean play = true;
        while (play) {
            // picking a random item
            int index = random.nextInt(guessWord.length);
            String word = guessWord[index];
            char[] charOfWord = new char[word.length()];
        }
    }
}
