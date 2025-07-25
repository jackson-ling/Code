package Day2.question1_209;

public class Solution {
    // 滑动窗口（双指针）
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int sum = 0;
        int min_length = Integer.MAX_VALUE;
        for (int j = 0; j < nums.length; j++) {
            // 计算和
            sum += nums[j];
            // 在滑动过程中持续判断
            while (sum >= target) {
                min_length = Math.min(min_length, j - i + 1); // 取最小长度
                sum -= nums[i]; // 头指针前移一位，区间和需要减去头指针指向的值
                i++;
            }
        }
        return min_length == Integer.MAX_VALUE ? 0 : min_length;
    }
}
