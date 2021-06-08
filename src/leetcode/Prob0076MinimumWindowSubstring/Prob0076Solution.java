package leetcode.Prob0076MinimumWindowSubstring;

import java.util.HashMap;

/**
 * 题目描述：
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * 1 <= s.length, t.length <= 10^5
 *
 * @author Okaeri
 */
public class Prob0076Solution {
    public String minWindow(String s, String t) {
        //将 s, t 转化为字符数组，并存储进 HashMap中，其中 key 为字符，value 为字符出现的次数
        char[] sourceCharArray = s.toCharArray();
        char[] targetCharArray = t.toCharArray();
        HashMap<Character, Integer> windowMap = new HashMap<>(s.length());
        HashMap<Character, Integer> targetMap = new HashMap<>(t.length());
        for (int i = 0; i < t.length(); i++) {
            //c 是在 i 处的字符，count 用来判断该字符是否存在于 map 中，如果存在返回 value，如果不存在返回 0
            char c = targetCharArray[i];
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        //定义左右指针
        int left = 0, right = 0;
        int valid = 0;
        String result = "";

        while (right < s.length()) {
            // 取出 charAtRight，然后指针右移
            char charAtRight = sourceCharArray[right++];
            //如果字符是 target 中需要的，把它加进 windowMap中
            if (targetMap.containsKey(charAtRight)) {
                //如果字符在 windowMap 中出现的次数是小于 targetMap 中的，那么这次出现算是一次有效的出现，大于等于的情况都是无效的
                if (windowMap.get(charAtRight)== null || windowMap.get(charAtRight) < targetMap.get(charAtRight)) {
                    valid++;
                }
                windowMap.put(charAtRight, 1 + (windowMap.getOrDefault(charAtRight, 0)));
                //当有效次数 valid 等于 t 的长度，就说明一个有效的子串出现了
                //有效子串出现时，需要停止 right 右移，开始将 left 右移，缩小窗口
                while (valid == t.length()) {
                    String tmp = s.substring(left, right);
                    if ("".equals(result)){
                        result = tmp;
                    }
                    result = result.length() > tmp.length() ? tmp : result;
                    char charAtLeft = sourceCharArray[left];
                    left++;
                    if (targetMap.containsKey(charAtLeft)) {
                        if (windowMap.get(charAtLeft).equals(targetMap.get(charAtLeft))) {
                            valid--;
                        }
                        windowMap.put(charAtLeft, windowMap.get(charAtLeft) - 1);
                    }
                }
            }
            //如果字符不是 target 中需要的，则窗口往右移动
        }
        return result;
    }
}

class Test {
    public static void main(String[] args) {
        Prob0076Solution sol = new Prob0076Solution();
        String s = "A";
        String t = "AB";
        System.out.println(sol.minWindow(s, t));
    }
}
