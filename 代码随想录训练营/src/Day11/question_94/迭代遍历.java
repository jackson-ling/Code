package Day11.question_94;

import java.util.ArrayList;
import java.util.Collections;
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
            // 先处理左孩子
            if (node.left != null) {
                stack.push(node.left);
            }
            // 后处理右孩子
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        // 翻转数组
        Collections.reverse(result);
        return result;
    }
}
