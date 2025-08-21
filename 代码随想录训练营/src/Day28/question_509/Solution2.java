package Day28.question_509;

public class Solution2 {
    // 状态压缩
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[2];
        // 第 0 个斐波那契数
        dp[0] = 0;
        // 第 1 个斐波那契数
        dp[1] = 1;
        /*
            （1）要求第 n 个斐波那契数，遍历到 n
            （2）状态压缩，只需要维护三个变量（i - 2、i - 1、i）
         */
        for (int index = 2; index <= n; index++) {
            // dp[i]，第 i 个斐波那契数的值
            int sum = dp[0] + dp[1];
            // 下一轮循环，不断更新
            dp[0] = dp[1];
            dp[1] = sum;
        }
        // 经过不断更新，最终 sum 的值保存在了 dp[1] 中
        return dp[1];
    }
}
