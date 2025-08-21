package Day28.question_70;

public class Solution2 {
    public int climbStairs(int n) {
        // 处理特殊情况
        if (n <= 1) {
            return n;
        }
        // dp[0] 没有意义，从dp[1]开始，正好对应第 i 个台阶
        int[] dp = new int[3];
        dp[1] = 1;
        dp[2] = 2;
        // 从 3 开始递推
        for (int i = 3; i <= n; i++) {
            int sum = dp[1] + dp[2];
            dp[1] = dp[2];
            dp[2] = sum;
        }
        return dp[2];
    }
}
