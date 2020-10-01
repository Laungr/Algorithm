package leetcode.Prob0008StringToInteger;

import java.util.HashSet;

class Prob0008Solution {
    public static int myAtoi(String str) {
        int signal = 1;
        String ansStr = "";
        final long INT_MAX = 2147483647L;
        final long INT_MIN = -2147483648L;
        int ans = 0;
        //使用两个标志位来判定后续是否可以出现符号和空格
        boolean signFlag = true;
        boolean spaceFlag = true;

        //把允许在string中出现的字符写在HashSet中
        String digitStr = " -+0123456789";
        HashSet<Character> digitSet = new HashSet<>();
        for (int i = 0; i < digitStr.length(); i++) {
            digitSet.add(digitStr.charAt(i));
        }

        //判断两种特殊情况，字符串为空和首字符不在HashSet中
        if (str.length() == 0) return 0;
        else if (!digitSet.contains(str.charAt(0))) return 0;


        for (int i = 0; i < str.length(); i++) {
            if (!digitSet.contains(str.charAt(i))) break;
            else if (str.charAt(i) == '+') {
                if (signFlag) {
                    spaceFlag = false;
                    signFlag = false;
                } else break;
            } else if (str.charAt(i) == ' ') {
                if (spaceFlag) continue;
                else break;
            } else if (str.charAt(i) == '-') {
                if (signFlag) {
                    spaceFlag = false;
                    signFlag = false;
                    signal = -1;
                } else break;
            } else {
                signFlag = false;
                spaceFlag = false;
                ansStr += str.charAt(i);
            }
        }
        //System.out.println(flag);

        System.out.println(ansStr);
        try {
            ans = Integer.valueOf(ansStr) * signal;
        } catch (NumberFormatException e) {
            if (ansStr == "") ans = 0;
            else if (signal > 0) ans = (int) INT_MAX;
            else ans = (int) INT_MIN;
        }

        return ans;
    }

}

class Test{
    public static void main(String[] args) {

        String s = " -1  012";
        int x ;
        x = Prob0008Solution.myAtoi(s);
        //System.out.print(Math.pow(2, 31) );
        System.out.print(x);

    }
}
