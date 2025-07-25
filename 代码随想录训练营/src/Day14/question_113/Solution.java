package Day14.question_113;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res; // 非空判断

        List<Integer> path = new LinkedList<>();
        preOrderDfs(root, targetSum, res, path);
        return res;
    }

    public void preOrderDfs(TreeNode root, int targetSum, List<List<Integer>> res, List<Integer> path) {
        path.add(root.val);
        // 遇到了叶子节点
        if (root.left == null && root.right == null) {
            // 找到了和为 targetsum 的路径
            if (targetSum - root.val == 0) {
                res.add(new ArrayList<>(path));
            }
            return; // 如果和不为 targetsum，返回
        }

        if (root.left != null) {
            preOrderDfs(root.left, targetSum - root.val, res, path);
            path.remove(path.size() - 1); // 回溯
        }
        if (root.right != null) {
            preOrderDfs(root.right, targetSum - root.val, res, path);
            path.remove(path.size() - 1); // 回溯
        }
    }

}
