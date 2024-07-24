import java.util.ArrayList;
import java.util.Arrays;

public class RemoveDuplicatesFromArray {
    
    public static ArrayList<Integer> removeDuplicates(int[] array){
        ArrayList<Integer> arrayWithoutDuplicates = new ArrayList<Integer>();
        Arrays.sort(array);   
        for(int i=0; i<array.length-1; i++){
            if(array[i] != array[i+1]){
                arrayWithoutDuplicates.add(array[i]);
            }
        }
        return arrayWithoutDuplicates;
    }

    public static void main(String args[]) {

        int[][] test = new int[][]{
            {1, 1, 2, 2, 3, 4, 5},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 2, 3, 4, 5, 6, 7},
            {1, 2, 1, 1, 1, 1, 1},};

        for (int[] input : test) {
            System.out.println("Array with Duplicates       : " + Arrays.toString(input));
            System.out.println("After removing duplicates   : " + (removeDuplicates(input)));
        }
    }
}
