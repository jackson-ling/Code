package Day24.question_55;

public class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int cover = 0;
        for (int i = 0; i <= cover; i++) {
            // 不断更新，取最大的覆盖范围
            cover = Math.max(cover, i + nums[i]);
            if (cover >= nums.length - 1){
                return true;
            }
        }
        return false;
    }
}
