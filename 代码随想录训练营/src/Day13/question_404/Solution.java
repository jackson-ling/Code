package Day13.question_404;


public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 计算左子树中的左孩子值（后序遍历：左）
        int leftValue = sumOfLeftLeaves(root.left);
        // 计算右子树中的左孩子值（后序遍历：右）
        int rightValue = sumOfLeftLeaves(root.right);

        int midValue = 0;
        // 处理做左叶子节点：（1）是左孩子（2）是叶子节点（后序遍历：根）
        if (root.left != null && root.left.left == null && root.left.right == null) {
            midValue = root.left.val;
        }
        // 计算和
        int sum = midValue + leftValue + rightValue;
        return sum;
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