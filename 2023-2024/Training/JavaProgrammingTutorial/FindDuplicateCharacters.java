public class FindDuplicateCharacters {
    
    public static void main(String args[]) {
        printDuplicateCharacters("Programming");
        printDuplicateCharacters("Combination");
        printDuplicateCharacters("Java");
        printDuplicateCharacters("1234");
        printDuplicateCharacters("Sian");
        printDuplicateCharacters("ioannis");
    }

    public static void printDuplicateCharacters(String string){
        char[] characters = string.toCharArray();
        
        for(int i=0; i<characters.length; i++){
            for(int j=0; j<characters.length; j++){
                if(characters[i] == characters[j] && i != j){
                    System.out.print(characters[i]);
                    break;
                }
            }
        }
        
        System.out.println();
    }
}
