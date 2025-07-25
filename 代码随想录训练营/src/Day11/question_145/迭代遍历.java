package Day11.question_145;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 迭代遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left; // 处理左孩子
            } else {
                cur = stack.pop(); // 指针记录弹出的栈顶元素，用于取值
                result.add(cur.val); // 处理根节点
                cur = cur.right; // 处理右孩子
            }
        }
        return result;
    }
}
