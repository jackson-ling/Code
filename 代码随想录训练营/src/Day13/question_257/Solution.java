package Day13.question_257;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return null;
        }
        List<Integer> paths = new ArrayList<>();
        traversal(root, paths, res);
        return res;
    }

    public void traversal(TreeNode root, List<Integer> paths, List<String> res) {
        // 采用前序遍历

        // 根节点
        paths.add(root.val);

        // 处理叶子节点
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            // 最后一个节点不处理
            for (int i = 0; i < paths.size() - 1; i++) {
                // 拿到遍历结果后做字符串的拼接
                sb.append(paths.get(i)).append("->");
            }
            // 添加最后一个节点
            sb.append(paths.get(paths.size() - 1));
            // 转为字符串添加到结果集中
            res.add(sb.toString());
            return;
        }

        // 递归处理左子树
        if (root.left != null) {
            traversal(root.left, paths, res);
            // 回溯体现
            paths.remove(paths.size() - 1);
        }

        // 递归处理右子树
        if (root.right != null) {
            traversal(root.right, paths, res);
            // 回溯体现
            paths.remove(paths.size() - 1);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}