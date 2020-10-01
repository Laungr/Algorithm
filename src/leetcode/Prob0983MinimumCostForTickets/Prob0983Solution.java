package leetcode.Prob0983MinimumCostForTickets;

public class Prob0983Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int dp[] = new int[days[days.length - 1] + 1];

        for (int i = 0; i < days.length; i++) {
            dp[days[i]] = costs[0] * i;
            for (int cost : costs){
                if (cost == 2){
                    dp[i] = Math.min(dp[days[i]], cost + dp[days[i] - 1]);

                }
                else if (cost == 7){
                    if (days[i] <= 7) dp[i] = cost;
                    dp[i] = Math.min(dp[days[i]], cost + dp[days[i] - 7] );

                }
                else if(cost == 15){
                    if (days[i] <= 30) dp[i] = cost;

                    dp[i] = Math.min(dp[days[i]], cost + dp[days[i] - 30]);
                }

            }

        }


        return 0;
    }
}
