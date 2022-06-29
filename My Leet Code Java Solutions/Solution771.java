//771. Jewels and Stones
class Solution771 {
    public int numJewelsInStones(String jewels, String stones) {
        int num = 0;
        for (int i = 0; i < stones.length(); i++) {
            if (jewels.indexOf(stones.charAt(i)) != -1)
                num++;
        }
        return num;
    }
}
// Time Complexity = C1(n) = O(n)