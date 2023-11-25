#1672. Richest Customer Wealth

class Solution1672:
    def maximumWealth(self, accounts: List[List[int]]) -> int:
        max = 0
        for i in range(0,len(accounts)):
            temp = 0
            for j in range(0,len(accounts[i])):
                temp += accounts[i][j]
            if temp > max:
                max = temp
        return max