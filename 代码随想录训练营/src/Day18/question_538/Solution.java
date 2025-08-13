package Day18.question_538;

public class Solution {
    int pre;  // 定义前驱指针记录节点的数值

    public TreeNode convertBST(TreeNode root) {
        convertBST1(root);
        return root;
    }

    // 按右中左顺序遍历，累加即可
    public void convertBST1(TreeNode root) {
        if (root == null) {
            return;
        }
        convertBST1(root.right);
        root.val += pre;
        pre = root.val;
        convertBST1(root.left);
    }
}