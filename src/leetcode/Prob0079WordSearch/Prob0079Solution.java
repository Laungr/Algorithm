package leetcode.Prob0079WordSearch;

/**
 * 给出一个二维字符数组，给出一个单词，
 */
public class Prob0079Solution {
    public boolean exist(char[][] board, String word) {
        // 矩阵的长和宽
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean check = check(board, visited, i, j, word, 0);
                if (check) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean check(char[][] board, boolean[][] visited, int i, int j, String word, int k) {
        if (board[i][j] != word.charAt(k)) {
            return false;
        }
        if (k == word.length() - 1) {
            return true;
        }
        // 如果 board[i][j] == word.charAt(k)，就在它的 上，下，左，右找 word.charAt(k + 1)

        visited[i][j] = true;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean result = false;
        for (int[] dir : directions) {
            int newi = i + dir[0], newj = j + dir[1];
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                if (!visited[newi][newj]) {
                    boolean flag = check(board, visited, newi, newj, word, k + 1);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;
        return result;
    }
}

class Prob0079Solution2 {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        // 矩阵遍历，从 [i, j] 这个位置做起始，看能否成功匹配，一旦成功就返回，不成功就继续遍历，最终返回 false
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean dfs = dfs(board, i, j, word, 0);
                if (dfs) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int k) {
        // 如果 word 的字符从 0 到 word.length - 1 都匹配上了，就返回 true
        if (k == word.length()) {
            return true;
        }
        // 索引越界返回 false
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }
        // 字符不匹配，返回 false
        if (board[i][j] != word.charAt(k)) {
            return false;
        }

        // 第 k 个字符与 board[i][j] 成功匹配，那么就往上，下，左，右去匹配 k+1 个字符。
        // 为了防止 board[i][j] 拐过来被使用一次，将它修改成一个非字母，无法与字符串匹配的字符
        char temp = board[i][j];
        board[i][j] = '0';
        boolean result = dfs(board, i + 1, j, word, k + 1) ||
                dfs(board, i, j + 1, word, k + 1) ||
                dfs(board, i - 1, j, word, k + 1) ||
                dfs(board, i, j - 1, word, k + 1);
        // 递归出口之后把 board[i][j] 交换回来
        board[i][j] = temp;
        return result;
    }
}
