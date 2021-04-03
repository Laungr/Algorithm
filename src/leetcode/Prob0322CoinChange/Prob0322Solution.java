package leetcode.Prob0322CoinChange;

import java.util.Arrays;

/**
 * 备忘录方法
 */

/*public class Prob0322Solution {
    public static int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];

        //给memo数组的所有元素赋值为无穷大
        Arrays.fill(memo, Integer.MAX_VALUE);

        return dp(coins, memo,amount);
    }
    public static int dp(int[] coins,int[] memo, int amount){
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        //从备忘录中取值
        if (memo[amount] != Integer.MAX_VALUE) return memo[amount];

        //计算该值，存入备忘录
        for (int i = 0; i < coins.length; i++) {
            //如果无法裂项，那么不做处理继续循环，那么数组中得到的值就仍为正无穷大
            int res = dp(coins, memo, amount - coins[i]);
            if(res >=0 && res < Integer.MAX_VALUE)
                memo[amount] = Math.min(memo[amount], 1 + res);
        }
        return memo[amount] == Integer.MAX_VALUE?-1:memo[amount];
    }

}*/

/**
 * 动态规划，自底向上
  */
class Prob0322Solution2{
    public static int coinChange(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }

        int dp[] = new int[amount+1];
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
            for (int coin : coins) {
                if (i < coin) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return dp[amount]==amount+1?-1:dp[amount];
    }
}

class Test{
    public static void main(String[] args) {
        int[] coins = {186,419,83,408};
        int[] coins2 = {1,2,5};
        System.out.println(Prob0322Solution2.coinChange(coins, 6249));
        Prob0322Solution3 sol = new Prob0322Solution3();
        System.out.println(sol.coinChange(coins, 6249));
    }
}

class Prob0322Solution3{
    public int coinChange(int[] coins, int amount){
        int[] dp = new int[amount + 1];
        for (int i = 1; i < amount + 1; i++) {
            dp[i] = amount + 1;
        }
        dp[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            for(int coin : coins){
                if (i == coin){
                    dp[i] = 1;
                }
                if (i > coin){
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }

        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
