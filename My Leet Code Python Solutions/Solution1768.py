#1768. Merge Strings Alternately

class Solution1768:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        temp = "" 
        i = 0
        while i<len(word1) and i<len(word2):
            temp += word1[i] + word2[i]
            i+=1
        temp += word1[i:] + word2[i:]
        return temp
                