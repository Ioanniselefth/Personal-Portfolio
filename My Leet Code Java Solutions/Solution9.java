class Solution9 {
    public boolean isPalindrome(int x) {
        String temp = Integer.toString(x);
        int[] front = new int[temp.length()];
        int[] back = new int[temp.length()];

        for (int i = 0; i < temp.length(); i++) {
            front[i] = temp.charAt(i);
            back[i] = temp.charAt(i);
        }

        int j = temp.length() - 1;

        for (int i = 0; i < j + 1; i++) {
            if (front[i] != back[j]) {
                return false;
            }
            j--;
        }

        return true;
    }
}
// 9. Palindrome Number
// Time Complexity = C1(n) + C2(n) = (C1+C2....)(n) = O(n)
/*
 * class Solution {
    public boolean isPalindrome(int x) {
        String str = Integer.toString(x);
        int j = str.length()-1; 
        for(int i = 0; i<str.length()/2; i++){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
            j -= 1;
        }
        return true;
    }
}
 */