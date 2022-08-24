package JavaProjects.NumberGuessingGame;

import java.util.Random;
import java.util.Scanner;

class NumberGame {
    final static Random random = new Random();
    final static Scanner scanner = new Scanner(System.in);

    public static void game(int num) {

    }

    public static void main(String[] args) {
        System.out.println("Welcome to my version of Number Guessing game!");
        System.out.println("The random number is being generated.");
        // Generated random integer number between 1 - 100
        int number = 1 + (int) (100 * Math.random());
        System.out.println("Done!");
        System.out.println("You have 5 tries to find the number");
        System.out.println(number);
        Boolean play = true;
        Boolean won = false;
        while (play == true) {
            int tries = 5;
            while (tries > 0) {
                System.out.println("Give your guess!");
                int guess = scanner.nextInt();
                if (guess < 1 || guess > 100) {
                    System.out.println("Wrong input!");
                    guess = scanner.nextInt();
                }
                if (guess == number) {
                    System.out.println("Holy shit!");
                    System.out.println("You won!");
                    won = true;
                    tries = 0;
                } else if (guess > number) {
                    System.out.println("Your guess is higher than the number!");
                } else if (guess < number) {
                    System.out.println("Your guess is less than the number!");
                }
                tries -= 1;
            }
            if (won == false)
                System.out.println("Sorry no more tries bro");
            System.out.println("Do you want to play again?!(Yes(Y/y) or No(N/n)");
            String temp = scanner.nextLine();
            if (temp.equals("n") || temp.equals("N"))
                play = false;
            else
                System.out.println("See ya");
        }
    }
}