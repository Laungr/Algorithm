package leetcode.Prob0150EvaluateReversePolishNotation;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

/**
 * 逆波兰表达式求值
 * 有效的算符包括 +、-、*、/
 *
 * @author Okaeri
 */
public class Prob0150Solution {
    public int evalRPN(String[] tokens) {
        HashSet<String> operatorSet = new HashSet<>(4);
        operatorSet.add("+");
        operatorSet.add("-");
        operatorSet.add("*");
        operatorSet.add("/");

        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            // token是运算符
            if (operatorSet.contains(token)) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                if ("+".equals(token)) {
                    stack.push(num1 + num2);
                } else if ("-".equals(token)) {
                    stack.push(num1 - num2);
                } else if ("*".equals(token)) {
                    stack.push(num1 * num2);
                } else if ("/".equals(token)) {
                    stack.push(num1 / num2);
                }

            }
            // token 是数字
            else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }
}

class Test {
    public static void main(String[] args) {
        Prob0150Solution sol = new Prob0150Solution();
        String[] tokens = {"2", "1", "+", "3", "*"};
        String[] tokens2 = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        int i = sol.evalRPN(tokens2);
        System.out.println(i);
    }

}
