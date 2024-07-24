public class FindLongestWord {

    //generate test cases in main method
    public static void main(String[] args) {
        FindLongestWord findLongestWord = new FindLongestWord();
        System.out.println(findLongestWord.findLongestWord("The quick brown fox"));
        System.out.println(findLongestWord.findLongestWord("The quick brown fox jumps over the lazy dog"));
        System.out.println(findLongestWord.findLongestWord("The quick brown fox jumps over the lazy dog and the cat"));
        System.out.println(findLongestWord.findLongestWord("The quick brown fox jumps over the lazy dog and the cat and the mouse"));
        System.out.println(findLongestWord.findLongestWord("A quick brown fox jumps over the lazy dog"));
        System.out.println(findLongestWord.findLongestWord("Java is an object oriented programming language"));
    }

    

    public String findLongestWord(String sentence) {
 
        // Edge Case: If the sentence is empty, return an empty string
        if (sentence.isEmpty()) {
            return "";
        }
 
        // Split the sentence into words using space as the separator
        String[] words = sentence.split(" ");
 
        // Initialize variables to keep track of the longest word and its length
        String longestWord = "";
        int maxLength = 0;
 
        // Iterate over each word in the words array
        for (String word : words) {
 
            // If the length of the current word is more than maxLength, update longestWord and maxLength
            if (word.length() > maxLength) {
                longestWord = word;
                maxLength = word.length();
            }
        }
 
        // Return the longest word found in the sentence
       
 
        return longestWord;
    }
}
