package JavaProjects.ChattyBot;

import java.util.Scanner;

class SimpleBot {
    final static Scanner scanner = new Scanner(System.in);

    static void greet(String name, String date) {
        System.out.println("Hello! My name is " + name + ".");
        System.out.println("I was created in " + date + ".");
    }

    static void remindName() {
        System.out.println("Please remind me your name.");
        String name = scanner.next();
        System.out.println("What a great name you have, " + name + "!");

    }

    static void findAge() {
        System.out.println("Let me guess your age.");
        System.out.println("Enter remainders of dividing your age by 3, 5 and 7.");
        int remainder3 = scanner.nextInt();
        int remainder5 = scanner.nextInt();
        int remainder7 = scanner.nextInt();
        int age = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105;
        System.out.println("Your age is " + age + "; that's a good time to start programming!");

    }

    static void proveCount() {
        System.out.println("Now I will prove to you that I can count to any number you want.");
        int temp = scanner.nextInt();
        for (int i = 0; i <= temp; i++) {
            System.out.println(i + "!");
        }
        System.out.println("Completed, have a nice day!");

    }

    static void test() {
        System.out.println("Let's test your programming knowledge.");
        System.out.println("Why do we use methods?");
        System.out.println("1. To repeat a statement multiple times.");
        System.out.println("2. To decompose a program into several small subroutines.");
        System.out.println("3. To determine the execution time of a program.");
        System.out.println("4. To interrupt the execution of a program.");
        int temp = scanner.nextInt();
        while (temp != 2) {
            System.out.println("Please, try again.");
            temp = scanner.nextInt();
        }
        System.out.println("Congratulations, have a nice day!");
    }

    public static void main(String[] args) {
        greet("Dickhead", "12.08.2022");
        remindName();
        findAge();
        proveCount();
        test();
    }
}