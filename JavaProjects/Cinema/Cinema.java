package JavaProjects.Cinema;

import java.util.Scanner;
import java.util.Arrays;

public class Cinema {
    final static Scanner scanner = new Scanner(System.in);
    private static int rows = 0;
    private static int cols = 0;
    static String[][] seats;

    Cinema(int rows, int cols) {
        seats = createEmptySeats(rows, cols);
    }

    static String[][] createEmptySeats(int rows, int cols) {
        String[][] seats = new String[rows][];
        for (int i = 0; i < rows; i++) {
            String[] row = new String[cols];
            Arrays.fill(row, "S");
            seats[i] = row;
        }
        return seats;
    }

    static void start() {
        System.out.println();
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int i = 1; i <= cols; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 1; i <= rows; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < cols; j++) {
                System.out.print("S" + " ");
            }
            System.out.println();
        }
    }

    static int revenue() {
        int seats = rows * cols;
        int profit;
        System.out.println("Total income: ");
        if (seats <= 60) {
            profit = seats * 10;
        } else {
            int frontHalf = (rows / 2) * cols;
            int backHalf = seats - frontHalf;
            profit = frontHalf * 10 + backHalf * 8;
        }
        return profit;
    }

    static int getpriceofticket(int temprow, int tempcol) {
        int seats = rows * cols;
        Boolean isFirstHalf = false;
        if (temprow <= rows / 2) // rows = 10
            isFirstHalf = true; // isFirstHalf True if 1-5
        if (seats <= 60)
            return 10;
        if (seats > 60 && isFirstHalf)
            return 10;
        return 8;
    }

    public static void main(String[] args) {
        System.out.println("Enter the number of rows:");
        Cinema.rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        Cinema.cols = scanner.nextInt();

        start();
        System.out.println();
        System.out.println("$" + revenue());
        System.out.println();

        System.out.println("Enter a row number: ");
        int inputrow = scanner.nextInt();
        System.out.println("Enter a seat number: ");
        int inputcol = scanner.nextInt();
        System.out.println();
        System.out.println("Ticket price: $" + getpriceofticket(inputrow, inputcol));
    }
}
