//1480. Running Sum of 1d Array
class Solution1480 {
    public int[] runningSum(int[] nums) {
        int sum = 0;
        int temp[] = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            temp[i] = sum;
        }
        return temp;
    }
}
//Time Complexity = C1(n) = O(n)