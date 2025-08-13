package Day17.question_450;

public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        // 没有找到删除节点
        if (root == null) {
            return root;
        }
        // 找到了删除节点，分以下五种情况
        if (root.val == key) {
            // 叶子节点
            if (root.left == null && root.right == null) {
                return null;
            }
            // 左子树为空
            else if (root.left == null) {
                return root.right;
            }
            // 右子树为空
            else if (root.right == null) {
                return root.left;
            }
            // 左右子树不为空
            TreeNode cur = root.right; // 指向被删节点右子树的根节点
            while (cur.left != null) {
                cur = cur.left; // 找到被删节点右子树的根节点的左孩子
            }
            cur.left = root.left; // 重新链接被删节点的左子树
            root = root.right; // 改变指向，删除节点
            return root;
        }
        // 在递归中调用，实现删除的逻辑
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }

        return root;
    }
}
