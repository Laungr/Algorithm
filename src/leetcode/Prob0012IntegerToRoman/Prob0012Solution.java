package leetcode.Prob0012IntegerToRoman;

import java.util.HashMap;

//class Prob0012Solution{
//    public static String intToRoman(int num){
//        String symbolsStr[] = {"", "", "M", "D", "C", "L", "X", "V", "I"};
//        int digitArray[] = new int[4];
//        int digitCase = 0;
//        int mod = 1000;
//
//        String ans = "";
//
//        if (num < 1 || num > 3999) return "";
//        while (mod > 1) {
//            digitArray[digitCase++] = num / mod;
//            num = num % mod;
//            mod = mod / 10;
//            if(mod == 1) digitArray[digitCase++] = num;
//        }
//
//
//        for (int i = 0; i < digitArray.length; i++) {
//            int carry = 0;
//            if (digitArray[i] >= 5) {
//                carry = 1;
//                digitArray[i] %= 5;
//            }
//            if (carry == 0){
//                if (i > 0 && digitArray[i] == 4)
//                    ans = ans + symbolsStr[2*i+2] + symbolsStr[2*i +1] ;
//                else ans += symbolsStr[2*i+2].repeat(digitArray[i]);
//
//            }
//            else {
//                if (i > 0 && digitArray[i] == 4)
//                    ans = ans + symbolsStr[2*i+2] + symbolsStr[2*i ] ;
//                else ans += (symbolsStr[2*i +1]+ symbolsStr[2*i+2].repeat(digitArray[i]));
//
//            }
//        }
//        return ans;
//    }
//}

//第一种与第二种的复杂度相同，第二种方法比较好辨识一些。
class Prob0012Solution2{
    public static String intToRoman(int num) {
        int []digitArray = {0, 0, 0, 0, 0, 0, 0, 0};
        String symbolsStr[] = {"", "M", "D", "C", "L", "X", "V", "I"};
        if (num < 1 || num > 3999) return "";
        String ans = "";
        int mod = 1000;
        int digitCount = 0;
        while (mod > 0){
            int digit = num / mod;
            num %= mod;
            mod /= 10;
            digitArray[digitCount++] = digit / 5;
            digitArray[digitCount++] = digit % 5;
        }

        for (int i = 0; i < digitArray.length /2 ; i ++){
            if (digitArray[2*i+1] == 4) ans = ans + symbolsStr[2*i +1] + symbolsStr[2*i -digitArray[2*i]];
            else ans = ans + symbolsStr[2*i].repeat(digitArray[2*i])+ symbolsStr[2*i+1].repeat(digitArray[2*i+1]);
        }
        return ans;
    }

}

class Test{
    public static void main(String[] args) {
        int num = 1994;
        System.out.println(Prob0012Solution2.intToRoman(num));
    }
}