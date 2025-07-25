package Day12.question_104;

import java.util.Deque;
import java.util.LinkedList;

public class Solution2 {
    // 层序遍历
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        int depth = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            depth++; // 计算深度
            while(size-->0) {
                TreeNode node = deque.poll();
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
        }
        return depth;
    }
}
