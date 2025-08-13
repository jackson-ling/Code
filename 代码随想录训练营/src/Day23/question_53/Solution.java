package Day23.question_53;


public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        // 存放结果，初始化为最小，在遍历过程中不断更新
        int sum = Integer.MIN_VALUE;
        // 用于计算每一次累加的和
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            // 找到了更大的子序列和
            if (count > sum){
                sum = count;  // 取区间累计的最大值（相当于不断确定最大子序终止位置）
            }
            // 如果发现和更小了，就更新贪心的起点(跳过当前遍历的数)
            if (count < 0){
                count = 0;  // 相当于重置最大子序起始位置，因为遇到负数一定是拉低总和
            }
        }
        return sum;
    }
}
