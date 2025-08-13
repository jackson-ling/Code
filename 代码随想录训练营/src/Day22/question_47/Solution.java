package Day22.question_47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    //存放结果
    List<List<Integer>> result = new ArrayList<>();
    //暂存结果
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        // 初始化 used[] 数组
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);
        // 预先对数组排序，方便通过相邻的节点来判断是否重复使用了
        Arrays.sort(nums);

        backtracking(nums,used);
        return result;
    }

    public void backtracking(int[] nums, boolean[] used) {
        // 递归终止条件
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 采用 used[] 数组进行树层去重，这里的 false 是上一层递归回溯的结果
            if (i > 0 && nums[i - 1] == nums[i] && used[i - 1] == false) {
                continue;
            }

            // 排列问题中元素可以重复选取，选取了就不再选择
            if (used[i]){
                continue;
            }

            used[i] = true;
            path.add(nums[i]);
            // 递归
            backtracking(nums,used);
            // 回溯
            path.remove(path.size() - 1);
            used[i] = false;

        }
    }
}
