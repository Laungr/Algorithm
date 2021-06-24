package learn.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/**
 * 中缀表达式 的计算
 *
 * @author Okaeri
 */
public class InfixNotationCalculation {
    public int infixNotationCalculation(String s) {
        // 维护一个运算符优先级的 map，方便查询
        HashMap<Character, Integer> priorityMap = new HashMap<>(16);
        priorityMap.put('+', 1);
        priorityMap.put('-', 1);
        priorityMap.put('*', 2);
        priorityMap.put('/', 2);
        priorityMap.put('%', 2);
        priorityMap.put('^', 1);
        // 创建两个栈，一个用来存放操作符号，一个用来存放数字
        // 所有的数字都是正数
        Deque<Integer> numbers = new ArrayDeque<>(s.length());
        Deque<Character> operator = new ArrayDeque<>(s.length());
        // 用来存放数字
        int num = 0;
        // 先删除表达式中的空格
        s = s.replaceAll(" ", "");
        //在数组后面价格终止符，用来提取最后一个数字
        s = s + "#";
        // 从左往右遍历，如果是加减法则运算符进栈，如果是乘除法，就直接计算，如果是数字就直接进栈，空格直接跳过
        for (int i = 0; i < s.length(); i++) {
            char aChar = s.charAt(i);
            //  如果是 #，把数字加入栈，直接退出
            if (aChar == '#') {
                numbers.push(num);
                break;
            }
            // 如果 aChar 是数字就计算数字
            if (Character.isDigit(aChar)) {
                num = num * 10 + (aChar - '0');
            }
            // 如果 aChar 是 '('，直接入栈
            else {
                numbers.push(num);
                num = 0;
                if (aChar == '(') {
                    operator.push(aChar);
                }
                // 如果 aChar 是 ')' 从 operator 中弹出，直到遇到 '('
                else if (aChar == ')') {
                    while (!operator.isEmpty()) {
                        if (operator.peek() == '(') {
                            operator.pop();
                            break;
                        } else {
                            calculate(operator, numbers);
                        }
                    }
                }
                // 不是数字，不是括弧，就是运算符了
                else {
                    while (!operator.isEmpty()) {
                        char op = operator.peek();
                        if (priorityMap.get(op) > priorityMap.get(aChar)) {
                            calculate(operator, numbers);
                        } else {
                            break;
                        }
                    }
                    operator.push(aChar);
                }
            }
        }
        while (!operator.isEmpty()) {
            calculate(operator, numbers);
        }

        int res = 0;
        try {
            res = numbers.peek();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return res;
    }

    private void calculate(Deque<Character> operator, Deque<Integer> numbers) {
        if (operator.isEmpty() || numbers.isEmpty() || numbers.size() < 2) {
            return;
        }
        char op = operator.pop();
        int num2 = numbers.pop();
        int num1 = numbers.pop();
        if (op == '+') {
            numbers.push(num1 + num2);
        } else if (op == '-') {
            numbers.push(num1 - num2);
        } else if (op == '*') {
            numbers.push(num1 * num2);
        } else if (op == '/') {
            numbers.push(num1 / num2);
        } else if (op == '%') {
            numbers.push(num1 % num2);
        } else {
            numbers.push((int) Math.pow(num1, num2));
        }
    }
}

class Test {
    public static void main(String[] args) {
        InfixNotationCalculation sol = new InfixNotationCalculation();
        String s = " 3/2 ";
        int i = sol.infixNotationCalculation(s);
        System.out.println(i);
    }
}