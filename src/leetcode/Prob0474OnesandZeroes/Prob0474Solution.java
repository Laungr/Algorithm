package leetcode.Prob0474OnesandZeroes;

/**
 * strs[] 数组是一个字符串数组，其中的字符串都是由若干个 "0" "1" 组成的，给出数字 m, n，
 * 求出包含 m 个 1，n 个 0 的最多有多少个字符串 能够 cover 掉这么多的 0 和 1
 * <p>
 * 是一个动态规划问题，类似 0-1 背包问题，但是背包的容量是二维的
 */
public class Prob0474Solution {
    /**
     * @param strs 数组是一个字符串数组，其中的字符串都是由若干个 "0" "1" 组成的
     * @param m    0 的个数 m >= 1
     * @param n    1 的个数 n <= 100
     * @return 包含 m 个 0，n 个 1 的字符串，最多的个数。
     */
    public int findMaxForm(String[] strs, int m, int n) {
        int length = strs.length;
        int[][][] dp = new int[length + 1][m + 1][n + 1];

        for (int i = 1; i <= length; i++) {
            //取出 第 i 个字符串，并获得其中的 0 和 1 的个数
            String str = strs[i - 1];
            int count0 = 0;
            int count1 = 0;
            for (int s = 0; s < str.length(); s++) {
                if (str.charAt(s) == '0') {
                    ++count0;
                }
                if (str.charAt(s) == '1') {
                    ++count1;
                }
            }
            // 0-1 背包问题，这个位置的 m 和 n 都是从 1 开始
            // 这个地方需要从 0 开始是因为单纯的 0 或者 1 也可以匹配

            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    //如果 str 中的 0 或者 1 已经超出背包容量了，那么表示当前的这个字符串不能入选
                    if (count0 > j || count1 > k) {
                        dp[i][j][k] = dp[i - 1][j][k];
                    }
                    // 否则的话就在 选和不选 中取较大值。
                    else {
                        dp[i][j][k] = Math.max(1 + dp[i - 1][j - count0][k - count1], dp[i - 1][j][k]);
                    }
                }
            }
        }
        return dp[length][m][n];
    }
}

class Test {
    public static void main(String[] args) {
        Prob0474Solution sol = new Prob0474Solution();
        String[] strs = {"10","0001","111001","1","0"};
        int m = 1;
        int n = 1;
        int maxForm = sol.findMaxForm(strs, m, n);
        System.out.println(maxForm);


    }
}
