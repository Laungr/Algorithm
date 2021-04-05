package leetcode.Prob0032LongestValidParentheses;

public class Prob0032Solution {
    public static int longestValidParentheses(String s) {
        //字符串长度
        int N = s.length();

        //dp数组
        boolean dp[][] = new boolean[N][N];
        int maxLen = 0;

        //i,j分别表示start和end，开始遍历
        for (int j = 1; j < N; j++) {
            for (int i = 0; i < j; i++) {
                //不以(开头 )结尾的都不是有效的，子串的长度为奇数的都不是有效的
                if (s.charAt(i) != '(' || s.charAt(j) != ')'|| (j - i) % 2 == 0) dp[i][j] = false;
                else{
                    if(j - i < 2) dp[i][j] = true;
                    else dp[i][j] = dp[i+1][j-1];
                }

                if (dp[i][j]) maxLen = Math.max(maxLen, j-i+1);
            }
        }
        return maxLen;
    }
}

class Test{
    public static void main(String[] args) {
        String s1 = ")()())";
        String s2 = "(()";
        System.out.println(Prob0032Solution.longestValidParentheses(s1));
        System.out.println(Prob0032Solution.longestValidParentheses(s2));
    }
}
