package Day24.question_122;

public class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            // 只收获正利润
            result += Math.max(prices[i] - prices[i - 1], 0);
        }
        return result;
    }
}
