public class WordReverser {

    public String reverseWordsInSentence(String sentence) {
        // Check if the sentence is null
        if (sentence == null) {
            return "INVALID";
        }

        // Check if the sentence is empty
        if (sentence.isEmpty()) {
            return "";
        }

        // Split the sentence into words using space as the delimiter
        String[] words = sentence.split(" ");

        // Create a StringBuilder to hold the reversed sentence
        StringBuilder reversedSentence = new StringBuilder();

        // Loop through each word in the words array
        for (String word : words) {
            // For each word, create a StringBuilder and reverse the word
            StringBuilder reversedWord = new StringBuilder(word).reverse();
            // Append the reversed word, followed by a space, to the reversed sentence
            reversedSentence.append(reversedWord).append(" ");
        }

        // After reversing all the words, trim the trailing space and return the reversed sentence
        return reversedSentence.toString().trim();
    }

    public static void main(String[] args) {
        // Test cases
        WordReverser sm = new WordReverser();
        System.out.println(sm.reverseWordsInSentence("Hello World")); // "olleH dlroW"
        System.out.println(sm.reverseWordsInSentence(""));            // ""
        System.out.println(sm.reverseWordsInSentence(null));          // "INVALID"
        System.out.println(sm.reverseWordsInSentence("Java is fun")); // "avaJ si nuf"
    }
}
