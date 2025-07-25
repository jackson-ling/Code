package Day8.question_151;

public class Solution {
    /*
        1. 先去除多余的空格，保持每个单词之间有一个空格
        2. 翻转整个字符串
        3. 翻转每个单词
     */
    public String reverseWords(String s) {
        // 转成数组
        char[] chars = s.toCharArray();
        // 去除多余的空格
        chars = removeExtraSpaces(chars);
        // 翻转整个字符串
        reverse(chars,0, chars.length -1);
        // 翻转每个单词
        reverseEachWord(chars);
        // 返回字符串
        return new String(chars);
    }

    // 删除元素（空格），可以用双指针
    public char[] removeExtraSpaces(char[] s) {
        int slow = 0;
        for (int fast = 0; fast < s.length; fast++) {
            // fast 去除多余的空格
            if (s[fast] != ' ') {
                // 为每个单词之间添加一个空格（第一个单词不用）
                if (slow != 0) {
                    s[slow] = ' ';
                    slow++;
                }
                // 调整每个单词的位置，每个单词的末尾都会有一个空格
                while (fast < s.length && s[fast] != ' ') {
                    s[slow] = s[fast];
                    slow++;
                    fast++;
                }
            }
        }
        // 位置调整完成，但是多余的空格会占位置，返回一个新的字符串
        char[] newChars = new char[slow];
        System.arraycopy(s, 0, newChars, 0, slow);
        return newChars;
    }

    // 翻转字符串
    public void reverse(char[] s, int left, int right) {
        // 边界判断
        if (right >= s.length) {
            return;
        }
        // 相撞指针，开始移动并翻转元素
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    // 翻转单词
    public void reverseEachWord(char[] s) {
        int start = 0;
        // 让 end 始终指向单词的末尾，这样可以根据空格来判断是否遍历了一个单词
        for (int end = 0; end <= s.length; end++) {
            if (end == s.length || s[end] == ' ') {
                reverse(s, start, end - 1);
                start = end + 1; // end 指向的是空格，下一个位置就是新单词的首字母
            }
        }
    }
}
