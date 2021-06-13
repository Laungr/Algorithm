package leetcode.Prob0151ReverseWordsinaString;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出一个句子，将里面的单词不变，单词出现的顺序反转，并删除多余的空格
 *
 * @author Okaeri
 */
public class Prob0151Solution {
    public String reverseWords(String s) {
        s = s + " ";
        List<StringBuilder> list = new ArrayList<>();
        // 中间暂存的临时 sb
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 如果是空格，那么去判断当前 sb 是不是空，sb 不为空就是一个单词
            if (c == ' ') {
                if (sb.length() != 0) {
                    list.add(new StringBuilder(sb));
                    sb.delete(0, sb.length());
                }
            }
            // 不是空格就加入 sb 中
            else {
                sb.append(c);
            }
        }
        // 列表反向遍历贴进去
        StringBuilder res = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            res.append(list.get(i)).append(" ");
        }
        // 最后删除末尾的空格
        return res.deleteCharAt(res.length() - 1).toString();
    }
}

class Test {
    public static void main(String[] args) {
        String s = "Alice does not even like bob";
        Prob0151Solution sol = new Prob0151Solution();
        String reverseWords = sol.reverseWords(s);
        System.out.println(reverseWords);
    }
}
