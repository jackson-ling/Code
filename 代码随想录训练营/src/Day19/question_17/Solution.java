package Day19.question_17;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // 存放结果
    List<String> list = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return list;
        }

        // 映射字符串数组，为了对应 2 - 9，增添两个无用的空串
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtracking(digits, numString, 0);
        return list;
    }

    // 涉及大量字符串拼接，采用效率更高的 StringBuider
    StringBuilder temp = new StringBuilder();
    // 回溯逻辑（num：记录遍历到第几个字符）
    public void backtracking(String digits,String[] numString,int num){
        // 结束条件
        if (num == digits.length()){
            list.add(temp.toString());
            return;
        }

        // 数字映射字符串
        /*
            （1）字符串映射
            （2）- '0' 转为整数（利用unicode码的差值）
         */
        String str = numString[digits.charAt(num) - '0'];

        // 遍历映射字符串的每一个字母，和下一个数字映射字符串中的字母进行组合
        for (int i = 0; i < str.length(); i++) {
            temp.append(str.charAt(i));
            // 递归：此时指向下一个数组，和其映射的字符串中的每个字符进行组合
            backtracking(digits,numString,num + 1);
            // 回溯（删除最后一个元素，模拟 pop 操作）
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
