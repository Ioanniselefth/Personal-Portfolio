#704. Binary Search
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums)-1
        while low <= high:
            pivot = low + (high - low)
            if nums[pivot] == target:
                return pivot
            if target < nums[pivot]:
                high = pivot - 1
            else:
                low = pivot + 1
        return -1
