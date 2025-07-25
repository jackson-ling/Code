package Day14.question_513;

public class Solution1 {
    private int Deep = -1;
    private int value = 0;

    public int findBottomLeftValue(TreeNode root) {
        value = root.val;
        findLeftValue(root, 0);
        return value;
    }

    private void findLeftValue(TreeNode root, int deep) {
        if (root == null) {
            return;
        }
        // 判断叶子节点
        if (root.left == null && root.right == null) {
            if (deep > Deep) {
                value = root.val;
                Deep = deep;
            }
        }
        // 递归遍历左子树
        if (root.left != null) {
            deep++;
            findLeftValue(root.left, deep);
            deep--; // 体现回溯的过程
        }
        // 递归遍历右子树
        if (root.right != null) {
            deep++;
            findLeftValue(root.right, deep);
            deep--; // 体现回溯的过程
        }
    }
}
