package leetcode.Prob0051NQueen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * N 皇后问题，经典的动态规划
 *
 * @author Okaeri
 */
public class Prob0051Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        init(board);
        helper(result, board, 0);
        return result;
    }


    /**
     * board 初始化，全部填充为 '.'
     */
    private void init(char[][] board) {
        for (char[] chars : board) {
            Arrays.fill(chars, '.');
        }
    }

    private void helper(List<List<String>> result, char[][] board, int rowIndex) {
        // 递归出口
        if (rowIndex == board.length) {
            result.add(generate(board));
            return;
        }
        //进入递归
        for (int colIndex = 0; colIndex < board.length; colIndex++) {
            if (isValid(board, rowIndex, colIndex)) {
                board[rowIndex][colIndex] = 'Q';

                helper(result, board, rowIndex + 1);
                board[rowIndex][colIndex] = '.';
            }
        }
    }

    private boolean isValid(char[][] board, int rowIndex, int colIndex) {
        //判断该列是否已经填充了 Q
        for (int i = 0; i < rowIndex; i++) {
            if (board[i][colIndex] == 'Q') {
                return false;
            }
        }
        // 判断左上角是否已经填充了 Q
        for (int i = rowIndex - 1, j = colIndex - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // 判断右上角是否已经填充了 Q
        for (int i = rowIndex - 1, j = colIndex + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private List<String> generate(char[][] board) {
        List<String> addList = new ArrayList<>(board.length);
        for (char[] chars : board) {
            addList.add(String.valueOf(chars));
        }
        return addList;
    }
}

class Test {
    public static void main(String[] args) {
        Prob0051Solution sol = new Prob0051Solution();
        int n = 4;
        List<List<String>> lists = sol.solveNQueens(n);
        System.out.println(lists.toString());
    }
}
