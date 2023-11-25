package JavaProjects;

import java.util.Scanner;
import java.util.Random;

/*
 * Valid user input :
 *  - rock, paper,scissor/scissors
 *  - r, p, s
 */
public class RockPaperScissors {
    final static Scanner scanner = new Scanner(System.in);
    final static Random random = new Random();
    private static String[] computerOptions = { "rock", "paper", "scissors" };

    private static String formatInput(String temp) {
        String temp2 = "";
        if (temp == "r") {
            temp2 = "rock";
        } else if (temp == "s" || temp == "scissor") {
            temp2 = "scissors";
        } else if (temp == "p") {
            temp2 = "paper";
        } else {
            temp2 = temp;
        }
        return temp2;
    }

    private static void game(String input1) {
        String choice = formatInput(input1);
        int index = random.nextInt(computerOptions.length);
        String computerChoice = computerOptions[index];
        System.out.println("Your choice is:" + formatInput(input1));
        System.out.println("Computer's choice is:" + computerChoice);
        if (choice.equals(computerChoice)) {
            System.out.println("It's a draw LOL");
        } else if ((choice == "rock" && computerChoice == "paper")
                || (choice == "paper" && computerChoice == "scissors")
                || (choice == "scissors" && computerChoice == "rock")) {
            System.out.println("HAHAHAHAHAA");
            System.out.println("CRYING OUT LOUD!");
            System.out.println("COMPUTER WON LOL");
        } else {
            System.out.println("I guess you won?");
            System.out.println("Big deal bro chill");
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Rock Paper Scissors bruh");
        System.out.println("All good bruv?!");
        System.out.println("Don't give a shit make a choice");
        Boolean play = true;
        String input = scanner.nextLine();
        while (play == true) {
            while (input == "r" && input == "p" && input == "s" && input == "rock" &&
                    input == "paper"
                    && input == "scissor" && input == "scissors") {
                game(input);
                System.out.println("Do you want to play again?!");
                System.out.println("(Y-Yes/N-No)");
                String temp = scanner.nextLine();
                if (temp == "Y" || temp == "yes" || temp == "Yes") {
                    play = true;
                } else if (temp == "N" || temp == "no" || temp == "No") {
                    play = false;
                }
            }
            System.out.println("You litteraly had the easiest job in the world.");
            System.out.println("Who even gives bad input on a rock-paper-scissors game LOL.");
            System.out.println("Give again trashcan");
            input = scanner.nextLine();
        }
    }
}
