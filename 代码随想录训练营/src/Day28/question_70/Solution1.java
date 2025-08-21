package Day28.question_70;

public class Solution1 {
    public int climbStairs(int n) {
        // 防止下标索引越界，同时处理特殊情况
        if (n <= 1) {
            return n;
        }
        // dp[0] 没有意义，从dp[1]开始，正好对应第 i 个台阶
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        // 从 3 开始递推
        for (int i = 3; i <= n; i++) {
            // dp[i - 1]：走一步
            // dp[i - 2]：走两步
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
