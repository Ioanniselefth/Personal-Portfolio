#121. Best Time to Buy and Sell Stock
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        difference, current, min = 0, 0, prices[0]
        for i in range(0, len(prices)):
            if prices[i] < min:
                min = prices[i]
            current = prices[i] - min
            if difference < current:
                difference = current
        return difference
