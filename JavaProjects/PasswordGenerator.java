package JavaProjects;

import java.util.Scanner;
import java.util.Random;

public class PasswordGenerator {
    final static Scanner scanner = new Scanner(System.in);
    final static Random random = new Random();

    static String generatepassword(int len) {
        String password = "";
        char[] everyCharacter = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'I', 'J', 'K',
                'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u',
                'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                ',', '!', '@', '#', '$', '%', '^', '&', '*', '_', '=', '+', '-', '/', '€', '.', '?', '<', '>', ')' };
        for (int i = 0; i < len; i++) {
            int temp = random.nextInt(everyCharacter.length);
            System.out.println(temp);
            password += everyCharacter[temp];
        }
        return password;
    }

    public static void main(String[] args) {
        System.out.println("Give the length of the password of which you wanna have(min 4 and max 10 characters): ");
        int length = scanner.nextInt();
        while (length < 4 || length > 10) {
            System.out.println("Wrong input. Give another length for the password:");
            length = scanner.nextInt();
        }
        String temp = generatepassword(length);
        System.out.println("Your Password:");
        System.out.println(temp);
    }
}
