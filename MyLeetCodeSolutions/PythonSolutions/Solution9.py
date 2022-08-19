#9. Palindome Number
class Solution9:
    def isPalindrome(self, x: int) -> bool:
        temp = str(x)
        temp2 = temp[::-1]
        if temp == temp2:
            return True
        return False


"""
#9. Palindome Number
class Solution:
    def isPalindrome(self, x: int) -> bool:
        temp = str(x)
        j = len(temp)-1
        for i in range(0,len(temp)):
            if temp[i] != temp[j]:
                return False
            j-=1
        return True

class Solution:
    def isPalindrome(self, x:int) -> bool:
        return  x == str(x[::-1])

"""