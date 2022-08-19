#53. Maximum Subarray

class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        curSum = maxSum = nums[0]
        for i in nums[1:]:
            curSum = max(i, curSum + i)
            maxSum = max(maxSum, curSum)
        return maxSum
