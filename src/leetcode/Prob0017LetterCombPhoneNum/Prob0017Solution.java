package leetcode.Prob0017LetterCombPhoneNum;

import java.util.*;

public class Prob0017Solution {
    public static List<String> letterCombinations(String digits) {

        List<String> ansList = new ArrayList<>();
        if ("".equals(digits))return ansList;

//        int[] digitArr= {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        String[] letterArr= {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
//        HashMap<Integer, String> map = new HashMap<>();
//
//        for (int x = 0; x < digitArr.length; x ++) {
//            map.put(digitArr[x], letterArr[x]);
//        }

        for (int i = 0; i < digits.length(); i++){
            int key = Integer.parseInt(digits.substring(i, i+1));
            char[] cs = letterArr[key].toCharArray();
            ansList = expand(ansList, cs);
        }
        return ansList;
    }

    public static List<String> expand(List<String> list, char[] cs){
        List<String> ansList = new ArrayList<>();
        if (list.isEmpty()) {
            for (char c : cs) {
                ansList.add(String.valueOf(c));
            }
            return ansList;
        }
        for (String s : list) {
            for (char c : cs) {
                ansList.add(s + c);
            }
        }
        return ansList;
    }
}

/**
 * 回溯算法
 */

class Prob0017Solution2{
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.equals("")) return result;

        String[] digitArr =  {"2", "3", "4", "5", "6", "7", "8", "9"};
        String[] letterArr = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        HashMap<String, String> map = new HashMap<>();

        for (int x = 0; x < digitArr.length; x ++) {
            map.put(digitArr[x], letterArr[x]);
        }

        backTrack(digits, result, map, 0, new StringBuffer());

        return result;
    }

    private static void backTrack(String digits, List<String> result, Map<String, String>map, int curr, StringBuffer sb) {
        //
        if (digits.length() == curr) {
            result.add(sb.toString());
            return;
        }
        String currDigit = digits.substring(curr, curr + 1);
        String currLetter = map.get(currDigit);
        for (int i = 0; i < currLetter.length(); i++) {
            sb.append(currLetter.charAt(i));
            backTrack(digits, result, map, curr+1, sb);
            sb.deleteCharAt(curr);
        }
    }

}


class Test{
    public static void main(String[] args) {
        String s = "23";

        System.out.println(Prob0017Solution2.letterCombinations(s).toString());
    }
}
