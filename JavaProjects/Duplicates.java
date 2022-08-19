package JavaProjects;

public class Duplicates {
    public static boolean hasDuplicates(String[] groceryList) {
        for (int i = 0; i < groceryList.length; i++) {
            for (int j = 0; j < groceryList.length; j++) {
                if (i == j) {
                    continue;
                }
                if (groceryList[i] == groceryList[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] groceryList = { "apples", "banana", "Apples", "chocolate" };
        System.out.println(hasDuplicates(groceryList));
    }
}
/*
 * For simplicity, we can assume that any items that are capitalized are
 * different from items with letters that are all lower case. For example,
 * “apples” are not the same as “appLes”.
 * 
 * Update .hasDuplicateItems() to return a boolean if there are duplicate items
 * in the list.
 */