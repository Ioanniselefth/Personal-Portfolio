//121. Best Time to Buy and Sell Stock
class Solution {
    public int maxProfit(int[] prices) {
        int difference = 0;
        int current = 0;
        int min = prices[0];

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            current = prices[i] - min;
            if (difference < current) {
                difference = current;
            }
        }
        return difference;
    }
}
