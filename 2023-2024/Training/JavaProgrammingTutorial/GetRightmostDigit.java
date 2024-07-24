public class GetRightmostDigit {
    
    public static void main(String[] args){
        System.out.println(getRightmostDigit("I bought 5 apples, 4 bananas, and 3 oranges"));
        System.out.println(getRightmostDigit("There are no numbers in this string"));
        System.out.println(getRightmostDigit("Java 31"));
        System.out.println(getRightmostDigit("SIMPLE2ST"));
        System.out.println(getRightmostDigit("1"));
        System.out.println(getRightmostDigit("H"));
        System.out.println(getRightmostDigit("HHH"));

    }

    public static int getRightmostDigit(String str) {
        for(int i = str.length()-1; i>=0; i--){
            if(Character.isDigit(str.charAt(i)))
                return Character.getNumericValue(str.charAt(i));
        }
        return -1;
    }
}
