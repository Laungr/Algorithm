package leetcode.Prob0067AddBinary;

/**
 * 两个二进制表示的数字，以字符串形式表示，相加之后仍以二进制、字符串形式表示
 *
 * @author Okaeri
 */
public class Prob0067Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        // len 为两字符串长度较大的那个
        int len = Math.max(a.length(), b.length());
        int carry = 0;

        // 遍历字符串，长度较短的那个以 0 代替
        for (int i = 0; i < len; i++) {
            int aCharAt = i < a.length() ? a.charAt(a.length() - 1 - i) - '0' : 0;
            int bCharAt = i < b.length() ? b.charAt(b.length() - 1 - i) - '0' : 0;
            int temp = aCharAt + bCharAt + carry;
            sb.append(temp % 2);
            carry = temp / 2;
        }
        if (carry == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}

class Test {
    public static void main(String[] args) {
        Prob0067Solution sol = new Prob0067Solution();
        String a = "1010";
        String b = "1011";
        String s = sol.addBinary(a, b);
        System.out.println(s);

    }
}
