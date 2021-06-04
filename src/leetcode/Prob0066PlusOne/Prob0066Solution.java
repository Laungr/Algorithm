package leetcode.Prob0066PlusOne;

import java.util.Arrays;

/**
 * 把一个整数 k 的各位放进一个数组里面，以数组的形式返回 k + 1
 * 整数位数很大，无法以 integer 的形式表达
 *
 * @author Okaeri
 */
public class Prob0066Solution {
    public int[] plusOne(int[] digits) {
        // 进位标志
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int temp = digits[i] + carry;
            carry = temp / 10;
            digits[i] = temp % 10;
        }
        if (carry == 1) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            System.arraycopy(digits, 0, res, 1, digits.length);
            return res;
        }
        return digits;
    }
}

class Test {
    public static void main(String[] args) {
        Prob0066Solution sol = new Prob0066Solution();
        int[] digits = {9, 9};
        int[] ints = sol.plusOne(digits);
        System.out.println(Arrays.toString(ints));

    }
}
