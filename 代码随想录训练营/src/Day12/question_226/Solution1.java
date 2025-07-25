package Day12.question_226;

public class Solution1 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }

        // 前序遍历
        swapChildren(root); // 根
        invertTree(root.left); // 左
        invertTree(root.right); // 右

        return root;
    }

    // 交换节点左右孩子
    public void swapChildren(TreeNode root){
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
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


