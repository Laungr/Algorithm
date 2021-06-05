package leetcode.Prob0072SetMatrixZeroes;

import java.util.Arrays;

/**
 * 给出一个二维数组，如果数组中包含 0 ，那么将该行和该列全部以 0 填充，只有原始数组中的 0 需要改变所在行列的值，新增的 0 则无效.
 * <p>
 * 空间复杂度 O(m + n)
 *
 * @author Okaeri
 */
public class Prob0072Solution {
    public void setZeros(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        // 定义一个数组，前 m 个数装要置为 0 的和，第 m ~ m+n 装要置为 0 的列，记录该行该列是否要填充 0
        boolean[] array = new boolean[m + n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 如果是 0 就要置换
                if (matrix[i][j] == 0) {
                    array[i] = true;
                    array[m + j] = true;
                }
            }
        }
        // 遍历 array 状态数组，把对应的行 和 列 填充成 0
        for (int i = 0; i < m; i++) {
            if (array[i]) {
                Arrays.fill(matrix[i], 0);
            }
        }
        for (int j = 0; j < n; j++) {
            if (array[m + j]) {
                for (int i = 0; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}

class Test {
    public static void main(String[] args) {
        Prob0072Solution sol = new Prob0072Solution();
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        sol.setZeros(matrix);
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }
}