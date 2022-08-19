class Solution169:
    def majorityElement(self, nums: List[int]) -> int:
        majoritycount = len(nums)//2
        for i in range(0,len(nums)):
            counter = 0
            for j in range(0,len(nums)):
                if nums[i] == nums[j]:
                    counter += 1
            if counter > majoritycount:
                return nums[i]
        return -1
"""
169. Majority Element
Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

Example 1:
Input: nums = [3,2,3]
Output: 3

Example 2:
Input: nums = [2,2,1,1,1,2,2]
Output: 2
"""
