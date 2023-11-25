public class Solution26 {
    
    public int removeDuplicates(int[] nums) {
        int temp = 0;
        for(int i = 1; i<nums.length; i++){
            if(nums[i] == nums[i-1])
                temp++;
            nums[i-temp] = nums[i];
        }
        return nums.length - temp;
    }
}
//26. Remove Duplicates from Sorted Array
//Time Complexity: O(n)