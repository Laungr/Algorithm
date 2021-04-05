package leetcode.Prob1143LongestCommonSubsequence;

/**
 * 最长公共子序列
 * 动态规划问题
 */
public class Prob1143Solution {
    public int longestCommonSubsequence(String text1, String text2) {
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
        Prob1143Solution sol = new Prob1143Solution();
        String text1 = "abcde";
        String text2 = "abcde";
        int i = sol.longestCommonSubsequence(text1, text2);
        System.out.println(i);

    }
}