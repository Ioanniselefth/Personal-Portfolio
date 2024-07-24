public class GetSumOfDigits {

    //generate test cases in main method
    public static void main(String[] args){
        System.out.println(getSumOfDigits(123));
        System.out.println(getSumOfDigits(0));
        System.out.println(getSumOfDigits(-1));
        System.out.println(getSumOfDigits(10));
    }


    public static int getSumOfDigits(int number) {
        if(number < 0)
            return -1;
        if (number == 0)
            return 0;
        int counter = 0; 
        while(number >= 1){
            int current = number % 10; 
            counter += current;
            number /= 10;
        }
        return counter;

    }
    
}
