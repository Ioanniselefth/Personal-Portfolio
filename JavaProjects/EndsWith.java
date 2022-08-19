public class EndsWith {
    public static boolean hasSpecialItem(double[] groceryPrices) {
        for (int i = 0; i < groceryPrices.length; i++) {
            String itemCost = String.valueOf(groceryPrices[i]);
            if (itemCost.length() > 1 && itemCost.substring(itemCost.length() - 2, itemCost.length()).equals("99")) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        double[] groceryList = { 10.0, 89.9, 8.99, 2.34 };
        System.out.println(hasSpecialItem(groceryList));
    }
}
/*
 * Update the .hasSpecialItem() method to return true if there is an item in
 * your list that ends with 99 cents, and false if there is not an item that
 * ends with 99 cents.
 */