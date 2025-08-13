package Day24.question_45;

public class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }
        // 记录跳跃次数
        int count = 0;
        // 记录当前最大覆盖范围
        int curDistance = 0;
        // 记录最大覆盖区域
        int maxDistance = 0;
        for (int i = 0; i < nums.length; i++) {
            maxDistance = Math.max(maxDistance, i + nums[i]);
            // 覆盖范围覆盖了终点，即再跳一步就到达了终点
            if (maxDistance >= nums.length - 1) {
                count++;
                break;
            }
            // 遍历到当前最大范围末尾，但是没有到达终点，更新下一步可到达的最大区域
            if (i == curDistance && curDistance < nums.length - 1) {
                curDistance = maxDistance;
                count++;
            }
        }
        return count;
    }
}
