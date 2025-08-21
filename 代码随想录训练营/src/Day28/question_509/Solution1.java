package Day28.question_509;

public class Solution1 {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        // 第 0 个斐波那契数
        dp[0] = 0;
        // 第 1 个斐波那契数
        dp[1] = 1;
        // 要求第 n 个斐波那契数，遍历到 n
        for (int index = 2; index <= n; index++) {
            dp[index] = dp[index - 1] + dp[index - 2];
        }
        return dp[n];
    }
}
