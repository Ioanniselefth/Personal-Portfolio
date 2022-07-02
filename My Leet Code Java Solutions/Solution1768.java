//1768. Merge Strings Alternately

class Solution1768 {
    public String mergeAlternately(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        char[] str = new char[length1+length2];
        int counter = 0;
        int counter2 = 0;
        int count =0;
        while(counter<length1 || counter2<length2){
            if(counter<length1){
                str[count] = word1.charAt(counter);
                count++;
                counter++;
            }
            if(counter2<length2){
                str[count] = word2.charAt(counter2);
                count++;
                counter2++;
            }
        }
        return new String(str);
    }
}