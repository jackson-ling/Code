package Day13.question_222;

public class Solution1 {
    // 当作普通二叉树，采用后序遍历，下面简化了代码
    public int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
