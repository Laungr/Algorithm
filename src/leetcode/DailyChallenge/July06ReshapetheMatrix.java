package leetcode.DailyChallenge;

/**
 * 把一个二维数组进行重构，把 m*n 的矩阵转化成为 r*c 大小的矩阵
 *
 * @author Okaeri
 */
public class July06ReshapetheMatrix {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        // 原二维数组的行数和列数
        int m = mat.length;
        int n = mat[0].length;
        // 前后的两个矩阵容纳的元素个数不一致，那么不能 reshape，返回原二维数组
        if (m * n != r * c) {
            return mat;
        }
        // 把二维矩阵转化为一维
        int[] array = new int[m * n];
        for (int i = 0; i < m; i++) {
            System.arraycopy(mat[i], 0, array, i * n, n);
        }

        // 再把一维矩阵转化为二维
        int[][] res = new int[r][c];
        for (int i = 0; i < r; i++) {
            System.arraycopy(array, i * c, res[i], 0, c);
        }
        return res;
    }
}

class TestJuly06 {
    public static void main(String[] args) {
        July06ReshapetheMatrix sol = new July06ReshapetheMatrix();
        int[][] mat = {{1, 2}, {3, 4}};
        int r = 4;
        int c = 2;
        int[][] ints = sol.matrixReshape(mat, r, c);
    }
}
