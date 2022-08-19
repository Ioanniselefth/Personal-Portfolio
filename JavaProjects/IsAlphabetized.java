package JavaProjects;

public class IsAlphabetized {
    public static boolean isAlphabetized(String[] groceryList) {
        if (groceryList.length > 1) {
            String lastGroceryItem = groceryList[0];

            for (int i = 1; i < groceryList.length; i++) {
                if (lastGroceryItem.compareTo(groceryList[i]) > 0) {
                    return false;
                }

                lastGroceryItem = groceryList[i];
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[] groceryList = { "apples", "banana", "bananas", "chocolate" };
        System.out.println(isAlphabetized(groceryList));
    }
}
/*
 * Update the isAlphabetized() method to return true if the list is in ascending
 * alphabetical order or false if it is not.
 */