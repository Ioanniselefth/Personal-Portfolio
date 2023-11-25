class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        int[] temp = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    temp[0] = i;
                    temp[1] = j;
                    // Could use break
                }
            }
        }
        return temp;
    }
}
//1.Two Sum
// Time Analysis = C1(n)*C2(n) = O(n)^2