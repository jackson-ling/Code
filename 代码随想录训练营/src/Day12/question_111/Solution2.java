package Day12.question_111;

import java.util.Deque;
import java.util.LinkedList;

public class Solution2 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        int depth = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            depth++;
            while(size-- > 0) {
                TreeNode poll = deque.poll();
                if (poll.left == null && poll.right == null) {
                    // 是叶子结点，直接返回depth，因为从上往下遍历，所以该值就是最小值
                    return depth;
                }
                if (poll.left != null) {
                    deque.offer(poll.left);
                }
                if (poll.right != null) {
                    deque.offer(poll.right);
                }
            }
        }
        return depth;
    }
}
