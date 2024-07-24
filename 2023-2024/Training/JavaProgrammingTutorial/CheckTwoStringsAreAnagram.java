import java.util.Arrays;

public class CheckTwoStringsAreAnagram {
    
    public static void main(String args[]) {
        isAnagram("word", "wrdo");
        isAnagram("mary", "army");
        isAnagram("stop", "tops");
        isAnagram("boat", "btoa");
        isAnagram("pure", "in");
        isAnagram("fill", "fil");
        isAnagram("b", "bbb");
        isAnagram("ccc", "ccccccc");
        isAnagram("a", "a");
        isAnagram("sleep", "slep");
    }

    public static void isAnagram(String string, String string2){
        char[] charFromWord = string.toCharArray();
        char[] charFromAnagram = string2.toCharArray();       
        Arrays.sort(charFromWord);
        Arrays.sort(charFromAnagram);
       
        System.out.println("String 1: "+ string +" " +"String 2: "+ string2+" " + Arrays.equals(charFromWord, charFromAnagram));
    }
}
