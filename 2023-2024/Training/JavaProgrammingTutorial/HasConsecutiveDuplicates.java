public class HasConsecutiveDuplicates {
    
    public static void main(String[] args){
        System.out.println(hasConsecutiveDuplicates("abcdefghija"));
        System.out.println(hasConsecutiveDuplicates("Hello"));
        System.out.println(hasConsecutiveDuplicates("Java"));
        System.out.println(hasConsecutiveDuplicates("SIMPLEST"));
        System.out.println(hasConsecutiveDuplicates(""));
        System.out.println(hasConsecutiveDuplicates("H"));
        System.out.println(hasConsecutiveDuplicates("HHH"));

    }

    public static boolean hasConsecutiveDuplicates(String str) {
        // TODO: Write your code here
        for(int i=0; i<str.length()-1; i++){
            if(str.charAt(i) == str.charAt(i+1))
                return true;
        }
        return false;
        
    }
}
