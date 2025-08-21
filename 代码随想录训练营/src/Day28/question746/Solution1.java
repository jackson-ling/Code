package Day28.question746;

public class Solution1 {
    public int minCostClimbingStairs(int[] cost) {
        /*
            （1）dp[i] 表示到达第 i 个台阶的最小花费
            （2）cost[cost.length - 1] 表示跳到顶楼的花费，
                 还要再朓一步才到达顶楼的位置，
            （3）根据 dp[] 数组的含义，返回的应该是到达顶楼的最小花费，
                 即初始化时数组的长度要加一，加一到达的位置就是顶楼的位置
         */
        int[] dp = new int[cost.length + 1];
        // 从下标为 0 或者 下标为 1 的地方开始朓，跳了才有花费
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= cost.length; i++) {
            // 取最小花费
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        // 返回达到顶楼的最小花费
        return dp[cost.length];
    }
}
