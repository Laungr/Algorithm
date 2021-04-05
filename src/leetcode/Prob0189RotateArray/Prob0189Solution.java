package leetcode.Prob0189RotateArray;

/**
 * 旋转数组
 * 旋转一格是数组最末尾的元素到数组第一个
 * 旋转 k，表示把最末尾的 k 个元素放到前面来
 */
public class Prob0189Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int[] res = new int[len];
        //若 k 比较大，对 len 取余数
        int rem = k % len;

        for (int i = 0; i < len; i++) {
            if (i < rem) {
                res[i] = nums[len - rem + i];
            } else {
                res[i] = nums[i - rem];
            }
        }
        System.arraycopy(res, 0, nums, 0, len);
    }
}

class Test {
    public static void main(String[] args) {
        Prob0189Solution sol = new Prob0189Solution();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        sol.rotate(nums, k);
    }
}
