package leetcode.Prob0394DecodeString;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 字符串解码
 *
 * @author Okaeri
 */
public class Prob0394Solution {
    public String decodeString(String s) {
        Deque<StringBuilder> stack = new ArrayDeque<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            StringBuilder sb = new StringBuilder();
            char charAt = s.charAt(i);
            // 是字母，就取出这段字母
            if (Character.isLetter(charAt)) {
                int j = i;
                while (j >= 0 && Character.isLetter(s.charAt(j))) {
                    sb.append(s.charAt(j));
                    j--;
                }
                stack.push(new StringBuilder().append(sb.reverse()));
                sb.delete(0, sb.length());
                i = j + 1;
            }
            // 是数字，取出数字，并进行计算，然后压入栈中
            else if (Character.isDigit(charAt)) {
                // 取数字的方式和取字符一样
                int j = i;
                while (j >= 0 && Character.isDigit(s.charAt(j))) {
                    sb.append(s.charAt(j));
                    j--;
                }
                int num = Integer.parseInt(sb.reverse().toString());
                i = j + 1;
                sb.delete(0, sb.length());
                // 取完之后开始计算
                // '['
                stack.pop();
                // 字符串
                StringBuilder add = new StringBuilder();
                while (!stack.isEmpty() && !"]".contentEquals(stack.peek())) {
                    add.append(stack.pop());
                }
                stack.pop();
                for (int k = 0; k < num; k++) {
                    sb.append(add);
                }
                stack.push(new StringBuilder().append(sb));
                sb.delete(0, sb.length());
            }
            // ']' 是有用的，'[' 可以直接忽略，因为它总是伴随着数字出现的
            else if (charAt == ']' || charAt == '[') {
                stack.push(new StringBuilder().append(charAt));
            }
        }
        // 把栈里面的所有字符串弹出来拼在一起，返回结果
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.toString();
    }
}

class Test {
    public static void main(String[] args) {
        Prob0394Solution sol = new Prob0394Solution();
        String s = "3[a]2[bc]";
        System.out.println(sol.decodeString(s));
    }
}