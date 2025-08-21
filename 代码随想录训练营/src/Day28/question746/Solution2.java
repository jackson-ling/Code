package Day28.question746;

public class Solution2 {
    public int minCostClimbingStairs(int[] cost) {
        // 状态压缩，dp[i]就是由前两位推出来的
        int dp0 = 0;
        int dp1 = 0;
        for (int i = 2; i <= cost.length; i++) {
            int dpi = Math.min(dp1 + cost[i - 1], dp0 + cost[i - 2]);
            // 下一轮循环，更新
            dp0 = dp1;
            dp1 = dpi;
        }
        return dp1;
    }
}
