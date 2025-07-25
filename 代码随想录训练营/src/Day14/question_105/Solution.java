package Day14.question_105;

public class Solution {
    /*
         preorder：前序遍历
         inorder：中序遍历
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0){
            return null;
        }
        return buildHelper(inorder, 0, inorder.length, preorder, 0, preorder.length);
    }

    private TreeNode buildHelper(int[] inorder, int inorderStart, int inorderEnd, int[] preorder, int preorderStart, int preorderEnd) {
        if (preorderStart == preorderEnd || inorderStart == inorderEnd) {
            return null;
        }

        // 前序遍历：根左右，第一个元素一定是根节点
        int rootVal = preorder[preorderStart];
        // 构造节点
        TreeNode root = new TreeNode(rootVal);

        // 在中序数组中找到根节点的位置，来划分左右子树
        int middleIndex = inorderStart;
        while (inorder[middleIndex] != rootVal) {
            middleIndex++;
        }

        // 中序数组中根节点的左子树索引范围
        int leftInorderStart = inorderStart;
        int leftInorderEnd = middleIndex;

        // 中序数组中根节点的右子树索引范围
        int rightInorderStart = middleIndex + 1;
        int rightInorderEnd = inorderEnd;

        // 前序数组中，根节点之后是左子树，左子树的节点数为 middleIndex - inorderStart
        int leftPreorderStart = preorderStart + 1;
        int leftPreorderEnd = leftPreorderStart + (middleIndex - inorderStart);

        // 右子树从左子树结束后的位置开始
        int rightPreorderStart = leftPreorderEnd;
        int rightPreorderEnd = preorderEnd;

        // 递归构建左右子树
        root.left = buildHelper(inorder, leftInorderStart, leftInorderEnd, preorder, leftPreorderStart, leftPreorderEnd);
        root.right = buildHelper(inorder, rightInorderStart, rightInorderEnd, preorder, rightPreorderStart, rightPreorderEnd);

        // 返回根节点
        return root;

    }
}
