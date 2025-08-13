package Day23.question_455;


import java.util.Arrays;

public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // 避免饼干浪费，大饼干先喂饱大胃口
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int start = s.length - 1;
        // 遍历胃口
        for (int index = g.length - 1; index >= 0; index--) {
            if(start >= 0 && g[index] <= s[start]) {
                start--;
                count++;
            }
        }
        return count;
    }
}
