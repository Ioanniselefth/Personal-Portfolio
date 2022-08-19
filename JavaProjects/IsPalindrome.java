public class IsPalindrome {

    public static Boolean isPalindrome(String temp) {
        String reversed = "";
        for (int i = temp.length() - 1; i >= 0; i--) {
            reversed += temp.charAt(i);
            System.out.println(i);
        }
        if (reversed.equals(temp)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("abcd"));
        System.out.println(isPalindrome("level"));
    }

}
