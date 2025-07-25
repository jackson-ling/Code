package Day7.question1_344;

public class Solution2 {
    public void reverseString(char[] s) {
        String str = new String(s);
        StringBuffer stringBuffer = new StringBuffer(str);
        StringBuffer reverse = stringBuffer.reverse();
        String reverse_str = reverse.toString();
        // 将反转后的字符串再转成字符数组写回原数组
        for (int i = 0; i < s.length; i++) {
            s[i] = reverse_str.charAt(i);
        }
    }
}
