package leetcode.Prob0034FindFirstandLastPositionofElementinSortedArray;

import java.util.Arrays;

/**
 * @author Okaeri
 */
public class Prob0034Solution {
    public int[] searchRange(int[] nums, int target) {
        int upperLimit = -1;
        int lowerLimit = -1;

        int[] arr = binarySearch(nums, target, 0, nums.length - 1);
        // 如果数组为空数组，则直接返回[-1, -1]
        // 如果数组不为空，递归计算最大、最小的索引
        if (arr != null){
            upperLimit = upperLimit(nums, target, arr[1], arr[2]);
            lowerLimit = lowerLimit(nums, target, arr[0], arr[1]);
        }

        return new int[]{lowerLimit, upperLimit};
    }

    /**
     * 查找最小索引，与 binarySearch 二分查找不同，二分查找只要找到一个符合的索引即返回，
     * 这个需要确定到极限的那个值，所以最后需要比较相邻的两个数字
     * @param nums 输入数组
     * @param target 被查找的数字
     * @param lo 查找下边界
     * @param hi 查找上边界
     * @return 返回的lowerLimit，被查找值的最大索引
     */
    public int lowerLimit(int[] nums, int target, int lo, int hi) {
        //当 lo == hi || lo = mid + 1 时， lo == mid
        int mid = lo + (hi - lo) / 2;
        // 递归出口
        if (lo == mid){
            return nums[lo] == target ? lo : hi;
        }
        // nums[mid] == target，继续往下索引
        if (nums[mid] == target) {
            return lowerLimit(nums, target, lo, mid);
        }
        else if (target > nums[mid]) {
            return lowerLimit(nums, target, mid + 1, hi);
        }
        else {
            return lowerLimit(nums, target, lo, mid - 1);
        }
    }

    /**
     * 查找最大索引
     * @param nums 输入数组
     * @param target 被查找的数字
     * @param lo 查找下边界
     * @param hi 查找上边界
     * @return 返回的upperLimit，被查找值的最大索引
     */
    public int upperLimit(int[] nums, int target, int lo, int hi) {
        int mid = lo + (hi - lo) / 2;
        if (lo == mid){
            return nums[hi] == target ? hi : lo;
        }
        if (nums[mid] == target) {
            return upperLimit(nums, target, mid, hi);
        }
        else if (target > nums[mid]) {
            return upperLimit(nums, target, mid + 1, hi);
        }
        else {
            return upperLimit(nums, target, lo, mid - 1);
        }
    }

    /**
     * 二分查找的递归解法
     * @param nums 输入数组
     * @param target 被查找的数字
     * @param lo 查询下边界
     * @param hi 查询下边界
     * @return 返回值是一个数组，包含 3 个元素，找到被查找数字的索引，以及查找到时候的上下边界。
     *          如果查找不到，返回一个空数组
     */
    public int[] binarySearch(int[] nums, int target, int lo, int hi) {
        if (lo > hi || nums[0] > target || nums[nums.length - 1] < target) {
            return null;
        }
        int mid = lo + (hi - lo) / 2;
        // 递归出口
        if (nums[mid] == target) {
            return new int[]{lo, mid, hi};
        }
        // 递归
        else if (target > nums[mid]) {
            return binarySearch(nums, target, mid + 1, hi);
        }
        else  {
            return binarySearch(nums, target, lo, mid - 1);
        }
    }
}

class Test {
    public static void main(String[] args) {
        Prob0034Solution sol = new Prob0034Solution();
        int[] nums = {1,2,2,2,2,2,6,7,8};
        System.out.println(Arrays.toString(sol.binarySearch(nums, 2, 0, nums.length - 1)));
        System.out.println(Arrays.toString(sol.searchRange(nums, 2)));
    }
}
