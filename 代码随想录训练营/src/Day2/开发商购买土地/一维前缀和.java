package Day2.开发商购买土地;

import java.util.Scanner;

public class 一维前缀和 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int sum = 0; // 统计总和
        int[][] vec = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                vec[i][j] = scanner.nextInt();
                sum += vec[i][j];
            }
        }

        // 统计横向和
        int[] horizontal = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                horizontal[i] += vec[i][j];
            }
        }

        // 统计纵向和
        int[] vertical = new int[m];
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                vertical[j] += vec[i][j];
            }
        }

        int result = Integer.MAX_VALUE;

        // 横向切割，找出最小的总和差值
        int horizontalCut = 0;
        for (int i = 0; i < n; i++) {
            horizontalCut += horizontal[i]; // 取前缀和
            // 利用总和求另一部分的和
            result = Math.min(result,Math.abs((sum - horizontalCut) - horizontalCut));
        }

        // 纵向切割，找出最小的总和差值
        int verticalCut = 0;
        for (int j = 0; j < m; j++) {
            verticalCut += vertical[j];
            // 利用总和求另一部分的和
            result = Math.min(result,Math.abs((sum - verticalCut) - verticalCut));
        }

        System.out.println(result);
        scanner.close();
    }
}
