package interview.huawei;

import java.util.Scanner;

public class HJ083MatrixManipulation {

}

class Main {
    private static int[][] arr;
    private static int m;
    private static int n;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int mLen = sc.nextInt();
            int nLen = sc.nextInt();
            init(mLen, nLen);
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            swap(x1, y1, x2, y2);
            int row = sc.nextInt();
            insertRow(row);
            int col = sc.nextInt();
            insertCol(col);
            int x = sc.nextInt();
            int y = sc.nextInt();
            query(x, y);
        }
    }

    private static void init(int _m, int _n) {
        try {
            if (m > 9 || n > 9) {
                throw new IllegalArgumentException("输入错误");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(-1);
            return;
        }
        m = _m;
        n = _n;
        arr = new int[m][n];
        System.out.println(0);
    }

    private static void swap(int x1, int y1, int x2, int y2) {
        try {
            if (x1 >= m || x2 >= n || y1 >= n || y2 >= n
                    || x1 < 0 || x2 < 0 || y1 < 0 || y2 < 0) {
                throw new IllegalArgumentException("输入错误");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(-1);
            return;
        }
        int temp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = temp;
        System.out.println(0);
    }

    private static void insertRow(int row) {
        try {
            if (row < 0 || row >= m || m == 9) {
                throw new IllegalArgumentException("输入错误");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(-1);
            return;
        }
        int[][] originArr = new int[m][n];
        for (int i = 0; i < m; i++) {
            System.arraycopy(arr[i], 0, originArr[i], 0, n);
        }

        arr = new int[m + 1][n];
        for (int i = 0; i < row; i++) {
            System.arraycopy(originArr[i], 0, arr[i], 0, n);
        }
        for (int i = row + 1; i < m; i++) {
            System.arraycopy(originArr[i - 1], 0, arr[i], 0, n);
        }
        System.out.println(0);
        m = m + 1;
    }

    private static void insertCol(int col) {
        try {
            if (col < 0 || col >= n || n == 9) {
                throw new IllegalArgumentException("输入错误");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(-1);
            return;
        }

        int[][] originArr = new int[m][n];
        for (int i = 0; i < m; i++) {
            System.arraycopy(arr[i], 0, originArr[i], 0, n);
        }
        arr = new int[m][n + 1];
        for (int i = 0; i < m; i++) {
            System.arraycopy(originArr[i], 0, arr[i], 0, col);
            if (n + 1 - (col + 1) >= 0) {
                System.arraycopy(originArr[i], col + 1 - 1, arr[i], col + 1, n + 1 - (col + 1));
            }
            System.out.println(0);
            n = n + 1;
        }
    }

    private static void query(int x, int y) {
        try {
            if (x < 0 || x >= m || y < 0 || y >= n) {
            throw new IllegalArgumentException("输入错误");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(-1);
            return;
        }
        System.out.println(0);

    }
}
