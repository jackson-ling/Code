package Day17.question_701;

public class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // 在叶子节点插入节点
        if (root == null) {
            TreeNode node = new TreeNode(val);
            return node; // 返回给父节点
        }

        // 利用二叉搜索树的特性
        if (root.val < val){
            root.right = insertIntoBST(root.right, val); // 递归创建右子树
        }else if (root.val > val){
            root.left = insertIntoBST(root.left, val); // 递归创建左子树
        }
        return root;
    }
}
