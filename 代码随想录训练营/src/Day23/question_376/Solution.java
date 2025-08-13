package Day23.question_376;

public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        // 当前元素后面的那个坡度
        int curDiff = 0;
        // 当前元素前面的那个坡度
        int preDiff = 0;
        // 平坡情况时，默认最右端有一个峰值（坡度）
        int count = 1;
        // 最右端已经记录了一个摆动（平坡情况），遍历到倒数第二个元素
        for (int i = 0; i < nums.length - 1; i++) {
            // 计算当前差值
            curDiff = nums[i + 1] - nums[i];
            // 一正一负才能算摆动（下坡上坡 || 上坡下坡）
            if ((preDiff <= 0 && curDiff > 0) || (preDiff >= 0 && curDiff < 0)) {
                count++;
                // 只有当坡度变化时，才更新 preDiff，避免错误记录平坡的情况
                preDiff = curDiff;
            }
        }
        return count;
    }
}
