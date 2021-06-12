package leetcode.Prob0227BasicCalculatorII;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 计算中缀表达式
 *
 * @author Okaeri
 */
public class Prob0227Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        char preSign = '+';
        int num = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        stack.push(stack.pop() / num);
                }
                preSign = s.charAt(i);
                num = 0;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}

    class Test {
        public static void main(String[] args) {
            Prob0227Solution sol = new Prob0227Solution();
            String s = " 1-1+1 ";
            int calculate = sol.calculate(s);
            System.out.println(calculate);

        }
    }