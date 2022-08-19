#724. Find Pivot index
class Solution:
    def pivotIndex(self, nums: List[int]) -> int:
        sum1 = 0
        leftsum = 0
        for x in nums:
            sum1 += x
        for i in range(0, len(nums)):
            if leftsum == sum1 - leftsum - nums[i]:
                return i
            leftsum += nums[i]
        return -1
