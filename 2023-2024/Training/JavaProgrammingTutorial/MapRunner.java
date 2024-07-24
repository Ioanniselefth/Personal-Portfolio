import java.util.Map;
import java.util.HashMap;

public class MapRunner {
    public static void main(String[] args) {
        String str = "This is an awesome occassion. This has never happened before.";
        char[] characters = str.toCharArray();
        Map<Character, Integer> occurrences = new HashMap<>();
        for (char character : characters) {
            Integer count = occurrences.get(character);
            if (count == null) {
                occurrences.put(character, 1);
            } else {
                occurrences.put(character, count + 1);
            }
        }
        System.out.println(occurrences);

        String[] words = str.split(" ");
        Map<String, Integer> frequency = new HashMap<>();
        for (String word : words) {
            Integer number = frequency.get(word);
            if (number == null) {
                frequency.put(word, 1);
            } else {
                frequency.put(word, number + 1);
            }
        }
        System.out.println(frequency);
    }
}
