//977. Squares of a Sorted Array
import java.util.Arrays;

class Solution977 {
    public int[] sortedSquares(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
            System.out.println(nums[i]);
        }
        Arrays.sort(nums);
        return nums;
    }
}