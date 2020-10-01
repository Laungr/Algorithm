package leetcode.Prob0020ValidParentheses;

import java.util.*;

public class Prob0020Solution {
    public boolean isValid(String s) {
        boolean ans = true;
        Set<Character> bracketsSet = new HashSet<>();
        Set<Character> leftBracketSet = new HashSet<>();
        Set<Character> righrBracketSet = new HashSet<>();
        String bracketsStr = "([{}])";
        for (int i = 0; i < bracketsStr.length(); i++) {
            bracketsSet.add(bracketsStr.charAt(i));
            if (i /(bracketsStr.length()/2) == 0) leftBracketSet.add(bracketsStr.charAt(i));
            if(i / (bracketsStr.length()/2) > 0) righrBracketSet.add(bracketsStr.charAt(i));

        }

        Stack<Character> bracketParenthese = new Stack<>();

        char[] charArray = s.toCharArray();

        for (int i = 0; ans && i < charArray.length; i++) {
            char c = charArray[i];
            if (!bracketsSet.contains(c)) return false;
            else if (leftBracketSet.contains(c)) bracketParenthese.push(c);
            else if (righrBracketSet.contains(c)){
                if (bracketParenthese.isEmpty()) return false;
                if (c == ')') ans =  bracketParenthese.pop() == '(';
                if (c == ']') ans = bracketParenthese.pop() == '[';
                if (c == '}') ans =  bracketParenthese.pop() == '{';
            }
        }
        return ans;
    }
}

class Prob0020Solution2 {
    public boolean isValid(String s) {
        boolean ans = true;
        Stack<Character> parenthese = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{') parenthese.push('}');
            else if (s.charAt(i) == '[') parenthese.push(']');
            else if (s.charAt(i) == '(') parenthese.push(')');
            else if (!parenthese.isEmpty()) ans = s.charAt(i) == parenthese.pop();
            else return false;
        }
        return ans && parenthese.isEmpty();
    }
}