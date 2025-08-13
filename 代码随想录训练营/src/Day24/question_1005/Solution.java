package Day24.question_1005;

import java.util.stream.IntStream;

public class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        // 数组按照绝对值从大到小排序
        nums = IntStream.of(nums)
                .boxed()
                .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
                .mapToInt(Integer::intValue).toArray();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 && k > 0){
                nums[i] = -nums[i];
                k--;
            }
        }
        // 一轮遍历之后，如果 K 还有剩余，且为奇数，对最小的数取反
        if (k % 2 == 1){
            nums[nums.length - 1] = - nums[nums.length - 1];
        }
        // 统计总和
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }
}
