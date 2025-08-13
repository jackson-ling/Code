package Day20.question_39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates); // 从小到大排序，目的是为了剪枝
        backtracking(candidates,target,0,0);
        return res;
    }

    public void backtracking(int[] candidates, int target, int sum, int startindex) {
        if (sum > target){
            return;
        }
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startindex; i < candidates.length; i++) {
            // 剪枝，如果 sum + candidates[i] > target，就没有必要进行下一层递归，直接结束
            if (sum + candidates[i] > target) {
                break;
            }
            path.add(candidates[i]);
            sum += candidates[i];
            // 因为元素可以重复使用，所以传 i（下一层递归的起点）
            backtracking(candidates, target, sum , i);
            // 回溯
            sum -= candidates[i];
            path.removeLast();
        }
    }
}
