package Day14.question_106;

public class Solution {
    /*
         postorder：后序遍历
         inorder：中序遍历
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0 || inorder.length == 0)
            return null;
        return buildHelper(inorder, 0, inorder.length, postorder, 0, postorder.length);

    }

    private TreeNode buildHelper(int[] inorder, int inorderStart, int inorderEnd, int[] postorder, int postorderStart, int postorderEnd) {
        if (postorderStart == postorderEnd)
            return null;
        // 后序遍历：左右根，最后一定是根节点
        int rootVal = postorder[postorderEnd - 1];
        // 构造节点
        TreeNode root = new TreeNode(rootVal);
        // 后序数组中找到了根节点，在中序数组中找到根节点的位置，进行切割
        int middleIndex;
        for (middleIndex = inorderStart; middleIndex < inorderEnd; middleIndex++) {
            if (inorder[middleIndex] == rootVal)
                break;
        }

        // 中序数组中根节点的左子树索引范围
        int leftInorderStart = inorderStart;
        int leftInorderEnd = middleIndex;

        // 中序数组中根节点的右子树索引范围
        int rightInorderStart = middleIndex + 1;
        int rightInorderEnd = inorderEnd;

        // 依据后序数组中根节点在中序数组中分割出左右子树

        // 在后序数组中分割出左子树
        /*
            后序遍历顺序：左右根
            后序数组的左子树
                起始位置：后序数组的起始位置
                终止位置：根据中序数组中根节点的位置来计算左子树的的节点个数，得到终止位置的索引
         */
        int leftPostorderStart = postorderStart;
        int leftPostorderEnd = postorderStart + (middleIndex - inorderStart);

        // 在后序数组中分割出右子树
        /*
            后序数组中计算出左子树的基础上，除了最后一个位置是根节点，剩余部分就是右子树的索引部分
         */
        int rightPostorderStart = leftPostorderEnd;
        int rightPostorderEnd = postorderEnd - 1;

        // 递归创建左右子树
        root.left = buildHelper(inorder, leftInorderStart, leftInorderEnd, postorder, leftPostorderStart, leftPostorderEnd);
        root.right = buildHelper(inorder, rightInorderStart, rightInorderEnd, postorder, rightPostorderStart, rightPostorderEnd);

        // 返回根节点
        return root;
    }

}
