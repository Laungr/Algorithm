package leetcode.Prob0014LongestCommonProfix;

public class Prob0014Solution {
    public static String longestCommonPrefix(String[] strs){

        if (strs.length == 0) return "";

        int shortestStrLen = getShorestStrLen(strs);
        int longestCommonProfix ;
        boolean flag = true;

        //最短字符串长为0，则返回""
        if (shortestStrLen == 0) return "";
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


        return strs[0].substring(0, longestCommonProfix-1);
    }

    public static int getShorestStrLen(String[] strs){
        //字符串数组的长度
        int N = strs.length;
        if (N == 0) return 0;

        //求出最短字符串的长度
        int shortestStrLen = strs[0].length();
        for (int i = 1; i < N; i++) {
            shortestStrLen = Math.min(shortestStrLen, strs[i].length());
        }
        return shortestStrLen;
    }

}

class Test{
    public static void main(String[] args) {
        String str[] = {};
        System.out.println(Prob0014Solution.longestCommonPrefix(str));
    }
}
