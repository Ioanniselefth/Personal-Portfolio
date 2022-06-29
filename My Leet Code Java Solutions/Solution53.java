//53. Maximum Subarray
//Time Complexity:-line 3:constant, line 4: C1(n)-for loop, line 5,6: Constants, line 8:constants
//Time Complexity = C1(n) = O(n)

class Solution53 {
    public int maxSubArray(int[] nums) {
        int maxSoFar = nums[0], maxEndingHere = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
}
