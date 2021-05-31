package leetcode.Prob0048RotateImage;

/**
 * 对一个二维矩阵的顺时针旋转90度
 *
 * @author Okaeri
 */
public class Prob0048Solution {
    /**
     * 先按行对称镜像，然后按-45度镜像
     *
     * @param matrix 给定二维数组
     */
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i < (len + 1) / 2; i++) {
            for (int j = 0; j < len; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len - 1 - i][j];
                matrix[len - 1 - i][j] = temp;
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
