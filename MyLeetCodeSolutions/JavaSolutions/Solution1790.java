//1790. Check if One String Swap Can Make Strings Equal
public class Solution1790 {
    public boolean areAlmostEqual(String s1, String s2) {
        char tempArray[] = s1.toCharArray();
        char tempArray2[] = s2.toCharArray();
        int counter = 0;
        if (s1.length() > 2) {
            for (int i = 0; i < s1.length(); i++) {
                if (tempArray[i] != tempArray2[i])
                    counter++;
            }
        }
        if (s1 == s2 && s1.length() == 2)
            return true;
        else if (s1 != s2 && s1.length() == 2)
            return false;
        if (counter > 2)
            return false;
        return true;
    }
}
