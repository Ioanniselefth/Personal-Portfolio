public class GetLastDigit {

    //generate test classes for main method
    public static void main(String[] args){
        System.out.println(getLastDigit(123));
        System.out.println(getLastDigit(0));
        System.out.println(getLastDigit(-1));
        System.out.println(getLastDigit(10));
    }

    public static int getLastDigit(int number) {
        if(number<0)
            return -1;
        return number%10;
    }
}
