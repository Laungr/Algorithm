package leetcode.Prob0028ImplementstrStr;

import java.util.Arrays;

/**
 * KMP 算法实现
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。
 * 如果不存在，则返回  -1 。
 *
 * @author Okaeri
 */
public class Prob0028Solution {
    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        int[] next = nextTable(needle);
        System.out.println(Arrays.toString(next));
        int m = haystack.length();
        int n = needle.length();
        int i = 0;
        int j = 0;
        while (i < m) {
            if (j == n - 1 && needle.charAt(j) == haystack.charAt(i)) {
                return i - n + 1;
            }
            if (j == -1 || needle.charAt(j) == haystack.charAt(i)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        return -1;
    }

    private int[] nextTable(String needle) {
        int len = needle.length();
        int[] prefixTable = new int[len];
        int pre;
        for (int i = 1; i < len; i++) {
            pre = prefixTable[i - 1];
            while (pre > 0 && needle.charAt(pre) != needle.charAt(i)) {
                pre = prefixTable[pre - 1];
            }
            if (needle.charAt(pre) == needle.charAt(i)) {
                pre++;
            }
            prefixTable[i] = pre;
        }
        int[] nextTable = new int[len];
        if (len >= 1) {
            System.arraycopy(prefixTable, 0, nextTable, 1, len - 1);
        }
        nextTable[0] = -1;
        return nextTable;
    }
}

/**
 * 暴力解法
 */
class Prob0028Solution2 {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if (n == 0) {
            return 0;
        }
        int offset = 0;
        for (int i = 0; i <= m - n; i++) {
            if (haystack.charAt(i) == needle.charAt(offset)) {
                offset++;
                while (offset < n) {
                    if (haystack.charAt(i + offset) == needle.charAt(offset)) {
                        offset++;
                    } else {
                        offset = 0;
                        break;
                    }
                }
                if (offset == n) {
                    return i;
                }
            } else {
                offset = 0;
            }
        }
        return -1;
    }
}


/**
 * 这个是自己之前做的解法，确实是简单题看来
 */
class Solution3 {
    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        int hLen = haystack.length();
        int nLen = needle.length();
        for (int i = 0; i <= hLen - nLen; i++) {
            char c = haystack.charAt(i);
            if (c != needle.charAt(0)) {
                continue;
            }
            String s = haystack.substring(i, i + nLen);
            //System.out.println(s);
            if (needle.equals(s)) {
                return i;
            }
        }
        return -1;
    }
}

class Test {
    public static void main(String[] args) {
        String haystack = "aabaaabaaac";
        String needle = "aabaaac";
        // 测试 1
        Prob0028Solution sol = new Prob0028Solution();
        int i = sol.strStr(haystack, needle);
        System.out.println(i);
        // 测试 2
        Prob0028Solution2 sol2 = new Prob0028Solution2();
        System.out.println(sol2.strStr(haystack, needle));

    }
}