package leetcode.Prob0043MultiplyStrings;

/**
 * 给出两个数字，以字符串的形式表示，返回塔门的乘积，要求不能直接转换为数字相乘
 * 题目中规定：两个字符串的长度 `1 <= num1.length, num2.length <= 200` 直接转换为数字会溢出
 *
 * @author Okaeri
 */
public class Prob0043Solution {
    private static final char ZEROCHAR = '0';

    public String multiply(String num1, String num2) {
        // 两数之一为 0 的情况
        if (num1.charAt(0) == ZEROCHAR || num2.charAt(0) == ZEROCHAR) {
            return "0";
        }
        String result = "";
        StringBuilder zeros = new StringBuilder();
        // 乘数 num1 与 num2 的每一位相乘然后相加
        for (int i = 0; i < num2.length(); i++) {
            zeros.append(0);
            char charAtNum2 = num2.charAt(num2.length() - 1 - i);
            String multiply = multiply(num1, charAtNum2);
            System.out.println(multiply);
            result = sum(result, multiply + zeros);
        }
        return result.substring(0, result.length() - 1);
    }

    /**
     * 数字 与 一个个位数相乘，乘积表示为字符串
     *
     * @param nums1  数字 1，字符串形式
     * @param factor 数字 2，个位数，char 类型
     * @return 返回乘积，字符串形式
     */
    private String multiply(String nums1, char factor) {
        // 进位标志位
        int carry = 0;
        int q = factor - ZEROCHAR;
        //
        StringBuilder sb = new StringBuilder();
        for (int i = nums1.length() - 1; i >= 0; i--) {
            char charAt = nums1.charAt(i);
            int p = charAt - ZEROCHAR;
            int product = p * q + carry;
            sb.insert(0, product % 10);
            carry = product / 10;

        }
        if (carry > 0) {
            sb.insert(0, carry);
        }
        return new String(sb);
    }

    /**
     * 两数相加，返回字符串形式
     *
     * @param num1 加数1
     * @param num2 加数2
     * @return 返回两数之和
     */
    private String sum(String num1, String num2) {
        int carry = 0;
        int len1 = num1.length();
        int len2 = num2.length();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.max(len1, len2); i++) {
            int char1 = i < len1 ? num1.charAt(len1 - 1 - i) - ZEROCHAR : 0;
            int char2 = i < len2 ? num2.charAt(len2 - 1 - i) - ZEROCHAR : 0;
            int sum = char1 + char2 + carry;
            sb.insert(0, sum % 10);
            carry = sum / 10;
        }
        if (carry > 0) {
            sb.insert(0, carry);
        }
        return new String(sb);
    }
}

class Test {
    public static void main(String[] args) {
        Prob0043Solution sol = new Prob0043Solution();
        String nums1 = "123456789";
        String nums2 = "987654321";
        String multiply = sol.multiply(nums1, nums2);
        System.out.println(multiply);
    }
}
