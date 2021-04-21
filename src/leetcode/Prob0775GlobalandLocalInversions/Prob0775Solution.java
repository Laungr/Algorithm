package leetcode.Prob0775GlobalandLocalInversions;

/**
 * Global Inversion 0 <= i < j < n && nums[i] > nums[j]
 * Local Inversion  0 <= i < n - 1 && nums[i] > nums[i + 1]
 * 根据定义直接暴力求解，所有的测试用例通过，但是提交代码时间时间超出了。
 */
public class Prob0775Solution {
    public boolean isIdealPermutation(int[] nums) {
        int globalInversion = 0;
        int localInversion = 0;
        int len = nums.length;

        for (int i = 0; i < len - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                localInversion++;
            }
            for (int j = i + 1; j < len; j++) {
                if (nums[i] > nums[j]) {
                    globalInversion++;
                }
            }
        }
//        System.out.println("Global Inversion ==> " + globalInversion);
//        System.out.println("Local  Inversion ==> " + localInversion);
        return globalInversion == localInversion;
    }
}

class Test {
    public static void main(String[] args) {
        Prob0775Solution sol = new Prob0775Solution();
        int[] nums = {1};
        System.out.println(sol.isIdealPermutation(nums));
    }
}
