package leetcode.Prob213HouseRobberII;

//Prob0198 打家劫舍问题中，家是成环状的，那么头和尾就不能同时打

import java.util.Arrays;

public class Prob0213Solution {
    public int rob(int[] nums){
        int len = nums.length;
        int[]dp1 = new int[len];
        int[]dp2 = new int[len];

        if (len == 1){
            return nums[0];
        }
        if (len == 2){
            return Math.max(nums[0], nums[1] );
        }

        int[] nums1 = Arrays.copyOfRange(nums, 0,len - 1);
        int[] nums2 = Arrays.copyOfRange(nums, 1, len );
        // System.out.println(nums2.length);

        dp1[0] = nums1[0];
        dp1[1] = Math.max(nums1[0], nums1[1]);

        dp2[0] = nums2[0];
        dp2[1] = Math.max(nums2[0], nums2[1]);

        for (int i = 2; i < len - 1; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + nums1[i]);
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + nums2[i]);

        }

        return Math.max(dp1[len - 2],dp2[len - 2] );

    }
}

class Test{
    public static void main(String[] args) {
        Prob0213Solution sol = new Prob0213Solution();
        int []nums = {100,200,300,100};
        System.out.println(sol.rob(nums));
    }
}
