package JavaProjects;

public class MostExpensiveItem {
    public static double getMostExpensiveItemCost(double[] groceryPrices) {
        double maxCost = groceryPrices[0];
        for (int i = 0; i < groceryPrices.length; i++) {
            if (maxCost < groceryPrices[i]) {
                maxCost = groceryPrices[i];
            }
        }
        return maxCost;
    }

    public static void main(String[] args) {
        double[] groceryPrices = { 10.0, 12.3, 8.45, 2.34 };
        System.out.println(getMostExpensiveItemCost(groceryPrices));
    }
}
/*
 * All the items in the grocery list cost a total of $33.09, but you only have
 * $31.89. Given that every item in the list costs at least $1.20 and there is
 * at least one item in the list, you can remove one item to stay within your
 * budget. Update the .getMostExpensiveItemCost() method to find the most
 * expensive item in the array of groceryPrices, and return the item.
 */