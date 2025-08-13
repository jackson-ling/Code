package Day18.question_669;

public class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        // 根据二叉搜索树的特性，如果比最小值还小，应当返回比root.val大一点的值，即返回右子树
        if (root.val < low) {
            TreeNode right = trimBST(root.right, low, high);
            return right;
        }
        // 根据二叉搜索树的特性，如果比最大值还大，应当返回比root.val小一点的值，即返回左子树
        if (root.val > high) {
            TreeNode left = trimBST(root.left, low, high);
            return left;
        }
        // root在[low,high]范围内
        root.left = trimBST(root.left, low, high); // 递归修剪左子树
        root.right = trimBST(root.right, low, high); // 递归修剪右子树
        return root;
    }
}
