package JavaProjects;

public class ReverseListWithoutNew {
    public static void reverseGroceries(String[] groceryList) {
        int j = groceryList.length - 1;
        for (int i = 0; i < groceryList.length / 2; i++) {
            String temp = groceryList[i];
            String temp2 = groceryList[j];
            groceryList[i] = temp2;
            groceryList[j] = temp;
            j--;
        }

    }

    public static void main(String[] args) {
        String[] groceryList = { "apples", "banana", "Apples", "chocolate" };
        reverseGroceries(groceryList);

        for (String item : groceryList) {
            System.out.println(item);
        }
    }

}
/*
 * For example, your original list looked like this: ["banana", "chocolate",
 * "cookies", "ice cream"], but now it looks like this: ["ice cream", "cookies",
 * "chocolate", "banana"].
 * 
 * Without creating a new array, update the .reverseGroceries() method to
 * reverse the groceriesList back to normal.
 */