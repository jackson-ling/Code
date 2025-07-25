package Day6.question2_383;

public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // 定义一个映射数组
        int[] res = new int[26];

        // 转成字符串数组
        char[] ransomNotes = ransomNote.toCharArray();
        char[] magazines = magazine.toCharArray();

        // 遍历
        for (char i : magazines) {
            res[i - 'a']++;
        }

        for (char i : ransomNotes) {
            res[i - 'a']--;
        }

        // 查找
        for (int i : res) {
            if (i < 0) {
                return false;
            }
        }
        return true;
    }
}
