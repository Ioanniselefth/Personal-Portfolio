//344. Reverse String

class Solution344 {
    public void reverseString(char[] s) {

        int j = 0;

        for (int i = s.length - 1; i >= s.length / 2; i--) {
            char ch = s[i]; // Here we have the inst 4
            char ch2 = s[j]; // Here we have the inst 0
            s[i] = ch2;
            s[j] = ch;
            j++;
        }
    }
}