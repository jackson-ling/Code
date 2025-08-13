package Day19.question_216;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ClassName: Solution
 * Package: Day19.question_216
 * Description:
 *
 * @author jacksonling
 * @version 1.0
 * @Create 2025-07-29 22:02
 */

// 剪枝
public class Solution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(n, k, 1, 0);
        return result;
    }

    // 回溯逻辑
    public void backtracking(int targetSum, int k, int startIndex, int sum) {
        // 剪枝
        if (sum > targetSum) {
            return;
        }
        // 递归终止条件（满足了要求的元素个数、和也是符合要求的）
        if (path.size() == k) {
            if (sum == targetSum) {
                result.add(new ArrayList<>(path));
            }
            return;
        }
        // 剪枝 + 递归搜索（需要取等，startIndex 从 1 开始）
        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            path.add(i);
            sum += i;
            // 递归
            backtracking(targetSum, k, i + 1, sum);
            // 回溯
            sum -= i;
            path.removeLast();
        }
    }
}
