package leetcode.Prob0387FirstUniqueCharacterinaString;

import java.util.HashMap;

/**
 * 给出一个字符串，找出第一个没有重复出现的字符的下标，如果每个字符都出现了，返回 -1
 * 两次遍历，第一次遍历计算每个字符出现的次数，第二次遍历找出最先出现次数为 1 的字符
 *
 * @author Okaeri
 */
public class Prob0387Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>(s.length());
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            map.put(aChar, map.getOrDefault(aChar, 0) + 1);
        }
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == 1) {
                return i;
            }
        }
        return -1;
    }
}

