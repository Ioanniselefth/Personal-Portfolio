class Solution169 {
    public int majorityElement(int[] nums) {
        int majoritycount = nums.length/2;
        for(int i = 0; i<nums.length; i++){
            int counter = 0;
            for(int j = 0; j<nums.length; j++){
                if(nums[i] == nums[j]){
                    counter += 1;
                }
            }
            
            if(counter > majoritycount){
                return nums[i];
            }
        }
        return -1;
    }
}
//169. Majority Element
//Time Complexity: O(n^2)
/*
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 

Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
*/