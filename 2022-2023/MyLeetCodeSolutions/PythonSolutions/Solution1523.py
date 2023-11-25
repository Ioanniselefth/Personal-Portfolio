#1523. Count Odd Numbers in an Interval Range
class Solution:
    def countOdds(self, low: int, high: int) -> int:
        total = high - low + 1
        if(low % 2 == 1 and high % 2 == 1):
            return int(total/2+1)
        return int(total/2)
