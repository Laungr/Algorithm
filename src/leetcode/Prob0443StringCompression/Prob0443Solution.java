package leetcode.Prob0443StringCompression;

import java.util.Arrays;

/**
 * 字符串的压缩，如果一个字符串中包含多个相同的字符，那么只保留一个该字符，然后后面跟上字符出现的次数。
 * 返回值是有效字符的个数，要求原地算法，
 *
 * @author Okaeri
 */
public class Prob0443Solution {
    public int compress(char[] chars) {
        // 如果字符串的长度是小于 3 的，即 1 或者 2，直接返回即可
        if (chars.length < 2) {
            return chars.length;
        }
        int index = -1;
        int left = 0;
        int right = 0;
        while (right < chars.length) {
            // 如果是字符一样，右指针右移，然后出现的字数加 1
            if (chars[left] == chars[right]) {
                right++;
            }
            // 遇到了和 chars[index] 不相等的位置
            else {
                // count 是相同字符出现的次数
                int count = right - left;
                chars[++index] = chars[left];
                if (count > 1) {
                    String s = String.valueOf(count);
                    for (int i = 0; i < s.length(); i++) {
                        chars[++index] = s.charAt(i);
                    }
                }
                left = right;
            }
        }
        int count = right - left;
        chars[++index] = chars[left];
        if (count > 1) {
            String s = String.valueOf(count);
            for (int i = 0; i < s.length(); i++) {
                chars[++index] = s.charAt(i);
            }
        }
        System.out.println(Arrays.toString(chars));
        return index + 1;
    }
}

class Test {
    public static void main(String[] args) {
        Prob0443Solution sol = new Prob0443Solution();
        char[] chars = {'a', 'a'};
        int compress = sol.compress(chars);
        System.out.println(compress);

    }
}
