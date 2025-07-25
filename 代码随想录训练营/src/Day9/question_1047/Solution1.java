package Day9.question_1047;

import java.util.Deque;
import java.util.LinkedList;

public class Solution1 {
    public String removeDuplicates(String s) {
        // 利用栈的特点
        Deque<Character> deque = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            // 第一次遍历该元素，入栈，表示记录已经遍历过该元素
            if(deque.isEmpty() || chars[i] != deque.peek()){
                deque.push(chars[i]);
            }else{
                deque.pop(); // 匹配到相邻重复项，出栈
            }
        }
        String str = "";
        while (!deque.isEmpty()){
            str = deque.pop() + str; // 在字符串的前面拼接
        }
        return str;
    }
}
