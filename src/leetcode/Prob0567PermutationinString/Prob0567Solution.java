package leetcode.Prob0567PermutationinString;

import java.util.HashMap;

public class Prob0567Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() > s2.length()) {
            return false;
        }

        //将 s1, s2 转化为字符数组，并存储进 HashMap中，其中 key 为字符，value 为字符出现的次数
        char[] sourceCharArray = s2.toCharArray();
        char[] targetCharArray = s1.toCharArray();
        HashMap<Character, Integer> windowMap = new HashMap<>(s2.length());
        HashMap<Character, Integer> targetMap = new HashMap<>(s1.length());
        for (int i = 0; i < s1.length(); i++) {
            //c 是在 i 处的字符，count 用来判断该字符是否存在于 map 中，如果存在返回 value，如果不存在返回 0
            char c = targetCharArray[i];
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        //定义左右指针
        int left = 0;
        int right = 0;

        while (right < s1.length()) {
            char charAtRight = sourceCharArray[right++];
            //如果字符是 target 中需要的，把它加进 windowMap中
            if (targetMap.containsKey(charAtRight)) {
                //如果字符在 windowMap 中出现的次数是小于 targetMap 中的，那么这次出现算是一次有效的出现，大于等于的情况都是无效的
                windowMap.put(charAtRight, 1 + (windowMap.getOrDefault(charAtRight, 0)));
                if (windowMap.equals(targetMap)) {
                    return true;
                }
            }
        }
        while (right < s2.length()) {
            char charAtRight = sourceCharArray[right++];
            char charAtLeft = sourceCharArray[left++];
            //如果字符是 target 中需要的，把它加进 windowMap中
            if (targetMap.containsKey(charAtRight)) {
                //如果字符在 windowMap 中出现的次数是小于 targetMap 中的，那么这次出现算是一次有效的出现，大于等于的情况都是无效的
                windowMap.put(charAtRight, 1 + (windowMap.getOrDefault(charAtRight, 0)));
            }
            if (targetMap.containsKey(charAtLeft)) {
                windowMap.put(charAtLeft, windowMap.get(charAtLeft) - 1);
            }
            if (windowMap.equals(targetMap)) {
                return true;
            }

        }
        return false;
    }
}

class Test {
    public static void main(String[] args) {
        Prob0567Solution sol = new Prob0567Solution();
        String s1 = "adc";
        String s2 = "ddca";
        System.out.println(sol.checkInclusion(s1, s2));
    }
}
