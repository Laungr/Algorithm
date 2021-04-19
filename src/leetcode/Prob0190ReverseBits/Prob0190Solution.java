package leetcode.Prob0190ReverseBits;


/**
 * 这个解法不能得到正确的结果
 * 把数字 int 类型转换为 String 类型，然后把字符串进行反转；
 * 问题在于 Java 的 int 类型的范围为 [-pow(2, 31), pow(2, 31) - 1]；
 * 那么当最高位为 1 的时候需要进行处理，Java 中用 2 的补码来表示负数；
 * 对于高位为 1 的 string 无法通过 parseInt 把他转化成 int 类型
 *
 */
public class Prob0190Solution {
    public int reverseBits(int n) {
        String s = Integer.toBinaryString(n);
//        System.out.println(s);
        int left = 0;
        // 高位用 0 补全
        String zero32 = "00000000000000000000000000000000";
        s = zero32.substring(0, 32 - s.length()) + s;
//        System.out.println(s);
        int right = s.length() - 1;
        char[] chars = s.toCharArray();
        //反转
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        String res = new String(chars);
//        System.out.println(res);
        int result = 0;
        if (res.charAt(0) == '0') {
            result = Integer.parseInt(res.substring(1, 32), 2);
        }
        else {
            result = (~(Integer.parseInt(res.substring(0, 32), 2)) - 1);
        }
//        System.out.println(Integer.toBinaryString(result));
        return result;

    }
}

/**
 * 这种解法思路比较厉害，是通过位运算的方式；
 * res 是最后得到的结果，每次运算之前，res << 1 左移一位，然后加上 n & 1， 也就是 n 的最低位， 再把 n 右移一位，把最低位去掉；
 * 如此循环 32 次，就可以把一个 32 位的数字处理完毕。
 */
class Prob0190Solution2{
    public int reverseBits(int n) {
        int BIT_OF_UNSIGNED_INT = 32;
        int res = 0;
        for (int i = 0; i < BIT_OF_UNSIGNED_INT; i++) {
            res = res << 1;
            res = res + (n & 1);
            n = n >> 1;
        }
        return res;
    }
}
class Test {
    public static void main(String[] args) {
        Prob0190Solution2 sol = new Prob0190Solution2();
        System.out.println(sol.reverseBits(-3));
    }
}
