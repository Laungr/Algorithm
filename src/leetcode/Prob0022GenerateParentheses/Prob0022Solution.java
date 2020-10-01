package leetcode.Prob0022GenerateParentheses;

import java.util.*;


public class Prob0022Solution {
    public static List<String> generateParenthesis(int n) {

        List<String> ansList = new ArrayList<>();

        Set<String> set = recursionGen(n);
        for (String s : set) {
            ansList.add(s);
        }
        return ansList;
    }
    public static Set<String> recursionGen(int n) {
        Set<String> ansSet = new HashSet<>();
        if (n == 0) {ansSet.add("\"\""); return ansSet;}
        if (n == 1) {
            ansSet.add("()");
            return ansSet;
        }
        else
        return expand(recursionGen(n - 1));
    }

    public static Set<String> expand(Set<String> set) {
        Set<String> ansSet = new HashSet<>();

        for (String s : set) {
            ansSet.add("()" + s);
            ansSet.add(s + "()");
            ansSet.add("(" + s + ")");
        }
        return ansSet;
    }
}

class Test{
    public static void main(String[] args) {
        System.out.println(Prob0022Solution.generateParenthesis(5).toString());
    }
}