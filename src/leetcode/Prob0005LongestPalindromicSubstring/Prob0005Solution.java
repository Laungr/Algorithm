package leetcode.Prob0005LongestPalindromicSubstring;

/**
 * 最长回文子串，动态规划问题
 *
 * @author Okaeri
 */

public class Prob0005Solution {
    public String longestPalindrome(String s) {
        //s的长度为len
        int len = s.length();
        //如果字符串长度为0，则字符串为空，返回空串
        if (len == 0) {
            return "";
        }
        //定义一个dp数组，
        boolean[][] dp = new boolean[len][len];
        int maxLen = 1;
        int begin = 0;
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        //开始循环，状态转移方程
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < len - 1; i++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}

class Prob0005Solution2 {
    public String longestPalindrome(String s) {
        int len = s.length();
        // 最长回文子串的长度，因为题目中规定了 s 的长度最小为 1，也因此 maxLen 最小为 1
        int maxLen = 1;
        // 最长回文子串开始的下标，减少截取的次数
        int begin = 0;
        // dp数组，dp[i][j] 表示 [i, j] 闭区间的子串是不是回文的
        boolean[][] dp = new boolean[len][len];
        for (int j = 0; j < len; j++) {
            for (int i = 0; i <= j; i++) {
                // i == j,就是同一个字符，是回文
                if (i == j) {
                    dp[i][j] = true;
                    continue;
                }
                // 如果两端字符不相等，[i, j]不是回文，
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                }
                // 如果两端字符相等，两种情况判断，i,j相邻是回文， i,j相互、间隔则与 dp[i + 1][j - 1] 相同
                else {
                    if (j < i + 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        // 返回回文子串
        return s.substring(begin, begin + maxLen);
    }
}

class Test {
    public static void main(String[] args) {
        Prob0005Solution2 sol = new Prob0005Solution2();
        String s = "acabaca";
        String s1 = sol.longestPalindrome(s);
        System.out.println(s1);
    }
}