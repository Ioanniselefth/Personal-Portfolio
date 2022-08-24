package JavaProjects;

import java.util.Scanner;

public class Discount {
    final static Scanner scanner = new Scanner(System.in);

    // function that returns the final price of the item
    public static double discountedPrice(int pr, int disc) {
        double percentage = disc % pr;
        System.out.println(percentage);
        return percentage;
    }

    // main Function
    public static void main(String[] args) {
        System.out.println("Please enter the price: ");
        int price = scanner.nextInt();
        System.out.println("Please enter the discount percentage as an integer number: ");
        int discount = scanner.nextInt();
        System.out.println("Starting price is: " + price);
        System.out.println("Discounted price is: " + discountedPrice(price, discount));

    }
}
