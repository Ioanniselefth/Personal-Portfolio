public class MyChar {

    public static void main(String[] args) {
        System.out.println(isVowel('a')); // true
        System.out.println(isVowel('A')); // true
        System.out.println(isVowel('b')); // false
        System.out.println(isVowel('e')); // true
        System.out.println(isVowel('E')); // true
        System.out.println(isVowel('i')); // true
        System.out.println(isVowel('I')); // true
        System.out.println(isVowel('o')); // true
        System.out.println(isVowel('O')); // true
        System.out.println(isVowel('u')); // true
        System.out.println(isVowel('U')); // true
        System.out.println(isVowel('z')); // false
        System.out.println(isVowel('Z')); // false
        
    }
    
    // Method to determine if a character is a vowel
    public static boolean isVowel(char ch) {
    
        // Use a switch statement to check for each vowel, both lowercase and uppercase
        switch (ch) {
            case 'a', 'e', 'i', 'o', 'u','A', 'E', 'I', 'O', 'U' : return true;
        }

        return false;
    }
}