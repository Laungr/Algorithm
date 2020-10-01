package learn.algrithom.Chapter103;

import java.util.Set;
import java.util.Stack;

public class Exercise134 {
    public static void main(String[] args) {
        String str = "(){}{}[]{。。}[][]";
        System.out.println(parentheses(str));

    }


    public static boolean parentheses(String s){
        boolean flag = true;//标志位，用来返回
        Stack<Character> parenthesesStack = new Stack<>();
        Set<Character> leftParentheses = Set.of('(', '{', '[');//左括号
        Set<Character> rightParentheses = Set.of(')', '}', ']');//右括号


        char[] array = s.toCharArray();
        if (array.length %2 == 1) flag = false;//如果字符串的长度为奇数，那么返回false
        for (char a:array) {
            if (leftParentheses.contains(a)){
                parenthesesStack.push(a);//如果是左括号，入栈
            }
            else if (rightParentheses.contains(a)){
                /*
                右括号，需要和入栈的左括号来匹配
                这个对应关系能不能用图 HashMap 来实现
                */

                if (a == ')')  flag = parenthesesStack.pop()=='(';
                if (a == '}')  flag = parenthesesStack.pop()=='{';
                if (a == ']')  flag = parenthesesStack.pop()=='[';
            }
            else flag = false;//如果字符串的内容包含不是括号的，其实是无关的，不影响括号匹配

            if(!flag) break;//如果有一对匹配不上，就中断循环
        }

        return flag;
    }
}
