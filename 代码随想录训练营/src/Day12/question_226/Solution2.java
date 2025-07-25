package Day12.question_226;


import java.util.ArrayDeque;

public class Solution2 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 层序遍历
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            // 记录当前层的节点个数，明确出队元素
            int size = deque.size();
            // 出队
            while (size-- > 0) {
                TreeNode node = deque.poll();
                swapChildren(node);
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
        }
        return root;
    }

    // 交换节点左右孩子
    public void swapChildren(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
