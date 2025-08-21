package Day30._01背包一维DP;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 材料的数量
        int M = scanner.nextInt();
        // 材料的大小
        int N = scanner.nextInt();

        // 材料占用的空间
        int[] costs = new int[M];
        // 材料的价值
        int[] values = new int[M];

        for (int i = 0; i < M; i++) {
            costs[i] = scanner.nextInt();
        }

        for (int i = 0; i < M; i++) {
            values[i] = scanner.nextInt();
        }

        int[] dp = new int[N + 1];

        // 先遍历物品
        for (int i = 0; i < M; i++) {
            // 后遍历背包
            for (int j = N; j >= costs[i]; j--) {
                // 包含了选 物品 i 和不选 物品 i 的情况，取最大值
                dp[j] = Math.max(dp[j], dp[j - costs[i]] + values[i]);
            }
        }
        System.out.println(dp[N]);
    }
}
