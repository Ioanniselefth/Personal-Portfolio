public class PrintFirstNonRepeatingChar {
    
    public static void main(String[] args){
        // create a few tests for this method
        System.out.println(firstNonRepeatedCharacter("abcdefghija") == 'b');
        System.out.println(firstNonRepeatedCharacter("hello") == 'h');
        System.out.println(firstNonRepeatedCharacter("Java") == 'J');
        System.out.println(firstNonRepeatedCharacter("simplest") == 'i');
        // create new test
        System.out.println(firstNonRepeatedCharacter("aabbcc") == 0);
        // create new test
        System.out.println(firstNonRepeatedCharacter("aabbccddeeff") == 0);
        

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
