package Day21.question_93;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // 结果集
    List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        // 根据 ip 的特点，最多也就是12位，这里可以做剪枝
        if (s.length() > 12) {
            return result; // 算是剪枝了
        }
        backtracking(s,0,0);
        return result;
    }

    public void backtracking(String s, int startIndex, int pointNum) {
        // 结束条件
        if (pointNum == 3) {
            // 此时分割完成，需要判断最后一个字串是否合法
            if (isValid(s, startIndex, s.length() - 1)) {
                result.add(s);
            }
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (isValid(s, startIndex, i)) {
                // 字串合法，插入 " . "，subString()方法：左闭右开
                s = s.substring(0, i + 1) + "." + s.substring(i + 1, s.length());
                pointNum++;
                // 易错：由于插入了一个 " . "，所以下一次递归的起始位置需要多加一
                backtracking(s, i + 2, pointNum);
                // 回溯
                pointNum--;
                s = s.substring(0, i + 1) + s.substring(i + 2, s.length());
            } else {
                break;
            }
        }
    }

    // 判断是否合法
    public boolean isValid(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        // 非零开头（并且该字符不是最后一个数字）
        if (s.charAt(start) == '0' && start != end) {
            return false;
        }
        // 遍历，数值小于255
        int num = 0;
        for (int i = start; i <= end; i++) {
            // 判断非法字符
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                return false;
            }
            // charAt 方法是逐个字符取的，使用如下式子转为整数
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) {
                return false;
            }
        }
        return true;
    }
}
