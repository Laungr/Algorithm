package leetcode.Prob0017LetterCombPhoneNum;

import java.util.*;

/**
 * 电话号码的字母组合
 *
 * @author Okaeri
 */

public class Prob0017Solution {
    public static List<String> letterCombinations(String digits) {

        List<String> ansList = new ArrayList<>();
        if ("".equals(digits)) {
            return ansList;
        }

        String[] letterArr = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for (int i = 0; i < digits.length(); i++) {
            int key = Integer.parseInt(digits.substring(i, i + 1));
            char[] cs = letterArr[key].toCharArray();
            ansList = expand(ansList, cs);
        }
        return ansList;
    }

    public static List<String> expand(List<String> list, char[] cs) {
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

class Prob0017Solution2 {
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if ("".equals(digits)) {
            return result;
        }
        // map 是 digit 对应的 字符
        String[] digitArr = {"2", "3", "4", "5", "6", "7", "8", "9"};
        String[] letterArr = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        HashMap<String, String> map = new HashMap<>(16);
        for (int x = 0; x < digitArr.length; x++) {
            map.put(digitArr[x], letterArr[x]);
        }
        // 调用回溯
        backTrack(digits, result, map, 0, new StringBuffer());
        return result;
    }

    private static void backTrack(String digits, List<String> result, Map<String, String> map, int curr, StringBuffer sb) {
        // 递归出口
        if (digits.length() == curr) {
            result.add(sb.toString());
            return;
        }
        String currDigit = digits.substring(curr, curr + 1);
        String currLetter = map.get(currDigit);
        for (int i = 0; i < currLetter.length(); i++) {
            sb.append(currLetter.charAt(i));
            backTrack(digits, result, map, curr + 1, sb);
            sb.deleteCharAt(curr);
        }
    }

}


class Test {
    public static void main(String[] args) {
        String s = "23";
        System.out.println(Prob0017Solution2.letterCombinations(s));

        DfsSolution sol = new DfsSolution();
        List<String> list = sol.letterCombinations(s);
        System.out.println(list.toString());
    }
}

/**
 * 全排列问题的变种
 */
class DfsSolution {
    private final char[][] keyboard = {{}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'},
            {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        dfs(res, new StringBuilder(), digits, 0);
        return res;
    }

    private void dfs(List<String> res, StringBuilder sb, String digits, int index) {
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }
        int digit = digits.charAt(index) - '0';
        for (int j = 0; j < keyboard[digit].length; j++) {
            sb.append(keyboard[digit][j]);
            dfs(res, sb, digits, index + 1);
            sb.deleteCharAt(index);
        }
    }
}