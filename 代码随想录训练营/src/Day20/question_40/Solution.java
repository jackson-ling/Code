package Day20.question_40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: Solution
 * Package: Day20.question_40
 * Description:
 *
 * @author jacksonling
 * @version 1.0
 * @Date 2025-07-31 9:40
 */
public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); // 排序的目的是去重 + 剪枝
        backtracking(candidates,target,0,0);
        return res;
    }

    public void backtracking(int[] candidates, int target, int sum, int startIndex) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            // 剪枝
            if (sum + candidates[i] > target) {
                break;
            }
            // 树层去重
            if (i > startIndex && candidates[i - 1] == candidates[i]) {
                continue;
            }
            path.add(candidates[i]);
            sum += candidates[i];
            // 递归
            backtracking(candidates,target,sum,i + 1); // 每个数字在每个组合中只能使用一次
            // 回溯
            path.removeLast();
            sum -= candidates[i];
        }
    }
}
