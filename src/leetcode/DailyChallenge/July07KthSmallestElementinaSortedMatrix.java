package leetcode.DailyChallenge;

import java.util.Arrays;

/**
 * 给出一个 m*n 的二维数组，其中每个数组都是递增排序的，那么在所有的数组中第 k 个元素的值是多少?
 * 暴力解法，直接把二维数组放进一维数组中，然后进行排序
 *
 * @author Okaeri
 */
public class July07KthSmallestElementinaSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] arr = new int[m * n];
        for (int i = 0; i < m; i++) {
            System.arraycopy(matrix[i], 0, arr, i * n, n);
        }
        Arrays.sort(arr);
        return arr[k - 1];
    }
}


class July007Test {
    public static void main(String[] args) {
        int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        int k = 8;
        July07KthSmallestElementinaSortedMatrix sol = new July07KthSmallestElementinaSortedMatrix();
        System.out.println(sol.kthSmallest(matrix, k));
    }
}
