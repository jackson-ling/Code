package Day8.question_459;

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        // 获取字符串的长度
        int n = s.length();

        // Step 1.构建 next 数组（直接使用前缀表）
        int[] next = new int[n]; // 前缀表的值表示以该位置结尾的字符串的最长相等前后缀的长度
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < n; i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) // 只要前缀后缀还不一致，就根据前缀表回退j直到起点为止
                j = next[j - 1];
            if (s.charAt(i) == s.charAt(j))
                j++;
            next[i] = j;
        }

        // Step 2.判断重复子字符串

        /* 判断条件
             1. 有公共前后缀
             2. 字符串s的长度可以被其最长相等前后缀不包含的子串的长度整除时
             3. next[n - 1] 就是最长公共前后缀
        */
        if (next[n - 1] > 0 && n % (n - next[n - 1]) == 0) {
            return true; // 不包含的子串就是s的最小重复子串
        } else {
            return false;
        }
    }
}