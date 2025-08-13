package chapter1_稀疏数组;

/**
 * 稀疏数组：压缩矩阵存储
 * 稀疏数组的三列：row col val
 */
public class SparseArray {
    public static void main(String[] args) {

        // 二维矩阵 --> 稀疏数组

        // 1. 初始化二维矩阵（0表示没有值，1表示存储值）
        int[][] array = new int[11][11];
        // 第二行第三列
        array[1][2] = 1;
        // 第三行第四列
        array[2][3] = 1;
        // 第五行第六列
        array[4][5] = 1;

        // 打印测试：二维矩阵
        System.out.println("======二维矩阵如下======");
        for (int[] arrays : array) {
            for (int value : arrays) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }

        // 2. 统计非 0 数据，用于初始化稀疏数组
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (array[i][j] != 0) {
                    sum++;
                }
            }
        }

        // 3. 初始化稀疏数组（行数多一行：第一行存储二维矩阵的信息）
        int[][] sparseArray = new int[sum + 1][3];
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;

        // 用于记录第几个非 0 数据，同时用稀疏矩阵的行索引自增
        int count = 0;

        // 4. 遍历二维矩阵，把不为 0 的数据信息添加到稀疏矩阵中
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (array[i][j] != 0) {
                    // 从第一行开始放入数据
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = array[i][j];
                }
            }
        }

        // 打印测试：稀疏矩阵
        System.out.println("======稀疏矩阵如下======");
        for (int[] arrays : sparseArray) {
            for (int value : arrays) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }

        // 稀疏矩阵 --> 二维矩阵

        // 1. 根据第一行数据信息，初始化二维矩阵
        int[][] newArray = new int[sparseArray[0][0]][sparseArray[0][1]];

        // 2. 遍历稀疏数组，转二维矩阵（易错：需要从第二行开始遍历）
        for (int i = 1; i < sparseArray.length; i++) {
            newArray[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        // 3. 打印测试
        System.out.println("======新的二维矩阵======");
        for (int[] arrays : newArray) {
            for (int value : arrays) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }
}
