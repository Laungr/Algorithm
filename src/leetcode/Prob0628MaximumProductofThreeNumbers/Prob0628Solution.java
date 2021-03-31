package leetcode.Prob0628MaximumProductofThreeNumbers;

import java.util.Arrays;

// 将数组进行排序，最大值是最大三数的乘积， 或者是 最小俩数乘以最大数
// 时间复杂读就是给数组排序 O(N*logN)

public class Prob0628Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;

        return Math.max(nums[0] * nums[1] * nums[length - 1], nums[length - 1] *nums[length - 2] * nums[length - 3]);
    }
}
