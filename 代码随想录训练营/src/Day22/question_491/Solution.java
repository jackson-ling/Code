package Day22.question_491;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums, 0);
        return result;
    }

    public void backtracking(int[] nums, int startIndex) {
        // 本题还是子集问题，不需要剪枝

        /// 题目要求结果集至少两个元素
        if (path.size() >= 2) {
            result.add(new ArrayList<>(path));
        }

        // 由于本题不能对数组排序，去重方式变化，采用 hashset 来记录是否重复
        HashSet<Integer> hashSet = new HashSet<>();

        for (int i = startIndex; i < nums.length; i++) {
            /*
                去重逻辑
                （1）树层上不能重复取元素
                （2）树枝上取的元素要比最后一个元素大（因为要求的是递增子序列）
                （3）比较时需要取数，为了防止异常需要判断是否为空
             */
            if (!path.isEmpty() && nums[i] < path.get(path.size() - 1) || hashSet.contains(nums[i])) {
                continue;
            }
            // 把遍历的树层元素添加到 hashset 中
            hashSet.add(nums[i]);
            path.add(nums[i]);
            // 递归
            backtracking(nums, i + 1);
            // 回溯
            path.remove(path.size() - 1);
            /*
                每一层递归创建新的 hashset，记录本层递归使用过的元素
                不需要进行回溯操作
             */
        }
    }
}
