package leetcode.Prob0003LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;

public class Prob0003Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        //length 为字符串长度，left, right 为窗口的长度，
        int length = s.length();
        int left = 0, right = 0;
        char[] charArray = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>(length);
        int maxLength = 0;

        while (right < length) {
            if (map.containsKey(charArray[right])) {
                int last = map.get(charArray[right]) + 1;
                left = Math.max(last, left);
            }
            map.put(charArray[right], right);
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
}

class Test{
    public static void main(String[] args) {
        String str = "abb";
        Prob0003Solution sol = new Prob0003Solution();
        int i = sol.lengthOfLongestSubstring(str);
        System.out.println(i);

    }
}
