#1480. Running Sum of 1d Array
class Solution:
    def runningSum(self, nums: List[int]) -> List[int]:
        counter = 0
        for i in range(0, len(nums)):
            counter += nums[i]
            nums[i] = counter
        return nums
