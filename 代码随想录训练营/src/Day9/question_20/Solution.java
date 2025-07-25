package Day9.question_20;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public boolean isValid(String s) {
        Deque<Character> deque = new LinkedList<>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            //碰到左括号，就把相应的右括号入栈
            if (ch == '(') {
                deque.push(')');
            }else if (ch == '{') {
                deque.push('}');
            }else if (ch == '[') {
                deque.push(']');
            } else if (deque.isEmpty() || deque.peek() != ch) {
                /*
                    deque.peek() != ch 对应第二种情况：中间的括号不匹配
                    deque.isEmpty() 对应第三种情况：右括号多了
                    （因为先有左括号才会把右括号入栈，如果栈空了，说明前面的括号全部匹配，这部分括号就是多的）
                 */
                return false;
            }else {
                deque.pop();// 此时遍历的元素就是遍历到左括号时对应的右括号元素，括号匹配，出栈
            }
        }
        /*
            1. 遍历结束，如果栈为空，则括号全部匹配
            2. 栈不为空，对应第一种情况：左括号多了没有匹配，还遗留在栈中
         */
        return deque.isEmpty();
    }
}
