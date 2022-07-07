//1342. Number of Steps to Reduce a Number to Zero
class Solution1342 {
    public int numberOfSteps(int num) {
        int counter = 0;
        while(num!=0){
            if(num % 2==0){
                num/=2;
                counter++;
            }
            else if(num%2==1){
                num -= 1;
                counter++;
            }
        }
        return counter;
    }
}