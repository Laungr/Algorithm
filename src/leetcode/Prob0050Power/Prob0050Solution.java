package leetcode.Prob0050Power;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
 *
 * @author Okaeri
 */
public class Prob0050Solution {
    /**
     * 计算 x 的 n 次方
     * 暴力解法
     *
     * @param x 底数
     * @param n 幂指数
     * @return x 的 n 次方
     */
    public double myPow(double x, int n) {
        double result = 1.0;
        for (int i = 0; i < Math.abs(n); i++) {
            result *= x;
        }
        return n > 0 ? result : 1.0 / result;
    }
}


/**
 * 二分法
 */
class Prob0050Solution2 {
    public double myPow(double x, int n) {
        double res = quickPow(x, n);
        return n > 0 ? res : 1.0 / res;
    }

    private double quickPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double y = quickPow(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }
}

class Test {
    public static void main(String[] args) {
        Prob0050Solution sol = new Prob0050Solution();
        double x = 2.00000;
        int n = -10;
        double v = sol.myPow(x, n);
        System.out.println(v);
        System.out.println(1.0 / 2 / 2);
    }
}
