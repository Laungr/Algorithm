package leetcode.Prob0152MaximumProductSubarray;

/**
 * subArray 的定义是，数组中连续的一段
 * 求得 subArray 每个元素成绩的最大值，元素只可正可负
 * 输入数组的长度大于 0
 */
public class Prob0152Solution {
    public int maxProduct(int[] nums){
        int[][] dp = new int[nums.length][2];

        int max = nums[0];
        if (nums[0] > 0){
            dp[0][0] = nums[0];
        }
        else {
            dp[0][1] = nums[0];
        }

        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(Math.max(dp[i - 1][0] * nums[i], dp[i - 1][1] * nums[i]), nums[i]);
            dp[i][1] = Math.min(Math.min(dp[i - 1][0] * nums[i], dp[i - 1][1] * nums[i]), nums[i]);
            max = Math.max(Math.max(dp[i][0], dp[i][1]), max);
        }
        return max;
    }
}

class Test {
    public static void main(String[] args) {
        Prob0152Solution sol = new Prob0152Solution();
        int[] nums = {2,3,-2,4};
        int[] nums2 = {-3,5,-1};
        System.out.println(sol.maxProduct(nums2));
    }
}
