package leetcode.Prob0392IsSubsequence;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给出两个字符串，s 和 t，判断 s 是 t 的子序列
 *
 * @author Okaeri
 */
public class Prob0392Solution {
    public boolean IsSubsequence(String s, String t) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            stack.push(s.charAt(i));
        }
        for (char c : t.toCharArray()) {
            if (stack.isEmpty()) {
                return true;
            } else if (c == stack.peek()) {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
