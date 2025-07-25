package Day10.question_150;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int evalRPN(String[] tokens) {
        // 模拟栈结构
        Deque<Integer> stack = new LinkedList();
        for (String s : tokens) {
            // 注意 - 和 / 需要特殊处理，因为不符合交换律并且要求保持顺序
            if ("+".equals(s)) {
                stack.push(stack.pop() + stack.pop());
            } else if ("-".equals(s)) {
                stack.push(-stack.pop() + stack.pop());
            } else if ("*".equals(s)) {
                stack.push(stack.pop() * stack.pop());
            } else if ("/".equals(s)) {
                int temp1 = stack.pop();
                int temp2 = stack.pop();
                stack.push(temp2 / temp1);
            } else {
                stack.push(Integer.valueOf(s)); // 字符串转 Integer
            }
        }
        return stack.pop();
    }
}
