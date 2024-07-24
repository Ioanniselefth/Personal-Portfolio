import java.util.Arrays;

public class AnagramChecker {
    public static boolean areAnagrams(String str1, String str2) {
        // Check if either string is null
        if (str1 == null || str2 == null) {
            return false;
        }

        // Convert both strings to lowercase
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        // Check if lengths are different
        if (str1.length() != str2.length()) {
            return false;
        }

        // Convert strings to character arrays
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();

        // Sort the character arrays
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        // Compare the sorted arrays
        return Arrays.equals(charArray1, charArray2);
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(areAnagrams("Listen", "Silent")); // true
        System.out.println(areAnagrams("hello", "olelh"));   // true
        System.out.println(areAnagrams("test", "tset"));     // true
        System.out.println(areAnagrams("test", "best"));     // false
        System.out.println(areAnagrams(null, "test"));       // false
        System.out.println(areAnagrams("test", null));       // false
        System.out.println(areAnagrams("test", "tests"));    // false
    }
}
