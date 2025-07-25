package Day2.question2_59;

public class Solution {
    public int[][] generateMatrix(int n) {

        // 核心思想在左闭右开，该条边的最后一个点由下一条边处理

        int[][] nums = new int[n][n]; // 矩阵的初始化

        int start_x = 0, start_y = 0; // 每一圈的起点
        int i, j; // i 代表行，j 代表列

        int loop = 1; // 记录圈数
        int count = 1; // 矩阵中填入的数字
        int offset = 1;

        while (loop <= n / 2) {

            // 向右走
            for (j = start_y; j < n - offset; j++) {
                nums[start_x][j] = count;
                count++;
            }

            // 向下走
            for (i = start_x; i < n - offset; i++) {
                nums[i][j] = count;
                count++;
            }

            // 向左走
            for (; j > start_y; j--) {
                nums[i][j] = count;
                count++;
            }

            // 向上走
            for (; i > start_x; i--) {
                nums[i][j] = count;
                count++;
            }

            // 一圈结束后，变化起始坐标
            start_x++;
            start_y++;

            offset++; // 往里走了一圈，终点位置往里缩小，差值增大
            loop++; // 圈数自增一
        }

        //  处理奇数圈最后一个点
        if(n % 2 == 1){
            nums[start_x][start_y] = count;
        }
        return nums;
    }
}
