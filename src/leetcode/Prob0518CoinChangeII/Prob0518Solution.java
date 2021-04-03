package leetcode.Prob0518CoinChangeII;

/**
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
 */

public class Prob0518Solution {

    int coinChange2(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        //base case
        dp[0] = 1;
        for (int coin : coins) {
            for (int j = 1; j <= amount; j++) {
                if (j - coin >= 0) {
                    dp[j] = dp[j] + dp[j - coin];
                }
            }
        }

        return dp[amount];
    }

}

class Test {
    public static void main(String[] args) {
        Prob0518Solution sol = new Prob0518Solution();
        int[] coins = {1, 2, 5};
        int amount = 5;
        System.out.println(sol.coinChange2(amount, coins));
    }
}
