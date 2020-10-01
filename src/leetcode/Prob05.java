package leetcode;

/**
 * 最长回文字符串
 *
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: "cbbd"
 * Output: "bb"
 */

public class Prob05 {
    public static void main(String[] args) {
        String s1 = "cbba";
        String s2 = "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
        System.out.println(s2.length()+ " "+Solution2.longestPalindrome(s2));
    }
}

class Solution1{
    public static String longestPalindrome(String s) {
        int N = s.length();
        char[] charArray = s.toCharArray();
        String longestStr = "";
        if (N>0) longestStr = String.valueOf(charArray[0]);
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (isPalindrome(charArray, i, j)&&(j-i)>=longestStr.length()){
                    if(j == N-1) longestStr = s.substring(i);
                    else longestStr = s.substring(i, j+1);
                }
            }
        }

        return longestStr;
    }


    public static boolean isPalindrome(char[] charArray, int left, int right){
        for (int i = 0; i <= (right - left) / 2; i++) {
            if (!(charArray[left + i] == charArray[right - i])) return false;
        }
        return true;
    }
}

class Solution2{
    public static String longestPalindrome(String s) {
        int N = s.length();
        String longestStr = "";
        if (N > 0) longestStr = s.substring(0, 1);
        int i = 1, j = 0;
        while (j < N-1){
            String str1 = "";
            if (j-i>=0 &&j+i<= N-1&&(s.charAt(j-i) == s.charAt(j+i) || s.charAt(j-i+1) == s.charAt(j+i))) {
                //String str1 = "";
                if(s.charAt(j-i) == s.charAt(j+i))                str1 = s.substring(j-i, j+i+1);
                else str1 = s.substring(j-i,j+i);
                longestStr = longestStr.length()>str1.length()?longestStr:str1;
                i++;
            }
            else j++;
        }
        return longestStr;
    }
}
