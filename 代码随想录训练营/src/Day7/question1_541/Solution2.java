package Day7.question1_541;

public class Solution2 {
    public String reverseStr(String s, int k) {
        int n = s.length();
        char[] ans = s.toCharArray();
        for (int i = 0; i < n; i += 2 * k){
            int start = i;
            /*
                1. 剩余的不够 k 个，i + k - 1 会越界，取字符串长度
                2. 剩余的够 k 个，此时字符串长度更长，取 i + k - 1
             */
            int end = Math.min(n - 1, i + k - 1);
            while (start < end){
                char temp = ans[start];
                ans[start] = ans[end];
                ans[end] = temp;
                start++;
                end--;
            }
        }
        return new String(ans);
    }
}
