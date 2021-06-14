package leetcode.Prob0200NumberofIslands;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出一个 m * n 阶二维数组包含 0 和 1，0 表示海水，1 表示陆地，上下左右被水围住的就是岛，求 岛的数量。
 * 用深度优先搜索
 *
 * @author Okaeri
 */
public class Prob0200Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;

        // 只要出现一个 1，就可以构成一个岛屿，但是 1 的周围（上下左右）的 1，就都是无效的
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1'){
                    ++res;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int row, int col) {
        int m = grid.length;
        int n = grid[0].length;
        // 搜索越界，递归出口
        if (row < 0 || col < 0 || row >= m || col >= n) {
            return;
        }
        // 在[row, col] 位置的值是 0,就返回，不能构成岛屿
        if (grid[row][col] == '0') {
            return;
        }
        // 在[row, col]位置的值是 1，就把他置为 0；
        // 并在它的上、下、左、右搜索，如果是1 也要置为 0，因为在同一个岛屿之中。
        grid[row][col] = '0';
        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
    }
}
