package Day7.替换数字;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int len = s.length();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                len += 5;
            }
        }

        char[] ret = new char[len];
        for (int i = 0; i < s.length(); i++) {
            ret[i] = s.charAt(i);
        }
        for (int i = s.length() - 1, j = len - 1; i >= 0; i--) {
            if ('0' <= ret[i] && ret[i] <= '9') {
                ret[j--] = 'r';
                ret[j--] = 'e';
                ret[j--] = 'b';
                ret[j--] = 'm';
                ret[j--] = 'u';
                ret[j--] = 'n';
            } else {
                ret[j--] = ret[i];
            }
        }
        System.out.println(ret);
    }

}
