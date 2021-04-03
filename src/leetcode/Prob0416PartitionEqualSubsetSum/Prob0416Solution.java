package leetcode.Prob0416PartitionEqualSubsetSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给出一个数组，将这个数组分为两部分，使得两部分的和相等。
 * 思路：找零钱问题，零钱只有一张，target 是数组总和的一半
 */
public class Prob0416Solution {
    public boolean canPartition(int[] nums) {
        //首先遍历一遍数组，对所有元素求和，如果和是奇数，直接返回false；
        int sum = 0;
        int len = nums.length;
        List<Integer> list = new ArrayList<>(nums.length);
        for (int n : nums) {
            sum += n;
            list.add(n);
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;

        //开始动态规划
        boolean[][] dp = new boolean[len + 1][target + 1];
        //dp[i][0]总是为true，表示不选可以达成
        for (int i = 0; i < len + 1; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < len + 1; i++) {
            for (int j = 1; j < target + 1; j++) {
                //dp[i][j] = dp[i - 1][j];
                if (nums[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                }
            }
        }

        return dp[len][target];

        //System.out.println("target==>"+target);
        //return coinChange(list, target);
    }

    private boolean coinChange(List nums, int target) {
        System.out.println(target);
        if (nums.size() < 1 || target < 0) {
            return false;
        }

        int o = (Integer) nums.remove(0);
        if (target == o) {
            return true;
        }
        return coinChange(nums, target) || coinChange(nums, target - o);
    }
}

class Test {
    public static void main(String[] args) {
        Prob0416Solution sol = new Prob0416Solution();
        int[] nums = {2, 2, 3, 5};
        int[] nums2 = {3, 3, 3, 4, 5};
        System.out.println(sol.canPartition(nums));
    }
}
