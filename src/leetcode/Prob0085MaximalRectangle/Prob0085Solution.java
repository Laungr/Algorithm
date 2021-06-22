package leetcode.Prob0085MaximalRectangle;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给出一个二位矩阵，由 0 和 1 填充，1 组成的矩形面积最大的是多少
 * <p>
 * 与 Prob0084 类似，可以视为 n 层 Prob0084 的重复，
 *
 * @author Okaeri
 */
public class Prob0085Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        // 如果数组为空，就返回 0
        if (m == 0) {
            return 0;
        }
        // 数组不为空，去计算他的列数
        int n = matrix[0].length;

        // 创建新数组，在前后多加上两列，即首尾补充 0
        int[][] newMatrix = new int[m][n + 2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n + 2; j++) {
                // 第一列和最后一列为 0
                if (j == 0 || j == n + 1) {
                    newMatrix[i][j] = 0;
                }
                // 其他列
                else {
                    // 如果原位置为 0，就直接是 0
                    if (matrix[i][j - 1] == '0') {
                        newMatrix[i][j] = 0;
                    }
                    // 不为 0 的话，就把高度累加，即转化成 Prob0084
                    else {
                        newMatrix[i][j] = matrix[i][j - 1] - '0' + (i > 0 ? newMatrix[i - 1][j] : 0);
                    }
                }
            }
        }
        // 最后就是 Prob0084 的问题
        int res = 0;
        for (int[] ints : newMatrix) {
            res = Math.max(res, maximalRectangle(ints));
        }
        return res;
    }

    /**
     * Prob0084 的解题思路
     *
     * @param arr 输入数组
     * @return 最大面积
     */
    private int maximalRectangle(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                int height = arr[stack.pop()];
                int left = 0;
                if (!stack.isEmpty()) {
                    left = stack.peek();
                }
                maxArea = Math.max(maxArea, height * (i - left - 1));

            }
            stack.push(i);
        }
        return maxArea;
    }
}

class Test {
    public static void main(String[] args) {
        Prob0085Solution sol = new Prob0085Solution();
        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        char[][] matrix2 = {{'1', '1'}};
        int i = sol.maximalRectangle(matrix2);
        System.out.println(i);
    }
}
