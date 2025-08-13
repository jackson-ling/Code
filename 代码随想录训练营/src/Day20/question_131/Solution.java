package Day20.question_131;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<String>> res = new ArrayList<>();
    List<String> cur = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtracking(s, 0);
        return res;
    }

    public void backtracking(String s, int startIndex) {
        // startIndex 就是分割线，当切割到末尾就结束了
        if (startIndex == s.length()) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            /*
                1. startIndex是切割线，截取字串，判断是否是回文串
                2. substring（）方法左闭右开，注意 + 1
            */
            String str = s.substring(startIndex, i + 1);
            if (isPalindrome(str)) {
                cur.add(str);
                // 注意切割过的位置，不能重复切割，所以，backtracking(s, i + 1); 传入下一层的起始位置为i + 1
                backtracking(s, i + 1);
                cur.remove(cur.size() - 1); // 回溯
            }
        }
    }

    // 判断是否是回文串
    public boolean isPalindrome(String sb) {
        for (int i = 0, j = sb.length() - 1; i < sb.length(); i++, j--) {
            if (sb.charAt(i) != sb.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
