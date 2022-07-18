class Solution27 {
    public int removeElement(int[] nums, int val) {
        int j = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] != val){
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
//27. Remove Element
//Time Complexity: 1 for loop equaals to => O(n)