package leetcode.Prob0013RomoanToInt;

import java.util.HashMap;

public class Prob0013Solution {
    public static int romanToInt(String s){
        int ans = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        char[] symbolsArr = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int[] valuesArr = {1, 5, 10, 50, 100, 500, 1000};

        for (int i = 0; i < symbolsArr.length; i++){
            hashMap.put(symbolsArr[i], valuesArr[i]);
        }

        for (int i = 0; i < s.length() - 1; i++) {
            int sign = 1;
            if (hashMap.get(s.charAt(i)) < hashMap.get(s.charAt(i+1))){
                sign = -1;
            }
            ans += sign*hashMap.get(s.charAt(i));
        }
        ans += hashMap.get(s.charAt(s.length()-1));
        return ans;
    }

}

class Test{
    public static void main(String[] args) {
        String s = "LVIII";
        System.out.println(Prob0013Solution.romanToInt(s));
    }
}
