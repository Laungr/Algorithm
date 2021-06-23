package leetcode.Prob0089GrayCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 格雷编码 对格雷码的理解有误
 *
 * @author Okaeri
 */
public class Prob0089Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        res.add(1);
        int num = 1;
        // 把各位为 1 的二进制数放进去，直到大于 n
        while (n > num) {
            num = (num << 1) + 1;
            res.add(num);
        }
        // 从大往小减，直到找出这个数字
        int minus = (num + 1) >> 1;
        while (num != n) {
            while (num - minus < n) {
                minus = minus >> 1;
            }
            num = num - minus;
            res.add(num);
        }
        return res;
    }
}

/**
 * 算是一个找规律的题目，gray(n) = 1<< (n-1) + gray(n - 1).for
 */
class Prob0089Solution2 {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        for (int i = 1; i <= n; i++) {
            int add = 1 << (i - 1);
            for (int j = res.size() - 1; j >= 0; j--) {
                res.add(res.get(j) + add);
            }
        }
        return res;
    }
}

class Test {
    public static void main(String[] args) {
        Prob0089Solution2 sol = new Prob0089Solution2();
        List<Integer> list = sol.grayCode(2);
        System.out.println(list.toString());
    }
}
