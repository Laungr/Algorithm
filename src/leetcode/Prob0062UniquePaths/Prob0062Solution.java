package leetcode.Prob0062UniquePaths;

import leetcode.Prob0026RemoveDuplicatesfromSortedArray.Prob0026Solution;

import java.util.Arrays;

/**
 * 给出一个棋盘，每一步只能往下或往右跳一格，起始位置在左上角，终点位置在右下角，求出不同的跳法的总数
 * <p>
 * 动态规划问题
 *
 * @author Okaeri
 */
public class Prob0062Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        //第 0 行 和第 0 列的跳法都只有一种
        Arrays.fill(dp[0], 1);
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        // 后续每个格子的跳法，是其上一个和左边一个的跳法之和
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}

/**
 * 动态规划，优化时间复杂度
 * 构建 m * n 的一维数组，索引为每一行索引完后然后索引下一行递增
 */
class Prob0062Solution2 {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[m * n];
        int index = 0;
        //第一行填充为 1
        while (index < n) {
            dp[index] = 1;
            ++index;
        }
        while (index < m * n) {
            // 第一列填充为 1
            if (index % n == 0) {
                dp[index] = 1;
            }
            // 其他区域为格子左的数值 + 各自上的数值
            else {
                dp[index] = dp[index - 1] + dp[index - n];
            }
            index++;
        }
        return dp[(m * n - 1)];
    }
}

class Test {
    public static void main(String[] args) {
        Prob0062Solution2 sol = new Prob0062Solution2();
        int m = 3;
        int n = 7;
        int i = sol.uniquePaths(m, n);
        System.out.println(i);
    }
}