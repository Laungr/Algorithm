package leetcode.Prob0076MinimumWindowSubstring;

import java.util.HashMap;
import java.util.Set;

/**
 * 一个比较直接的思路，看了答案解析之后发现还是要更妙一些。
 *
 * @author Okaeri
 */
public class Prob0076Solution2 {
    public String minWindow(String s, String t) {
        // 如果 s 的长度比较小那么返回空串
        if (s.length() < t.length()) {
            return "";
        }
        // 两个HashMap 快速获取子串中每个字符的个数
        HashMap<Character, Integer> window = new HashMap<>(s.length());
        HashMap<Character, Integer> target = new HashMap<>(t.length());
        // 最终返回的结果
        int resultLen = s.length();
        String result = "";
        // 将目标字符串的所有字符添加进 HashMap 中，key 是字符，value 是字符的数量
        for (int i = 0; i < t.length(); i++) {
            target.put(t.charAt(i), target.getOrDefault(t.charAt(i), 0) + 1);
        }
        // left, right 双指针
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char charAtRight = s.charAt(right);
            window.put(charAtRight, window.getOrDefault(charAtRight, 0) + 1);
            while (left <= right && isValid(window, target)) {
                if (right - left + 1 <= resultLen) {
                    resultLen = right - left + 1;
                    result = s.substring(left, right + 1);
                }
                char charAtLeft = s.charAt(left);
                window.put(charAtLeft, window.get(charAtLeft) - 1);
                left++;
            }
        }
        return result;
    }

    private boolean isValid(HashMap<Character, Integer> window, HashMap<Character, Integer> target) {
        // key 的个数
        int windowSize = window.size();
        int targetSize = target.size();

        if (windowSize < targetSize) {
            return false;
        }
        Set<Character> characters = target.keySet();
        for (Character character : characters) {
            if (target.get(character) > window.getOrDefault(character, 0)) {
                return false;
            }
        }
        return true;
    }
}

class Test2 {
    public static void main(String[] args) {
        Prob0076Solution2 sol = new Prob0076Solution2();
        String s = "ADOBECODEBANCACB";
        String t = "ABC";
        String minWindow = sol.minWindow(s, t);
        System.out.println(minWindow);
    }
}
