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

/**
 * 滑动窗口解法
 */
class ProbJuly08Solution3 {
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            int len = Math.min(n, m - i);
            int maxLen = maxLength(nums1, nums2, i, 0, len);
            res = Math.max(res, maxLen);
        }

        for (int i = 0; i < n; i++) {
            int len = Math.min(m, n - i);
            int maxLen = maxLength(nums2, nums1, i, 0, len);
            res = Math.max(res, maxLen);
        }
        return res;
    }

    /**
     * 给出两个数组 A 和 B，A 从 addA 索引起始，B 从 addB 索引起始，找出两个数组中重复元素的长度
     * @param A 输入数组 A
     * @param B 输入数组 A
     * @param addA 数组 A 索引起始
     * @param addB 数组 A 索引起始
     * @param len (A.length - addA), (B.length - addB) 中的较小值
     * @return 重复元素的最长长度
     */
    public int maxLength(int[] A, int[] B, int addA, int addB, int len) {
        int ret = 0, offset = 0;
        for (int i = 0; i < len; i++) {
            if (A[addA + i] == B[addB + i]) {
                offset++;
            } else {
                offset = 0;
            }
            ret = Math.max(ret, offset);
        }
        return ret;
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
