public class IsHexadecimal {
    public String str;

    public MyString(String str) {
        this.str = str;
    }

    public boolean isHexadecimalChar(char ch) {
        // Check if the character is a valid hexadecimal letter (A-F, a-f)
        return (ch >= 'A' && ch <= 'F') || (ch >= 'a' && ch <= 'f');
    }

    public boolean isHexadecimal() {
        // Check for null or empty string
        if (str == null || str.isEmpty()) {
            return false;
        }

        // Convert string to character array and check each character
        char[] characters = str.toCharArray();
        for (char ch : characters) {
            if (!isHexadecimalChar(ch) && !Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Test cases
        IsHexadecimal hex1 = new IsHexadecimal("123F");
        IsHexadecimal hex2 = new IsHexadecimal("A23g");
        IsHexadecimal hex3 = new IsHexadecimal("");
        IsHexadecimal hex4 = new IsHexadecimal(null);

        System.out.println(hex1.isHexadecimal()); // true
        System.out.println(hex2.isHexadecimal()); // false
        System.out.println(hex3.isHexadecimal()); // false
        System.out.println(hex4.isHexadecimal()); // false
    }
}
