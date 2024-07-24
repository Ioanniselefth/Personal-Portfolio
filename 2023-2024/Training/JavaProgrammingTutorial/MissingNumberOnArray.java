import java.util.Arrays;

public class MissingNumberOnArray{
    private static int getMissingNumber(int[] numbers, int totalCount) {
        //expectedSum is taking the total count of the array and adding 1 to it and dividing it by 2
        int expectedSum = totalCount * ((totalCount + 1) / 2);
        int actualSum = 0;
        //iterating through the numbers array and adding each number to actualSum
        for (int i : numbers) {
            actualSum += i;
        }
        //returning the difference between expectedSum and actualSum which will tell if a number is missing and what it is
        return expectedSum - actualSum;
    }
    public static void main(String[] args){
        //q: test getMissingNumber with 5 tests
        int[] numbers = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13};
        int totalCount = numbers.length;
        System.out.println(totalCount);
        int missing = getMissingNumber(numbers, totalCount);
        System.out.printf("Missing number in array %s is %d %n", Arrays.toString(numbers), missing);
        
        numbers = new int[]{1,2,3,4,6,7,8,9,10,11,12,13};
        totalCount = numbers.length;
        System.out.println(totalCount);
        missing = getMissingNumber(numbers, totalCount);
        System.out.printf("Missing number in array %s is %d %n", Arrays.toString(numbers), missing);
        
        numbers = new int[]{0,1,2,3,5};
        totalCount = numbers.length;
        System.out.println(totalCount);
        missing = getMissingNumber(numbers, totalCount);
        System.out.printf("Missing number in array %s is %d %n", Arrays.toString(numbers), missing);

        
    }
}