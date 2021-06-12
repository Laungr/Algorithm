package leetcode.Prob0451SortCharactersByFrequency;

import java.util.*;

/**
 *
 */
public class Prob00451Solution {
    public String frequencySort(String s) {
        // 创建一个哈希表，key 是每个字符，value 是每个字符出现的次数，进而转化成拼成的字符串
        HashMap<Character, String> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            map.put(aChar, map.getOrDefault(aChar, "") + aChar);
        }
        // 把上面 map 的 values 转化成为一个 list，然后给 list排序，排序的依据是内容字符串的长度
        // 这样写是会报错的，map.values() 不能强转成 List。List<String> values = (List<String>) map.values();
       List<String> values = new ArrayList<>(map.values());
        values.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        // 最后依次序拼接起来返回
        StringBuilder sb = new StringBuilder();
        for (String value : values) {
            sb.append(value);
        }
        return sb.reverse().toString();
    }
}

class Test {
    public static void main(String[] args) {
        Prob00451Solution sol = new Prob00451Solution();
        String s = "AabbCC";
        String frequencySort = sol.frequencySort(s);
        System.out.println(frequencySort);
    }
}