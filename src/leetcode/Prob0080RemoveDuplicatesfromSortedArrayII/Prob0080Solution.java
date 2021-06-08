package leetcode.Prob0080RemoveDuplicatesfromSortedArrayII;

import java.util.Arrays;

/**
 * 给你一个有序数组 nums ，原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
 *
 * @author Okaeri
 */
public class Prob0080Solution {
    public int removeDuplicates(int[] nums) {
        int result = nums.length;
        for (int i = 0; i < nums.length - 2; i++) {
            // 因为每个元素最多允许出现两次
            if (nums[i] == nums[i + 1] && nums[i] == nums[i + 2]) {
                // 题目中限定 nums[i] 的值介于[-10^4, 10^4] 中
                nums[i] = 1001;
                result--;
            }
        }
        Arrays.sort(nums);
        return result;
    }
}

/**
 * 太妙了
 */
class Prob0080Solution2 {
    public int removeDuplicates(int[] nums) {
        // 如果数组的长度为 1 或 2，直接返回
        if (nums.length <= 2) {
            return nums.length;
        }
        // 左右指针的索引都为 2
        int left = 2;
        int right = 2;
        while (right < nums.length) {
            if (nums[left - 2] != nums[right]) {
                nums[left++] = nums[right];
            }
            ++right;
        }
        return left;
    }
}

class Test {
    public static void main(String[] args) {
        Prob0080Solution sol = new Prob0080Solution();
        Prob0080Solution2 sol2 = new Prob0080Solution2();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int i = sol.removeDuplicates(nums);
        System.out.println(i);
        System.out.println(Arrays.toString(nums));

        int i2 = sol2.removeDuplicates(nums);
        System.out.println(i2);
        System.out.println(Arrays.toString(nums));


    }
}

