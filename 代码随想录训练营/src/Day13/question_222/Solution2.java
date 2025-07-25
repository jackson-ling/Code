package Day13.question_222;

public class Solution2 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 这里初始为0是有目的的，为了下面求指数方便
        int leftDepth = 0;
        int rightDepth = 0;

        // 初始化两个指针，用于计算深度
        TreeNode left = root.left;
        TreeNode right = root.right;

        // 计算左子树深度
        while (left != null) {
            left = left.left;
            leftDepth++;
        }

        // 计算右子树深度
        while (right != null) {
            right = right.right;
            rightDepth++;
        }

        // 左右深度相同，说明是满二叉树，利用公式计算节点数
        if (leftDepth == rightDepth) {
            // 注意(2<<1) 相当于2^2，所以leftDepth初始为0
            return (2 << leftDepth) - 1;
        }

        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
