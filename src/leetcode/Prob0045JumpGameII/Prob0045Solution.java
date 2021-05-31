package leetcode.Prob0045JumpGameII;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。 数组中的每个元素代表你在该位置可以跳跃的最大长度。你的目标是使用最少的跳跃次数到达数组的最后一个位置.
 *
 * 使用动态规划
 *
 * 另一种理解是，找出最少的数字，使得和大于等于数组长度，并且相邻的两个索引之差不小于前一索引处的值
 *
 * @author Okaeri
 */
public class Prob0045Solution {
    public int jump(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        // 如果数组只包含一个元素，头即是尾，那么 0 次跳跃就到尾
        dp[0] = 0;
        // 如果数组中有两个元素，到尾部一定需要跳跃一次
        dp[1] = 1;
        for (int i = 2; i < len; i++) {
            //初始化
            dp[i] = len;
            // 如果第一个元素的值比索引值大，那么一步就可以跳到
            if (nums[0] >= i) {
                dp[i] = 1;
                continue;
            }
            // j 可以从 1 开始，因为从 0 开始进入循环也是 continue
            for (int j = 1; j < i ; j++) {
                if (nums[j] < i - j){
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[j] + 1);
            }
        }
        return dp[len - 1];
    }
}

class Test{
    public static void main(String[] args) {
        Prob0045Solution sol = new Prob0045Solution();
        int[] nums = {0, 1};
        int jump = sol.jump(nums);
        System.out.println(jump);

    }
}
