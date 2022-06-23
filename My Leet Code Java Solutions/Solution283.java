//283. Move Zeroes

class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                j++;
            } else if (j != 0) {
                nums[i - j] = nums[i];
                nums[i] = 0;
            }
        }
    }
}