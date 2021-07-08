package leetcode.DailyChallenge;

/**
 * 给出两个数组，找出两个数组中都包含有连续元素最长长度为多少
 * 暴力解法时间复杂度超出。
 *
 * @author Okaeri
 */
public class July08MaximumLengthofRepeatedSubarray {
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int res = 0;
        int offset = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (nums1[i] == nums2[j]) {
                    offset++;
                    while (i + offset < m && j + offset < n && nums1[i + offset] == nums2[j + offset]) {
                        offset++;
                    }
                    res = Math.max(res, offset);
                }
                offset = 0;
            }
        }
        return res;
    }
}

/**
 * 动态规划解法，实现起来并不难，主要是思路上想不到
 */
class ProbJuly08Solution2 {
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (nums1[i] != nums2[j]) {
                    dp[i][j] = 0;
                }
                // [i,j] 不在 0 行 0 列，可以取左上角位置的值
                else if (i > 0 && j > 0) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                // [i,j] 在 0 行 0 列，直接赋值为 1
                else {
                    dp[i][j] = 1;
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}

class July08Test {
    public static void main(String[] args) {
        July08MaximumLengthofRepeatedSubarray sol = new July08MaximumLengthofRepeatedSubarray();
        int[] nums1 = {1, 2, 3, 2, 1};
        int[] nums2 = {3, 2, 1, 4, 7};
        System.out.println(sol.findLength(nums1, nums2));
    }
}
