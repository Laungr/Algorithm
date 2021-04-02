package leetcode.Prob0000Knapsack;

/**
 * 0-1背包问题
 * weight[] 表示每件商品的重量的数组
 * values[] 表示每件商品的价值的数组
 * n 表示商品的数量
 * w 表示背包的容量
 */
public class ProbKnapsackSolution {
    public int knapsack(int n, int w, int[] weight, int[] values) {
        //dp[][]数组的长度比原数组的长度大 1
        int[][] dp = new int[n + 1][w + 1];
        //把第 0 列和第 0 行的填充为 0；不赋值默认赋为 0
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < w + 1; i++) {
            dp[0][i] = 0;
        }

        //dp[i][j] 的含义为从前面 i 个元素中选，此时的背包容量为 j
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < w + 1; j++) {
                //如果背包容量小了，那么就跳回前一个
                if (j < weight[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                }
                // 背包容量不小，那么就是选或者不选
                else {
                    dp[i][j] = Math.max(values[i-1] + dp[i - 1][j - weight[i-1]], dp[i - 1][j]);
                }
            }
        }
        return dp[n][w];
    }
}

class Test{
    public static void main(String[] args) {
        ProbKnapsackSolution sol = new ProbKnapsackSolution();
        int n = 5;
        int w = 20;
        int[] weight = {2,3,4,5,9};
        int[] values = {3,4,5,8,10};

        System.out.println(sol.knapsack(n, w, weight, values));
    }
}