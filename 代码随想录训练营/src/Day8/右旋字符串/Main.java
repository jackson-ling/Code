package Day8.右旋字符串;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String str = scanner.nextLine();

        int len = str.length();  //获取字符串长度
        char[] s = str.toCharArray();

        // 翻转整个字符串
        reverseString(s,0,len -1);
        // 翻转前半部分
        reverseString(s,0,n - 1);
        // 翻转后半部分
        reverseString(s,n,len - 1);

        System.out.println(s);
    }

    public static void reverseString(char[] s, int left, int right) {
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
}
