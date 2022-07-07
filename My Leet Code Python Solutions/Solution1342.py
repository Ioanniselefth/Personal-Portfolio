#1342. Number of Steps to Reduce a Number to Zero
class Solution1342:
    def numberOfSteps(self, num: int) -> int:
        counter = 0
        while(num!=0):
            if num%2==0:
                num/=2
                counter+=1
            elif num%2==1:
                num-=1
                counter+=1
        return counter