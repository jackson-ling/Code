package Day15.question_98;

public class Solution {
    // 用 max 指针来记录前驱节点
    TreeNode max;

    public boolean isValidBST(TreeNode root) {
        // 终止条件
        if (root == null) {
            return true;
        }
        // 左
        boolean left = isValidBST(root.left);

        // 根
        if (max != null && root.val <= max.val) {
            return false;
        }

        // 移动前驱指针
        max = root;

        // 右
        boolean right = isValidBST(root.right);

        // 左右子树都是二叉搜索树
        return left && right;
    }
}
