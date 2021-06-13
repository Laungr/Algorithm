package leetcode.jzOffer.JZ045NumstoMinNumber;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给出一个数组，把数组中的所有数字当字符串拼接起来，返回最小的拼接结果，以字符串形式
 *
 * @author Okaeri
 */
public class JZ045Solution {
    public String minNumber(int[] nums) {
        String[] strings = new String[nums.length];
        // 把所有的数字转换成为字符串
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s1 + s2).compareTo(s2 + s1);
            }
        });

        StringBuilder res = new StringBuilder();
        for (String string : strings) {
            res.append(string);
        }
        return res.toString();
    }
}
