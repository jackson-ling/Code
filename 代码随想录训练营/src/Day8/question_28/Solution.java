package Day8.question_28;

public class Solution {
    // KMP 算法，返回模式串在文本串中匹配的其实位置下标
    public int strStr(String haystack, String needle) {
        /*
            1. haystack：文本串，指针：i
            2. needle：模式串，指针：j // 表示的是已经匹配字符的个数
         */

        // 处理模式串长度为 0 的特殊情况
        if (needle.length() == 0) {
            return 0;
        }

        // 计算最长公共前后缀的对象应该是模式串，首先计算模式串的next数组
        int[] next = new int[needle.length()];
        getNext(next, needle);

        // 现在就可以根据next数组进行回退了。开始 KMP 算法的匹配
        /*
            KMP 算法中的 j 的含义
            1. 本质含义：表示的是已经匹配字符的个数
            2. 下标的角色：因为起始是 0，正好是下标的作用场景
         */
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            // 失配情况（因为是 j - 1，为了方式数组下标越界，需要用 j > 0 这个条件约束）
            while (j > 0 && needle.charAt(j) != haystack.charAt(i)) {
                j = next[j - 1];
            }
            // 匹配，j 指针和 i 指针同时后移，继续往后匹配
            if(needle.charAt(j) == haystack.charAt(i)){
                j++;
            }
            // 如果模式串指着 j 走到了末尾，说明匹配成功，返回匹配的起始位置下标索引
            /*
                needle.length() - 1：模式串的末尾元素的下标索引
                start_index = i - (needle.length() - 1)
                            = i - needle.length() + 1
             */
            if(j == needle.length()){
                return i - needle.length() + 1;
            }
        }

        // 模式串不是文本串的一部分
        return -1;
    }


    // next 数组
    public void getNext(int[] next, String s) {
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            // 失配，指针回溯
            while (j > 0 && s.charAt(j) != s.charAt(i)) {
                j = next[j - 1]; // 使用前缀表作为next数组，需要找前一位
            }
            // 匹配，更新最长公共前后缀的长度
            if (s.charAt(j) == s.charAt(i)) {
                /*
                    1. j 代表 i 之前（包括 i）的最长公共前后缀
                    2. 因为 j 是 next 数组指针，指向next数组下标对应的值就是最长公共前后缀长度
                 */
                j++;
            }
            // 更新 next 数组
            next[i] = j;
        }
    }
}
