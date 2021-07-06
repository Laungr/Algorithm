package leetcode.DailyChallenge;

import java.util.HashMap;

/**
 * 元音的全排列个数
 * 这道题主要是用 int 会溢出，要用 long 类型
 * <p>
 * Each character is a lower case vowel ('a', 'e', 'i', 'o', 'u')
 * Each vowel 'a' may only be followed by an 'e'.
 * Each vowel 'e' may only be followed by an 'a' or an 'i'.
 * Each vowel 'i' may not be followed by another 'i'.
 * Each vowel 'o' may only be followed by an 'i' or a 'u'.
 * Each vowel 'u' may only be followed by an 'a'.
 *
 * @author Okaeri
 */
public class July05CountVowelsPermutation {
    private static final int MOD = 1000000007;
    private static final char[] VOWELS = {'a', 'e', 'i', 'o', 'u'};

    public int countVowelPermutation(int n) {
        HashMap<Character, Long> map = new HashMap<>(5);
        long[] add = new long[5];
        for (char vowel : VOWELS) {
            map.put(vowel, 1L);
        }
        // return value
        long res = 5;
        for (int i = 1; i < n; i++) {
            res = 0;
            // 遍历每个元音，然后将其替换掉
            for (char vowel : VOWELS) {
                long cnt = map.get(vowel) % MOD;
                if (vowel == 'a') {
                    res = (res + cnt) % MOD;
                    add[1] += cnt;
                } else if (vowel == 'e') {
                    res += (2 * cnt);
                    res %= MOD;
                    add[0] += cnt;
                    add[2] += cnt;
                } else if (vowel == 'i') {
                    res += (4 * cnt);
                    res %= MOD;
                    add[0] += cnt;
                    add[1] += cnt;
                    add[3] += cnt;
                    add[4] += cnt;
                } else if (vowel == 'o') {
                    res += (2 * cnt);
                    res %= MOD;
                    add[2] += cnt;
                    add[4] += cnt;
                } else {
                    res += cnt;
                    res %= MOD;
                    add[0] += cnt;
                }
            }
            res = res % MOD;
            for (int j = 0; j < add.length; j++) {
                map.put(VOWELS[j], add[j]);
                add[j] = 0;
            }

        }
        return (int) res;
    }
}

class July05Test {
    public static void main(String[] args) {
        July05CountVowelsPermutation sol = new July05CountVowelsPermutation();
        System.out.println(sol.countVowelPermutation(20000));
    }
}
