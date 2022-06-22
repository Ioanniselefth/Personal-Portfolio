/*35. Search Insert Position
    -if target == found
        -return index
    -else
        -return the index where it would be if it were inserted in order
    -O(log n) complexity
*/
class Solution {
    public int searchInsert(int[] nums, int target) {
        for(int i=0; i<nums.length; i++){
            if(target == nums[i]){
                return i;
            }
        }
        int j=0;
        while(target>=nums[j]){
            j++;
            if(j == nums.length){
                break;
            }
        }
        return j;
    }
}