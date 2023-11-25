package JavaProjects;

import java.util.Scanner;

public class Calculator {
    final static Scanner scanner = new Scanner(System.in);

    // multiplication
    public static int multiplication(int num, int num2) {
        return num * num2;
    }

    // subtraction
    public static int subtraction(int num, int num2) {
        return num - num2;
    }

    // adding
    public static int add(int num, int num2) {
        return num + num2;
    }

    // division
    public static int division(int num, int num2) {
        return num / num2;
    }

    // Main function
    public static void main(String[] args) {
        System.out.println("Give the first number");
        int number = scanner.nextInt();
        System.out.println("Give the operation you want to perform");
        String str = scanner.next();
        System.out.println("Give the second number");
        int number2 = scanner.nextInt();
        if (str.equals("*") || str.equals("."))
            System.out.println(number + " * " + number2 + " = " + multiplication(number, number2));
        else if (str.equals("/"))
            System.out.println(number + " / " + number2 + " = " + division(number, number2));
        else if (str.equals("+"))
            System.out.println(number + " + " + number2 + " = " + add(number, number2));
        else if (str.equals("-"))
            System.out.println(number + " - " + number2 + " = " + subtraction(number, number2));
        else
            System.out.println("Wrong input!");
    }
}