package interview.huawei.ODOnline0615.prob0003;

import java.util.Scanner;

class Main {
    // 移动的方向，分别代表往上、下，左、右
//    private static String[] direction = {"U", "D", "L", "R", "G"};
    private static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    // 二维数组的长和宽
    private static int m;
    private static int n;
    // 棋盘
    private static String[][] board;
    // 和棋盘一样大，判断格子上是否有设的身体
    private static boolean[][] occupied;

    // 当前的head 所在位置
    private static int headX;
    private static int headY;
    // 当前的 tail 所在位置
    private static int tailX;
    private static int tailY;
    // 最终的返回结果，也是当前的蛇的长度
    private static int res;

    public static void main(String[] args) {
        // 开始输入
        Scanner sc = new Scanner(System.in);
        String movement = sc.nextLine();
        m = sc.nextInt();
        n = sc.nextInt();
        board = new String[m][n];
        occupied = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                String s = sc.next();
                board[i][j] = s;
                if ("H".equals(s)) {
                    headX = i;
                    headY = j;
                    tailX = i;
                    tailY = j;
                    board[i][j] = "E";
                    occupied[i][j] = true;
                }
            }
        }
        // 输入完成

        res = 1;
        String[] moves = movement.split(" ");
        // 默认向左
        int[] direction = {0, -1};
        for (String move : moves) {
            // 蛇的移动方向
            if ("U".equals(move)) {
                direction = directions[0];
            } else if ("D".equals(move)) {
                direction = directions[1];
            } else if ("L".equals(move)) {
                direction = directions[2];
            } else if ("R".equals(move)) {
                direction = directions[3];
            }
            // 下一个要到达的位置
            headX += direction[0];
            headY += direction[1];

            // 如果越界，直接返回
            // 或者是头的位置有身体
            if (headX < 0 || headY < 0 || headX >= m || headY >= n || occupied[headX][headY]) {
                System.out.println(res);
                return;
            }
            //没有食物，尾离开
            if ("E".equals(board[headX][headY])) {
                occupied[tailX][tailY] = false;
                tailX += direction[0];
                tailY += direction[1];

            }
            // 有食物，且新格子被占
            if ("F".equals(board[headX][headY])) {
                ++res;
                occupied[headX][headY] = true;
            }
        }
    }
}


public class Prob0003 {
}
