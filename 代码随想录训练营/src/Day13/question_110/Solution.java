package Day13.question_110;


public class Solution {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    public int getHeight(TreeNode root){
        if (root == null){
            return 0;
        }
        // 计算左子树高度
        int leftHeight = getHeight(root.left);
        if(leftHeight == -1){
            return -1;
        }
        // 计算右子树高度
        int rightHeight = getHeight(root.right);
        if (rightHeight == -1){
            return -1;
        }
        // 计算高度差
        if (Math.abs(leftHeight - rightHeight) > 1){
            return -1;
        }else{
            return Math.max(leftHeight,rightHeight) + 1;
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
