package leetcode.Prob0033SearchinRotatedSortedArray;

/**
 * 整数数组 nums 按升序排列，数组中的值互不相同。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * <p>
 * 找出这个数组中是否包含 target 这个元素，要求算法的时间复杂度为 O(logN)
 *
 * @author Okaeri
 */
public class Prob0033Solution {
    public int search(int[] nums, int target) {
        // 这个数组是部分有序的，[0, mid],[mid + 1, nums.length - 1] 两个中至少有一个是有序的
        // 如何判断有序，如果nums[lo] < nums[hi] 就是有序的
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //左半部分有序
            if (nums[lo] <= nums[mid]) {
                // target 在左半区间内
                if (target >= nums[lo] && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
            // 右半部分有序
            else {
                // 在右半区间内
                if (target > nums[mid] && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }
}

class Test {
    public static void main(String[] args) {
        Prob0033Solution sol = new Prob0033Solution();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int search = sol.search(nums, 0);
        System.out.println(search);
    }
}
