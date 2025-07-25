package Day11.question_144;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 迭代遍历 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root); // 根节点入栈
        while (!stack.isEmpty()) {
            // 处理根节点，同时把遍历顺序记录在数组中
            TreeNode node = stack.pop();
            result.add(node.val);
            // 先处理右孩子
            if (node.right != null) {
                stack.push(node.right);
            }
            // 后处理左孩子
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }
}
