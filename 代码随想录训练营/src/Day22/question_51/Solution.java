package Day22.question_51;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        // 初始化棋盘
        char[][] chessboard = new char[n][n];
        for (char[] c : chessboard) {
            Arrays.fill(c, '.');
        }
        backtracking(chessboard, n, 0);
        return res;
    }

    // 回溯（递归处理每一行，单层递归处理每一列）
    public void backtracking(char[][] chessboard, int n, int row) {
        // 遍历到叶子节点，收获结果
        if (row == n) {
            // 逐行返回棋盘的内容，添加到一维数组中，把结果加入结果集
            res.add(arrayList(chessboard));
        }
        for (int col = 0; col < n; col++) {
            if (isValid(chessboard, n, row, col)) {
                chessboard[row][col] = 'Q';
                // 下一层递归（在棋盘中表示下一行）
                backtracking(chessboard, n, row + 1);
                // 回溯
                chessboard[row][col] = '.';
            }
        }
    }

    /*
        （1）按理说这里应该返回一个三维数组，每个元素就是一个二维数组，即一个棋盘，对应一种情况
        （2）但是题目返回的是二维数组，即每个元素是一维数组
        （3）需要编写一个方法把二维数组的内容按照每一行的方式存储到一维数组中，并返回
     */
    public List arrayList(char[][] chessboard) {
        List<String> list = new ArrayList<>();
        for (char[] c : chessboard) {
            /*
                （1）把棋盘的每一行数据添加到一维数组中
                （2）copyValueOf：复制 char[] 数组的内容，返回一个字符串
             */
            list.add(String.copyValueOf(c));
        }
        return list;
    }

    // 判断皇后位置是否合法
    public boolean isValid(char[][] chessboard, int n, int row, int col) {

        // 由于是逐层递归放置皇后，即只需要检查当前皇后上方对的位置即可

        // 检查行
        /*
            根据程序运行逻辑，在单层搜索的过程中，每一层递归，
            只会选for循环（也就是同一行）里的一个元素，所以不用去重了
         */

        // 检查列（列固定，遍历行，检查同一列上是否出现多个皇后）
        for (int i = 0; i < row; i++) {
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }
        // 检查 45 度对角线（从当前位置开始，检查右上方是否有皇后）
        for (int i = row - 1, j = col + 1; i >= 0 && j <= n - 1; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        // 检查 135 度对角线（从当前位置开始，检查左上方是否有皇后）
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
