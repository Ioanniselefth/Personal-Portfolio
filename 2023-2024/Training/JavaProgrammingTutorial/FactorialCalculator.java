public class FactorialCalculator {
    //generate 4 test cases in the main method
    public static void main(String[] args){
        System.out.println(calculateFactorial(5));
        System.out.println(calculateFactorial(0));
        System.out.println(calculateFactorial(-1));
        System.out.println(calculateFactorial(10));
    }

    public static int calculateFactorial(int number) {
        if(number<0)
            return -1;
        int counter = 1; 
        for(int i = 1; i<=number; i++){
            counter *= i;
        }
        return counter;
    }
}
