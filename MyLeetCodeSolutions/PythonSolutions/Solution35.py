#35. Search Insert Position
class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        j = 0
        for i in range(0, len(nums)):
            if target == nums[i]:
                return i
        while target >= nums[j]:
            j += 1
            if j == len(nums):
                break
        return j
