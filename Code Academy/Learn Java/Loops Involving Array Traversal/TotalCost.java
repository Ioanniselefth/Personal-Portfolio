public class TotalCost {
  public static double getTotalCost(double[] groceryPrices) {
    double totalCost = 0.0;
    for(int i =0; i<groceryPrices.length; i++){
      totalCost += groceryPrices[i];
    }
    return totalCost;
  }

  public static void main(String[] args) {
    double[] groceryPrices = {10.0, 12.3, 8.45, 2.43};
    System.out.println(getTotalCost(groceryPrices));
    
    double[] unlikelyGroceryPrices = {100.23, -100.23, 0.0, -78.54};
    System.out.println(getTotalCost(unlikelyGroceryPrices));
  }
}
/*
 * Your friend gave you a grocery list with a list of prices that correspond to
 * each item in the grocery list. This is so you can make sure you have enough
 * money to buy all the items.
 * 
 * Using a loop, update the getTotalCost() method to calculate the sum of all
 * the groceryPrices and store the result in totalCost.
 */