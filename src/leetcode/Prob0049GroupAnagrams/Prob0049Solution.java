package leetcode.Prob0049GroupAnagrams;

import java.util.*;

/**
 * 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 把每个字符串中的字符数量记录下来，放进 HashMap 中作为 key，value 是一个 List，key 相同的话就加入到 list 中
 *
 * @author Okaeri
 */
public class Prob0049Solution {
    public List<List<String>> groupAnagrams(String[] strs){
        int arrayLen = strs.length;
        HashMap<String, List<String>> map = new HashMap<>(arrayLen);
        List<List<String>> result = new ArrayList<>();
        for (String str : strs) {
            int strLen = str.length();
            int[] array = new int[26];
            // 遍历字符串，每个字符及其个数放进数组中
            for (int i = 0; i < strLen; i++) {
                int charAt = str.charAt(i) -'a';
                array[charAt]++;
            }
            //把数组转化成字符串作为哈希表的 key
            String s = Arrays.toString(array);
            List<String> list = map.getOrDefault(s, new ArrayList<>());
            list.add(str);
            map.put(s, list);

        }

        // 遍历的代码等同于这一句
        // result = (List<List<String>>) map.values();
        Set<String> set = map.keySet();
        for (String integers : set) {
            result.add(map.get(integers));
        }
        return result;
    }
}

class Test{
    public static void main(String[] args) {
        Prob0049Solution sol = new Prob0049Solution();
        String[] strs = {"eat","tea","tan","ate","nat","bat", "",""};
        List<List<String>> lists = sol.groupAnagrams(strs);
        System.out.println(lists.toString());
    }
}
