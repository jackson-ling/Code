package Day30._01背包二维DP;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 材料的种类
        int n = scanner.nextInt();
        // 背包的空间
        int bageweight = scanner.nextInt();
        // 存储材料的重量
        int[] weight = new int[n];
        // 存储材料的价值
        int[] value = new int[n];

        for (int i = 0; i < n; i++) {
            weight[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            value[i] = scanner.nextInt();
        }

        // 初始化 dp 数组
        int[][] dp = new int[n][bageweight + 1];
        // 左边列
        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }
        // 上边行
        // 把物品 0 放入不同容量的背包，只有当背包容量大于等于 weight[0] 才能放入
        for (int i = weight[0]; i <= bageweight; i++) {
            // dp[0][i] 表示存放编号0的物品的时候，各个容量的背包所能存放的最大价值
            dp[0][i] = value[0];
        }
        // 遍历物品（从第二行开始遍历，递归公式需要由正上方和左上方的数值推导而来）
        for (int i = 1; i < n; i++) {
            // 遍历背包容量
            for (int j = 0; j <= bageweight; j++) {
                // 不放物品 i（背包容量不够）
                if (j < weight[i]) {
                    dp[i][j] = dp[i - 1][j];
                }
                // 放物品 i（i 是索引下标）
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }

        }
        System.out.println(dp[n-1][bageweight]);
    }
}
