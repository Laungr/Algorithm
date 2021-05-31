package leetcode.Prob0055JumpGame;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 跳跃游戏
 * 给定一个非负整数数组 nums，你最初位于数组的第一个下标。数组中的每个元素代表你在该位置可以跳跃的最大长度。判断你是否能够到达最后一个下标。
 * 动态规划 时间复杂度 O(N*N)
 *
 * @author Okaeri
 */
public class Prob0055Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        boolean[] dp = new boolean[len];
        // 初始跳在第一个，因此为 true
        dp[0] = true;
        // 后面的进入循环
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = (i - j <= nums[j]) && dp[j];
                // 能跳到即退出循环
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[len - 1];
    }
}

/**
 * 没有动态规划，时间复杂度仍比较高
 */
class Prob0055Solution2 {
    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        // 索引位置
        int index = 0;
        while (index < nums.length) {
            // 提前出口
            if (dp[nums.length - 1]) {
                return true;
            }
            if (dp[index]) {
                // offset 每次偏移量，索引右移
                for (int offset = 1; offset <= nums[index] && index + offset < nums.length; offset++) {
                    dp[index + offset] = true;
                }
            }
            index++;
        }
        return dp[nums.length - 1];
    }
}


/**
 * 如果能跳就一直跳，能跳到最后就 true，否则就 false
 * 太妙了
 */
class Solution{
    public boolean canJump(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > index) {
                return false;
            }
            index = Math.max(index, i + nums[i]);
        }
        return true;
    }
}

class Test {
    public static void main(String[] args) {
        Prob0055Solution2 sol = new Prob0055Solution2();
        int[] nums = {3, 2, 1, 0, 4};
        boolean canJump = sol.canJump(nums);
        System.out.println(canJump);
    }
}