package leetcode.Prob0058LengthofLastWord;

/**
 * 给出一字符串，其中包含 words 和空格，即一般意义上的句子，求最后一个单词的长度
 *
 * @author Okaeri *
 */

public class Prob0058Solution {
    public int lengthOfLastWord(String s) {
        String[] s1 = s.split(" ");
        if (s1.length == 0) {
            return 0;
        } else {
            return s1[s1.length - 1].length();
        }
    }
}

class Test {
    public static void main(String[] args) {
        Prob0058Solution sol = new Prob0058Solution();
        String s = "";
        int i = sol.lengthOfLastWord(s);
        System.out.println(i);
    }
}
