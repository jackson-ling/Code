package Day2.区间和;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int vec[] = new int[n];
        int[] p = new int[n]; // 前缀和数组

        int presum = 0;
        for (int i = 0; i < n; i++) {
            vec[i] = scanner.nextInt();
            presum += vec[i];
            p[i] = presum; // 初始化前缀和数组
        }

        // 循环读取整数，每一轮读取两个，表示区间和的范围
        while(scanner.hasNextInt()){
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            int sum;
            if(a==0){  // 判断左端点是为 0
                sum = p[b];
            }else{
                sum = p[b] - p[a - 1];
            }
            System.out.println(sum);
        }
        scanner.close();
    }
}
