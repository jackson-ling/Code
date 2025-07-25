package Day5.question1_242;

public class Solution {
    public boolean isAnagram(String s, String t) {
        // 为了遍历字符串的内容，先转为数组
        char[] s_ = s.toCharArray();
        char[] t_ = t.toCharArray();

        // 使用哈希表映射，通过映射关系计算频率
        int[] hash = new int[26];

        // 统计 s 字母的频率
        for (int i = 0; i < s_.length; i++) {
            hash[s_[i] - 'a']++;
        }

        // 遍历 t 串，如果由相同的字符组成，则 hash 值不会出现负数
        for (int i = 0; i < t_.length; i++) {
            hash[t_[i] - 'a']--;
        }

        // 遍历 hash 表，看是否存在负数
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
