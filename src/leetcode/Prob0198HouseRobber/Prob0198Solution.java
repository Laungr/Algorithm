package leetcode.Prob0198HouseRobber;

// 这就是打家劫舍问题吗？
// 这种问题就是当前这个能选 或者 不能选，从二者中取优

/**
 * @author Okaeri
 */
public class Prob0198Solution {
    public int rob(int[] nums){
        int len = nums.length;
        int[] dp = new int[len];

        dp[0] = nums[0];
        if (len > 1) {
            dp[1] = Math.max(dp[0], nums[1]);
        }
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[len - 1];
    }
}

class Test{
    public static void main(String[] args) {
        Prob0198Solution sol = new Prob0198Solution();
        int[] nums = {100, 7, 9, 200 ,1};
        System.out.println(sol.rob(nums));
    }
}
