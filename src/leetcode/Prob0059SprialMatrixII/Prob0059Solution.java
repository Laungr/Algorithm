package leetcode.Prob0059SprialMatrixII;

import java.util.Arrays;

/**
 * n 阶矩阵，按照顺时针螺旋的方式递增排布
 *
 * @author Okaeri
 */
public class Prob0059Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        helper(result, 0, 0);
        return result;
    }

    private void helper(int[][] matrix, int row, int count) {
        int n = matrix.length;
        // 常规情况递归出口
        if (row > n / 2) {
            return;
        }
        // 当 n 为 奇数情况下的最后一个元素，即矩阵的中心元素
        if (n % 2 == 1 && row == n / 2){
            matrix[row][row] = ++ count;
            return;
        }
        // 分成首行、尾行、首列、尾列
        for (int i = row; i < n - 1 - row; i++) {
            matrix[row][i] = ++count;
        }
        for (int i = row; i < n - 1 - row; i++) {
            matrix[i][n - 1 - row] = ++count;
        }
        for (int i = n - 1 - row; i > row; i--) {
            matrix[n - 1 - row][i] = ++count;
        }
        for (int i = n - 1 - row; i > row; i--) {
            matrix[i][row] = ++count;
        }
        helper(matrix, row + 1, count);
    }
}

class Test {
    public static void main(String[] args) {
        Prob0059Solution sol = new Prob0059Solution();
        int n = 5;
        int[][] ints = sol.generateMatrix(n);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }

    }
}
