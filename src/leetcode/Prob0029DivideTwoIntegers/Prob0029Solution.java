package leetcode.Prob0029DivideTwoIntegers;

/**
 * 看到一个思路是：感觉有点意思
 * 推荐一个不用long节省空间的方法： 首先输入都是int类型，也就是32位的，那么绝对值最大的情况也就是-2^31，
 * 那么把所有数转换成负数来计算，就绝对不会溢出了。 a = a<0?a:-a;
 */
public class Prob0029Solution {
    public int divide(int dividend, int divisor) {
        //flag 是结果的正负标志
        //并对除数和被除数取绝对值
        int flag = -1;
        //如果被除数为0，直接返回0
        if (dividend == 0) {
            return 0;
        }
        //对除数和被除数变成负数
        if (dividend > 0) {
            dividend = -dividend;
            flag = -flag;
        }
        if (divisor > 0) {
            divisor = -divisor;
            flag = -flag;
        }

        int res = helper(dividend, divisor);

        if (res == Integer.MIN_VALUE && flag == -1) {
            return Integer.MAX_VALUE;
        }
        return res * flag;
    }

    /**
     * 用了幂次数递增的思路 速度比加法来得快
     * @param a 被除数 a < 0
     * @param b 除数 b < 0
     * @return 返回 a/b 的值
     */
    int helper(int a, int b) {
        int HALF_MIN = Integer.MIN_VALUE >> 1;
        if (a > b) {
            return 0;
        }
        int count = -1;
        int tb = b;
        while (a <= (tb + tb) && tb >= HALF_MIN) {
            count += count;
            tb += tb;
            System.out.println(tb);
        }
        return count + helper(a - tb, b);
    }
}

class Test {
    public static void main(String[] args) {
        Prob0029Solution sol = new Prob0029Solution();
        int dividend = -2147483648;
        int divisor = -1;
        System.out.println(sol.divide(dividend, divisor));
    }
}