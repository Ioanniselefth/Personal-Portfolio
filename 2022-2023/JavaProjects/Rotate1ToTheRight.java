package JavaProjects;

public class Rotate1ToTheRight {
    public static void rotateGroceries(String[] groceryList) {
        if (groceryList.length > 1) {
            String previous = groceryList[groceryList.length - 1];
            for (int i = 0; i < groceryList.length; i++) {
                String temp = groceryList[i];
                groceryList[i] = previous;
                previous = temp;
            }
        }
    }

    public static void main(String[] args) {
        String[] groceryList = { "apples", "banana", "Apples", "chocolate" };
        rotateGroceries(groceryList);

        for (String item : groceryList) {
            System.out.println(item);
        }
    }
}
/*
 * looked like this: ["banana", "chocolate", "cookies", "ice cream"], but now it
 * looks like this: ["chocolate", "cookies", "ice cream", "banana"].
 * 
 * Without creating a new array, update the .rotateGroceries() method to rotate
 * the items one place to the right.
 */