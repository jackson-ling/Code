package Day22.question_46;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        permuteHelper(nums);
        return result;
    }

    public void permuteHelper(int[] nums) {
        // 结束条件，结果集元素个数和数组元素个数相同
        if (path.size() == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 选过了就不再选了
            if (used[i]){
                continue;
            }

            used[i] = true;
            path.add(nums[i]);
            // 递归
            permuteHelper(nums);
            // 回溯
            path.removeLast();
            used[i] =false;
        }
    }
}
