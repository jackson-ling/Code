package Day2.开发商购买土地;

import java.util.Scanner;

public class 二维前缀和 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] s = new int[n + 1][m + 1]; // 前缀和数组

        int result = Integer.MAX_VALUE;

        // 通过二维前缀和的定义，构建前缀和
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int x = scanner.nextInt();
                s[i][j] = s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1] + x;
            }
        }

        // 行切割
        for (int i = 1; i < n; i++) {
            int ans = Math.abs((s[n][m] - s[i][m])- s[i][m]);
            result = Math.min(result,ans);
        }

        // 列切割
        for (int j = 1; j < m; j++) {
            int ans = Math.abs((s[n][m] - s[n][j]) - s[n][j]);
            result = Math.min(result,ans);
        }

        System.out.println(result);
        scanner.close();
    }
}
