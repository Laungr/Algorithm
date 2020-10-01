package leetcode.Prob0017LetterCombPhoneNum;

import java.awt.image.BandedSampleModel;
import java.util.*;

public class Prob0017Solution {
    public static List<String> letterCombinations(String digits) {
        int N = digits.length();

        List<String> ansList = new ArrayList<>();
        if (digits == "")return ansList;

        int digitArr[] = {2, 3, 4, 5, 6, 7, 8, 9};
        String letterArr[] = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        HashMap<Integer, String> map = new HashMap<>();

        for (int x = 0; x < digitArr.length; x ++) {
            map.put(digitArr[x], letterArr[x]);
        }

        for (int i = 0; i < digits.length(); i++){
            Integer key = Integer.valueOf(digits.substring(i, i+1));
            char[] cs = map.get(key).toCharArray();
            ansList = expand(ansList, cs);
        }
        return ansList;
    }

    public static List<String> expand(List<String> list, char cs[]){
        List<String> ansList = new ArrayList<>();
        if (list.isEmpty()) {
            for (char c : cs) {
                ansList.add(String.valueOf(c));
            }
            return ansList;
        }
        for (int i = 0; i < list.size(); i++) {
            for (char c : cs) {
                ansList.add(list.get(i) + String.valueOf(c));
            }
        }
        return ansList;
    }
}


class Test{
    public static void main(String[] args) {
        String s = "23";

        System.out.println(Prob0017Solution.letterCombinations(s).toString());
    }
}
