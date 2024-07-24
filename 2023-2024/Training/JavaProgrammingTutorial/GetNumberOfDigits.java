public class GetNumberOfDigits {
    
    //generate test cases in main method
    public static void main(String[] args){
        System.out.println(getNumberOfDigits(123));
        System.out.println(getNumberOfDigits(0));
        System.out.println(getNumberOfDigits(-1));
        System.out.println(getNumberOfDigits(10));
    }

    /**
     * This method calculates and returns the number of digits in a given integer.
     * If the number is negative, it returns -1.
     * If the number is zero, it returns 1 as zero is considered to have one digit.
     * @param number: an integer
     * @return number of digits in number, or -1 if number is negative, or 1 if number is zero.
     */
    public static int getNumberOfDigits(int number) {
        if (number < 0)
            return -1;
        if (number == 0)
            return 1;
        int counter = 0;
        while(number>=1){
            counter += 1;
            number = number / 10;
            
        }
        return counter;
    }
}
