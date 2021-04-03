package leetcode.Prob0014LongestCommonProfix;

public class Prob0014Solution {
    public static String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) {
            return "";
        }

        int shortestStrLen = getShorestStrLen(strs);
        int longestCommonProfix;
        boolean flag = true;

        //最短字符串长为0，则返回""
        if (shortestStrLen == 0) {
            return "";
        }
        for (longestCommonProfix = 0; flag && longestCommonProfix < shortestStrLen; longestCommonProfix++) {
            int strsIndex;
            for (strsIndex = 0; strsIndex < strs.length; strsIndex++) {
                if (strs[0].charAt(longestCommonProfix) != strs[strsIndex].charAt(longestCommonProfix)) {
                    flag = false;
                    longestCommonProfix--;
                    break;
                }
            }
        }


        return strs[0].substring(0, longestCommonProfix - 1);
    }

    public static int getShorestStrLen(String[] strs) {
        //字符串数组的长度
        int N = strs.length;
        if (N == 0) {
            return 0;
        }

        //求出最短字符串的长度
        int shortestStrLen = strs[0].length();
        for (int i = 1; i < N; i++) {
            shortestStrLen = Math.min(shortestStrLen, strs[i].length());
        }
        return shortestStrLen;
    }

}

class Test {
    public static void main(String[] args) {
        String[] str = {};
        String[] str1 = {"flower", "flow", "flight"};
        String[] str2 = {"a", "a"};
        System.out.println(Prob0014Solution.longestCommonPrefix(str));
        Prob0014Solution2 sol = new Prob0014Solution2();
        System.out.println(sol.longestCommonPrefix(str2));
    }
}

/**
 * 求最长公共前缀
 */

class Prob0014Solution2 {
    public String longestCommonPrefix(String[] strs) {
        //字符串数组的长度,如果长度为0，返回空串
        int len = strs.length;

        //定义一个字符串的最大，最小长度
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            minLen = Math.min(minLen, str.length());
        }
        //两种特殊情况
        if (len == 0 || minLen == 0) {
            return "";
        }
        String res = strs[0];

        for (int i = 0; i < minLen; i++) {
            char c = strs[0].charAt(i);
            //res 此时已经包含了第 i 个个字符
            res = strs[0].substring(0, i+1);
            for (String str : strs) {
                // 如果第 i 个字符不一直，将其去掉
                if (c != str.charAt(i)) {
                    return res.substring(0, i);
                }
            }
        }
        return res;
    }
}

