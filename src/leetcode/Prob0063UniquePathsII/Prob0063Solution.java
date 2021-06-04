package leetcode.Prob0063UniquePathsII;

/**
 * 给出一个棋盘，每一步只能往下或往右跳一格，起始位置在左上角，终点位置在右下角，但棋盘上有障碍物，路径不能经过障碍物，求出不同的跳法的总数
 *
 * @author Okaeri
 */
public class Prob0063Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[] dp = new int[m * n];
        // 考虑最左上角元素是障碍物的情况
        dp[0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        int index = 1;
        // 把二维数组转移到一维数组中
        int[] obstacleArray = new int[m * n];
        for (int i = 0; i < m; i++) {
            System.arraycopy(obstacleGrid[i], 0, obstacleArray, i * n, n);
        }

        // 填充第一行
        while (index < n) {
            // 障碍物不可到达，有障碍物就为 0，否则等于左一个格子
            dp[index] = obstacleArray[index] == 1 ? 0 : dp[index - 1];
            index++;

        }
        while (index < m * n) {
            //列数为 0 的情况， 有障碍物就为 0，否则等于上一个格子
            if (index % n == 0) {
                dp[index] = obstacleArray[index] == 1 ? 0 : dp[index - n];
            } else {
                dp[index] = obstacleArray[index] == 1 ? 0 : dp[index - 1] + dp[index - n];
            }
            index++;
        }
        // 返回右下角的值
        return dp[m * n - 1];
    }
}
