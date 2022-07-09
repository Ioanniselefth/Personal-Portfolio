public class NumOfEveryItem {
    public static int getNumAllergicItems(String[] groceryList) {
        int numAllergicItems = 0;
        for (int i = 0; i < groceryList.length; i++) {
            if (groceryList[i].length() > 5)
                numAllergicItems++;
        }

        return numAllergicItems;
    }

    public static void main(String[] args) {
        String[] groceryList = { "apple", "milk", "banana", "bananas", "chocolate" };

        System.out.println(getNumAllergicItems(groceryList));
    }
}
/*
 * Update the .getNumAlllergicItems() method to count up the number of items in
 * groceryList that has more than 5 letters. Set it to numAllergicItems.
 */