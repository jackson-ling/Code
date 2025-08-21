package Day27.question_738;

public class Solution {
    public int monotoneIncreasingDigits(int n) {
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();
        // 初始为如下值，如果本身符合条件，则不会进入两个 for 循环
        int start = s.length();
        // 从后往前遍历，防止越界，不取 0
        for (int i = s.length() - 1; i > 0; i--) {
            // 前面的比后面大
            if (chars[i - 1] > chars[i]) {
                chars[i - 1]--;
                start = i;
            }
        }
        for (int i = start; i < s.length(); i++) {
            chars[i] = '9';
        }
        return Integer.parseInt(String.valueOf(chars));
    }
}
