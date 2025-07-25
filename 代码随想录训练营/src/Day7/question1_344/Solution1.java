package Day7.question1_344;

public class Solution1 {
    public void reverseString(char[] s) {
        int len = s.length / 2;
        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
}
