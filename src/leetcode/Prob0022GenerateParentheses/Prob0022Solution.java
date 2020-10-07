package leetcode.Prob0022GenerateParentheses;

import java.util.*;


public class Prob0022Solution {
    public static List<String> generateParenthesis(int n) {
        Set<String> result = new HashSet<>();

        generateParenthesis(result, "", "(", n, 0, 0);

        return new ArrayList<>(result);
    }

    public static void generateParenthesis(Set<String> list, String subList, String subString, int n, int left, int right){
        if (left == n && right == n){
            list.add(subList);
        }
        if (left < right || left > n || right > n){
            return;
        }

        subList += subString;

        if ("(".equals(subString)) {
            left++;
        } else {
            right++;
        }

        generateParenthesis(list, subList, "(", n, left, right);
        generateParenthesis(list, subList, ")", n, left, right);

    }


}

class Test{
    public static void main(String[] args) {
        System.out.println(Prob0022Solution.generateParenthesis(5).toString());
    }
}