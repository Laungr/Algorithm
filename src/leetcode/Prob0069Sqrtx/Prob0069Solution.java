package leetcode.Prob0069Sqrtx;

/**
 * 给正整数x，求 x 的平方根，如果结果是小数，只保留整数部分。
 * 这个题的关键是要把 sqrt * sqrt 的值转换成 long 类型，防止 int 溢出。
 *
 * @author Okaeri
 */
public class Prob0069Solution {
    public int mySqrt(int x) {
        int sqrt = 1;
        // 循环的结果是：sqrt * sqrt >= x，快速找到 2^k 的平方大于 k 的数，然后在 [2^(k-1) ~ 2^k] 中二分查找
        while (x > ((long) sqrt * sqrt)) {
            sqrt *= 2;
        }

        int lo = sqrt / 2;
        int hi = sqrt;

        // 开始二分查找
        while (lo <= hi) {
            int mid = lo + ((hi - lo) / 2);
            if ((long) mid * mid <= x && (long) (mid + 1) * (mid + 1) > x) {
                sqrt = mid;
                break;
            } else if ((long) mid * mid > x) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return sqrt;
    }
}

class Test {
    public static void main(String[] args) {
        Prob0069Solution sol = new Prob0069Solution();
        int x = 2147395599;
        int i = sol.mySqrt(x);
        System.out.println(i);

    }
}