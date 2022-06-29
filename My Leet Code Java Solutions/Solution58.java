//58. Length of Last Word
//Time Complexity = O(n)
class Solution58 {
    public int lengthOfLastWord(String s) {
        int counter =0;
        String[] array = s.split(" ");
        for(int i=array.length-1; i<array.length; i++){
            counter = array[i].length();
        }
        return counter;
    }
}