package leetcode.Prob0647PalindromicSubstrings;

/**
 * 回文子串的个数
 * 利用动态规划的方程式，如果是就填充 1
 */
public class Prob0647Solution {
    public int countSubStrings(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        int len = s.length();
        int res = 0;
        int[][] dp = new int[len][len];

        for (int i = len - 1; i >= 0; i--) {
            char leftChar = s.charAt(i);
            dp[i][i] = 1;
            res += 1;
            for (int j = i + 1; j < len; j++) {
                char rightChar = s.charAt(j);
                if (leftChar == rightChar) {
                    if (j == i + 1) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                res += dp[i][j];
            }
        }
        return res;
    }
}

class Test {
    public static void main(String[] args) {
        Prob0647Solution sol = new Prob0647Solution();
        String s = "aabc";
        int i = sol.countSubStrings(s);
        System.out.println(i);

    }
}
