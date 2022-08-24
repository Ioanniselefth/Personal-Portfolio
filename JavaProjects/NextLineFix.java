package JavaProjects;

//To demonstrate the working of nextLine() method

import java.util.*;

public class NextLineFix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // This part takes the input
        System.out.println("Input the Roll Number:");
        int number = sc.nextInt();
        System.out.println("Input your full name:");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.println("Input your branch:");
        String branch = sc.nextLine();

        // This part prints the values
        System.out.println("Roll No: " + number);
        System.out.println("Name: " + name);
        System.out.println("Branch: " + branch);
    }
}