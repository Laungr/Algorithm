package leetcode.Prob0204CountPrimes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 小于 n 的 素数有多少个
 *
 * @author Okaeri
 */
public class Prob0204Solution {
    public int countPrimes(int n) {
        List<Integer> primeList = new ArrayList<>();
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                primeList.add(i);
            }
            // 最大只筛到 i * （i以内的最大质数）
            for (int j = 0; j < primeList.size() && (long) i * primeList.get(j) < n; ++j) {
                isPrime[i * primeList.get(j)] = false;
                if (i % primeList.get(j) == 0) {
                    break;
                }
            }
        }
        return primeList.size();
    }
}

/**
 * 埃氏筛法，好理解
 */
class Prob0204Solution2 {
    public int countPrimes(int n) {
        int res = 0;
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                res++;
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        isPrime[j] = false;
                    }
                }
            }
        }
        return res;
    }
}

class Test {
    public static void main(String[] args) {
        Prob0204Solution sol = new Prob0204Solution();
        int i = sol.countPrimes(1000000);
        Prob0204Solution2 sol2 = new Prob0204Solution2();
        int i2 = sol2.countPrimes(1000000);
        System.out.println(i);
        System.out.println(i2);

    }
}
