//1822. Sign of the Product of an Array

import java.util.Arrays;

class Solution {
    public int arraySign(int[] nums) {
        int temp = 1;
        for (int i = 0; i < nums.length; i++) {
            temp = temp * signFunc(nums[i]);
        }
        return temp;
    }

    public int signFunc(int x) {
        if (x > 0) {
            return 1;
        } else if (x < 0) {
            return -1;
        }
        return 0;
    }
}
