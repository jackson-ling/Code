package Day30.questrin416;

public class 一维DP {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 总和应该平均分
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        int[] dp = new int[target + 1];
        // 先遍历物品（此题场景中，物品就是数字）
        for (int i = 0; i < nums.length; i++) {
            // 后遍历背包（必须倒叙遍历），此题场景中，总和就是背包
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        // 剪枝优化
        if (dp[target] == target) {
            return true;
        }
        return dp[target] == target;
    }
}
