package leetcode.Prob0054SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

/**
 * 给一个二维数组，按照螺旋的顺序返回元素列表。
 * 递归问题
 *
 * @author Okaeri
 */
public class Prob0054Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> result = new ArrayList<>(m * n);
        helper(matrix, result, 0, m - 1, 0, n - 1);
        return result;
    }

    /**
     * @param matrix   输入的二维数组
     * @param list     要返回的列表
     * @param upRow    这一轮要遍历的二维数组的上面行号
     * @param downRow  这一轮要遍历的二维数组的下面行号
     * @param leftCol  这一轮要遍历的二维数组的左面列号
     * @param rightCol 这一轮要遍历的二维数组的右面列号
     */
    private void helper(int[][] matrix, List<Integer> list, int upRow, int downRow, int leftCol, int rightCol) {
        // 递归出口
        if (leftCol > rightCol || upRow > downRow) {
            return;
        }
        //两种特殊情况 表示当前只有最后一行或者一列，遍历完毕后返回
        if (leftCol == rightCol) {
            for (int i = upRow; i <= downRow; i++) {
                list.add(matrix[i][rightCol]);
            }
            return;
        }
        if (upRow == downRow) {
            for (int j = leftCol; j <= rightCol; j++) {
                list.add(matrix[upRow][j]);
            }
            return;
        }
        // 递归开始
        for (int j = leftCol; j < rightCol; j++) {
            list.add(matrix[upRow][j]);
        }
        for (int i = upRow; i < downRow; i++) {
            list.add(matrix[i][rightCol]);
        }
        for (int j = rightCol; j > leftCol; j--) {
            list.add(matrix[downRow][j]);
        }
        for (int i = downRow; i > upRow; i--) {
            list.add(matrix[i][leftCol]);
        }

        helper(matrix, list, upRow + 1, downRow - 1, leftCol + 1, rightCol - 1);
    }
}

class Test {
    public static void main(String[] args) {
        Prob0054Solution sol = new Prob0054Solution();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        List<Integer> integers = sol.spiralOrder(matrix2);
        System.out.println(integers);
    }
}

/*
1 2 3
4 5 6
7 8 9
9 9 9
1 3 4
 */