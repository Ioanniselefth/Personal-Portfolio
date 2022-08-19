import java.util.Scanner;
import java.util.Random;

/**********************************************
 * Simple game made by Frekvens1
 * - Version 1.1
 * - Self explaining code
 * - Made for newer developers to learn more
 ***********************************************
 * 
 * Changelog
 ***********************************************
 * 
 * 1.1:
 * - Bug fixes
 * - Added more inputs
 * - Increased readability
 * - Optimized some functions
 * - Added changelog and credits
 ***********************************************
 * 
 * Credits - Thanks for testing my code!
 ***********************************************
 * 
 * Shlvam Rawat & Sasha_Kuprii
 * - Shortened the inputs to "r, p, s"
 * 
 * Ivan
 * - Made me convert to switch, as its more correct usage.
 * 
 * Gabriel Carvalho
 * - Bug hunter: "NoSuchElementException" when input was null
 * 
 * Alexandre da Costa Leite
 * - Bug hunter: Changing from && to || in function check for win
 * - Important change if converting this to multiplayer
 ***********************************************
 * 
 * Uploaded 19.07.2016 (DDMMYYYY)
 * Last updated 04.02.2017 (DDMMYYYY)
 **********************************************/

public class RockPaperScissors {
    /*
     * Valid user input:
     * rock, paper, scissors, scissor
     * r, p, s
     */
    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);

            if (sc.hasNext()) { // Checks for null values

                String userInput = quickFormat(sc.next());
                sc.close();

                if (isValid(userInput)) {
                    game(userInput);

                } else {
                    displayInputs();
                }
            } else {
                displayInputs(); // Null value, displaying correct inputs
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void game(String user) {
        String computer = computerResults();

        print(user + " vs " + computer + "\n");

        if (user.equalsIgnoreCase(computer)) {
            print("Stalemate! No winners.");
        } else {

            if (checkWin(user, computer)) {
                print("You won against the computer!");
            } else {
                print("You lost against the computer!");
            }
        }
    }

    public static String computerResults() {

        String types[] = { "rock", "paper", "scissors" };

        Random rand = new Random();
        int computerChoice = rand.nextInt(3);

        return types[computerChoice];
    }

    public static boolean isValid(String input) {

        switch (input.toLowerCase()) {

            case "rock":
                return true;

            case "paper":
                return true;

            case "scissors":
                return true;

            default:
                return false;
        }
    }

    public static boolean checkWin(String user, String opponent) {

        if ((!isValid(user)) || (!isValid(opponent))) {
            return false;
        }

        String rock = "rock", paper = "paper", scissors = "scissors";

        if ((user.equalsIgnoreCase(rock)) && (opponent.equalsIgnoreCase(scissors))) {
            return true;
        }

        if ((user.equalsIgnoreCase(scissors)) && (opponent.equalsIgnoreCase(paper))) {
            return true;
        }

        if ((user.equalsIgnoreCase(paper)) && (opponent.equalsIgnoreCase(rock))) {
            return true;
        }

        return false;
        // If no possible win, assume loss.
    }

    /**********************************************
     * Libraries
     **********************************************/

    public static void displayInputs() {
        // One place to edit it all!
        print("Invalid user input!\nWrite rock, paper or scissors!");
    }

    public static void print(String text) {
        // Makes printing text easier
        System.out.println(text);
    }

    public static String quickFormat(String input) {
        // Just some quick function to shorten inputs.

        String output = input;

        switch (input.toLowerCase()) {

            case "r":
                output = "rock";
                break;

            case "p":
                output = "paper";
                break;

            case "s":
                output = "scissors";
                break;

            case "scissor":
                output = "scissors";
                break;
        }

        return output;
    }
}