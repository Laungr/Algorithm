package learn.algrithom.Chapter103;

import java.util.Set;
import java.util.Stack;

public class Exercise139 {

    public static String autoComplete(String s){
        char[] array = s.toCharArray();
        Stack<Character> opsStack = new Stack<>();
        Stack<Character> numsStack = new Stack<>();
        Set.of('+', '-', '*', '/');
        for (char c:array) {
            if (opsStack.contains(c)){
                opsStack.push(c);
            }

            else if(c == ')'){
                char op = opsStack.pop();
                opsStack.push('(');
                opsStack.push(op);
                opsStack.push(')');


            }
        }
        return s;
    }
}
