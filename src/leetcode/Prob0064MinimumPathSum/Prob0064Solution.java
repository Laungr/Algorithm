package leetcode.Prob0064MinimumPathSum;

/**
 * 还是棋盘跳格子问题，找出一条经过元素之和最小的路径
 * 与 Prob0062 Prob0063 解法完全一致，动态规划问题
 * 时间复杂度 O(m * n)
 *
 * @author Okaeri
 */
public class Prob0064Solution {
    public int minPathSum(int[][] grid) {
        // m, n 分别是二维数组的行数和列数
        int m = grid.length;
        int n = grid[0].length;
        //创建二维数组,dp[i,j] 表示在 [i,j] 这个位置的最小 path sum
        int[][] dp = new int[m][n];
        // 初始条件
        dp[0][0] = grid[0][0];
        //填充第一行
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        //填充第一列
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        //其他位置的值
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}

class Test {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int[][] grid2 = new int[][]{{1, 2, 3}, {4, 5, 6}};
        Prob0064Solution sol = new Prob0064Solution();
        int i = sol.minPathSum(grid2);
        System.out.println(i);
    }
}

