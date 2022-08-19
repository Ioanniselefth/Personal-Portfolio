#2108. Find First Palindromic String in the Array
#Time Complexity: O(n)
class Solution2108:
    def firstPalindrome(self, words: List[str]) -> str:
        for i in range(0,len(words)):
            temp = words[i]
            if temp == temp[::-1]:
                return temp
        return ""