public class PrintFirstNonRepeatingCharOfString {
    
    public static void main(String[] args){
        System.out.println(firstNonRepeatedCharacter("abcdefghija"));
        System.out.println(firstNonRepeatedCharacter("hello"));
        System.out.println(firstNonRepeatedCharacter("Java"));
        System.out.println(firstNonRepeatedCharacter("simplest"));
    }

    public static char firstNonRepeatedCharacter(String string){
        boolean notRepeated = false;
        for(int i=0; i<string.length(); i++){
            for(int j=0; j<string.length(); j++){
                if(i != j && string.charAt(i)==string.charAt(j)){
                    notRepeated = true;
                }
            }
            if(notRepeated == false){
                return string.charAt(i);
            }
        }
        return 0;
    }
}
