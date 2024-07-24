public class CountUppercaseLetters {
    
    public static void main(String[] args){
        System.out.println(countUppercaseLetters("abcdefghija"));
        System.out.println(countUppercaseLetters("HeLlo"));
        System.out.println(countUppercaseLetters("Java"));
        System.out.println(countUppercaseLetters("SIMPLEST"));
    }

    public static int countUppercaseLetters(String str) {
        int counter = 0;
        for(int i = 0; i<str.length(); i++){
            if(Character.isUpperCase(str.charAt(i)) == true){
                counter += 1;
            }
        }
        return counter;
    }
}
