package leetcode.Prob0516LongestPalindromicSubsequence;

/**
 * 最长回文子序列
 * 原字符串s，把字符串 reverse 得到 rs，
 * 求 s 和 rs 的最长公共子序列
 */

public class Prob0516Solution {
    public int longestPalindromeSubseq(String s) {
        String rs = new String(new StringBuffer(s).reverse());
        return longestCommonSubsequence(s, rs);
    }

    private int longestCommonSubsequence(String text1, String text2) {
        int t1Len = text1.length();
        int t2Len = text2.length();
        int[][] dp = new int[t1Len + 1][t2Len + 1];

        for (int i = 1; i <= t1Len; i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= t2Len; j++) {
                char c2 = text2.charAt(j - 1);
                //如果两个字符相等，那么等于左上角
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                //否则是取左边和上边值中的较大的那个
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[t1Len][t2Len];
    }
}

class Test{
    public static void main(String[] args) {
        Prob0516Solution sol = new Prob0516Solution();
        String s = "abfcfdffcba";
        int i = sol.longestPalindromeSubseq(s);
        System.out.println(i);

    }
}
