//217. Contains Duplicate
import java.util.Arrays;

class Solution217 {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);// const
        for (int i = 0; i < nums.length - 1; i++) {// C1(n)
            if (nums[i] == nums[i + 1]) {// const
                return true;// const
            }
        }
        return false;// const
    }
}
// Complexity= C1(n)=O(n)