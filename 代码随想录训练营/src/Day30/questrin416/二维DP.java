package Day30.questrin416;

public class 二维DP {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 总和应该平均分
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        int[][] dp = new int[nums.length][target + 1];
        // 初始化左边列（创建数组时已经默认初始化为 0，这部分可以省略）
        // 初始化上边行
        for (int j = nums[0]; j <= target; j++) {
            dp[0][j] = nums[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                if (j < nums[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i]);
                }
            }
        }

        // for(int x : dp){
        //     System.out.print(x + ",");
        // }
        // System.out.print("    "+i+" row"+"\n");
        return dp[n - 1][target] == target;

        /*
            0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
            0, 1, 1, 1, 1, 5, 6, 6, 6, 6, 6, 6,
            0, 1, 1, 1, 1, 5, 6, 6, 6, 6, 6, 11,
            0, 1, 1, 1, 1, 5, 6, 6, 6, 6, 10, 11
        */
    }
}
