package leetcode.Prob0010RegularExpressionMatch;

/**
 * 正则表达式的匹配
 * "." 匹配任意一个字符
 * "*" 匹配任意个前面的字符
 */
class Prob0010Solution {
    public boolean isMatch(String s, String p) {
        int strLen = s.length();
        int patLen = p.length();

        boolean[][] dp = new boolean[strLen + 1][patLen + 1];

        dp[0][0] = true;

        //填充第0行

        for (int col=1; col<dp[0].length; col++) {
            char ch = p.charAt(col-1);
            if (col > 1) {
                if (ch == '*') {
                    dp[0][col] = dp[0][col-2];
                } else {
                    dp[0][col] = false;
                }
            } else {
                if (ch == '*') {
                    dp[0][col] = true;
                }
            }
        }

        for (int si = 1; si <= strLen; si++) {
            char row = s.charAt(si - 1);
            for (int pi = 1; pi <= patLen; pi++) {
                char col = p.charAt(pi - 1);
                if (row == col || col == '.') {
                    dp[si][pi] = dp[si - 1][pi - 1];
                } else if (col == '*') {
                    if (pi > 1) {
                        if (dp[si][pi - 2]) {
                            dp[si][pi] = true;
                        } else {
                            char prev = p.charAt(pi - 2);
                            if (prev == row || prev == '.') {
                                dp[si][pi] = dp[si - 1][pi];
                            }
                        }
                    }
                }
            }
        }
        return dp[strLen][patLen];
    }
}

class Test{
    public static void main(String[] args) {
        Prob0010Solution sol = new Prob0010Solution();
        String s = "aa";
        String p = "a*";

        System.out.println(sol.isMatch(s, p));
    }
}
