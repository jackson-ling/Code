package Day26.question_763;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> partitionLabels(String s) {
        LinkedList<Integer> list = new LinkedList<>();
        int[] hash = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            // 记录每个字母的最后出现位置
            hash[chars[i] - 'a'] = i;
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < chars.length; i++) {
            // 不断更新最远出现位置
            end = Math.max(end,hash[chars[i] - 'a']);
            // 找到了分割线
            if (i == end){
                // 记录区间长度
                list.add(i - start + 1);
                // 更新起点
                start = i + 1;
            }
        }
        return list;
    }
}
