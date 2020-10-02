package leetcode.Prob0005LongestPalindromicSubstring;

import java.util.Arrays;

public class Prob0005Solution {
    public String longestPalindrome(String s) {
        //s的长度为N
        int N = s.length();

        //如果字符串长度为0，则字符串为空，返回空串
        if (N == 0) return "";

        //定义一个dp数组，
        boolean[][] dp = new boolean[N][N];
        int maxLen = 1;
        int begin = 0;

        for (int i = 0; i < N; i++) {
            dp[i][i] = true;
        }

        //开始循环，状态转移方程
        for (int j = 1; j < N; j++){
            for (int i = 0; i < N - 1; i++) {
                if (s.charAt(i) != s.charAt(j)) dp[i][j] = false;
                else {
                    if (j - i < 3) dp[i][j] = true;
                    else dp[i][j] = dp[i + 1][j - 1];
                }
                if(dp[i][j] && j - i + 1 > maxLen){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
       return s.substring(begin, begin + maxLen);
    }
}

class Test{
    public static void main(String[] args) {

    }
}