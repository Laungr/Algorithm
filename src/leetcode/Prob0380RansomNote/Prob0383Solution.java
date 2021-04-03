package leetcode.Prob0380RansomNote;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Prob0383Solution {
    public boolean canConstrute(String ransomNote, String magazine){
        int ransomLen = ransomNote.length();
        int magLen = magazine.length();
        if (magLen < ransomLen){
            return false;
        }

        //将两个字符串的字符数组，放进 HashMap中，key 为字符，value 为个数
        HashMap<Character, Integer> ransomMap = new HashMap<>();
        HashMap<Character, Integer> magMap = new HashMap<>();

        for (int i = 0; i < magLen; i++) {
            char magChar = magazine.charAt(i);
            if (i >= ransomLen){
                magMap.put(magChar, magMap.getOrDefault(magChar, 0) + 1);
            }
            else {
                char ranChar = ransomNote.charAt(i);
                ransomMap.put(ranChar, ransomMap.getOrDefault(ranChar, 0) + 1);
                magMap.put(magChar, magMap.getOrDefault(magChar, 0) + 1);
            }
        }
        boolean res = true;
        //遍历 ransomNote 字符串的 HashMap，看两个 Map 中的字符个数
        Set<Character> characters = ransomMap.keySet();
        for (Character c : characters) {
            // 需要判断 containsKey()，否则会有空指针异常抛出
            res = res && magMap.containsKey(c) && magMap.get(c) >= ransomMap.get(c);
        }
        return res;
    }
}

class Test{
    public static void main(String[] args) {
        Prob0383Solution sol = new Prob0383Solution();
        String ran ="a";
        String mag = "a";
        System.out.println(sol.canConstrute(ran, mag));
    }
}
