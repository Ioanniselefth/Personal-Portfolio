#1502. Can Make Arithmetic Progression From Sequence

class Solution:
    def canMakeArithmeticProgression(self, arr: List[int]) -> bool:
        arr.sort()
        difference = abs(arr[0] - arr[1])
        for i in range(1, len(arr)-1):
            temp = abs(arr[i] - arr[i+1])
            if difference != temp:
                return False
        return True
