package JavaProjects;

import java.util.Scanner;

public class CurrencyConverter {
    final static Scanner scanner = new Scanner(System.in);
    private static String[] currenciesAvailable = { "EUR", "USD", "GBP", "CAD", "JPY" };

    private static double convert(String curre, String curToConvert, double money) {
        if (curre.equalsIgnoreCase("eur") && curToConvert.equalsIgnoreCase("usd"))
            return money * 1.20;
        if (curre.equalsIgnoreCase("usd") && curToConvert.equalsIgnoreCase("eur"))
            return money / 1.20;
        if (curre.equals("eur") && curToConvert.equals("gbp"))
            return money / 1.15;
        if (curre.equals("gbp") && curToConvert.equals("eur"))
            return money * 1.15;
        return money;
    }

    public static void main(String[] args) {
        System.out.println("Hello to the currency converter!");
        System.out.println("Choose your currency!");
        System.out.print("Currencies available: ");
        for (int i = 0; i < currenciesAvailable.length; i++) {
            System.out.print(currenciesAvailable[i] + " ");
        }
        Boolean convert = true;
        while (convert == true) {
            String choice = scanner.nextLine();
            if ((choice.equals("EUR") || choice.equals("USD") || choice.equals("GBP") || choice.equals("CAD")
                    || choice.equals("JPY"))
                    || (choice.equals("eur") || choice.equals("usd") || choice.equals("gbp") || choice.equals("cad")
                            || choice.equals("jpy"))) {
                System.out.println("Choose currency to convert to ");
                String currencyToConvert = scanner.nextLine();
                while (currencyToConvert.equalsIgnoreCase(choice)) {
                    System.out.println("SAME INPUTS LOL DUMBASS");
                    System.out.println("Try again bruv");
                    currencyToConvert = scanner.nextLine();
                }
                System.out.println("Input amount you want to convert");
                double moneyToConvert = scanner.nextDouble();
                double temp = convert(choice, currencyToConvert, moneyToConvert);
                System.out.println(
                        moneyToConvert + " " + choice + " converts to: " + temp + " " + currencyToConvert);
                System.out.println("Do you want to make another conversion(Y/Yes/YES-N/No/NO)");
                String input = scanner.nextLine();
                if (input.equals("N") || input.equals("N") || input.equals("NO"))
                    convert = false;
            } else {
                System.out.println("NICE ONE DUDE! LOL");
                System.out.println("Please input a correct input");
                choice = scanner.nextLine();
            }
        }
    }
}