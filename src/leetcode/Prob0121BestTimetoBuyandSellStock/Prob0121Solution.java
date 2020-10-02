package leetcode.Prob0121BestTimetoBuyandSellStock;

public class Prob0121Solution {
    public static int maxProfit(int[] prices) {

        int N = prices.length;
        if (N < 2) return 0;
        int max = 0;
        //两次遍历 暴力算法
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                max = Math.max(max, prices[j] - prices[i]);
            }
        }
        return max;
    }
}

class Prob0121Solution2{
    public static int maxProfit(int [] prices){
        int N = prices.length;
        if (N < 2) return 0;

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price: prices){
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }
}

class Test{
    public static void main(String[] args) {
        int[] prices={7,1,5,3,6,4};
        System.out.println(Prob0121Solution.maxProfit(prices));
        System.out.println(Prob0121Solution2.maxProfit(prices));
    }
}
