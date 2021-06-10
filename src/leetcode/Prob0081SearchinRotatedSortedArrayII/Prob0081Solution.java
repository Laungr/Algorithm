package leetcode.Prob0081SearchinRotatedSortedArrayII;

/**
 * 给出一个有序数组，将数组中的元素旋转几位，变成两部分有序[0, k],[k + 1, len -1].
 * Prob0033 中没有重复元素
 *
 * @author Okaeri
 */
public class Prob0081Solution {
    public boolean search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        return search(nums, target, lo, hi);
    }

    private boolean search(int[] nums, int target, int lo, int hi) {
        if (lo > hi) {
            return false;
        }
        int mid = lo + (hi - lo) / 2;
        if (nums[mid] == target) {
            return true;
        }
        if (nums[lo] < nums[mid]) {
            if (target >= nums[lo] && target < nums[mid]) {
                return binarySearch(nums, target, lo, mid - 1);
            } else {
                return search(nums, target, mid + 1, hi);
            }
        } else if (nums[mid] < nums[hi]) {
            if (target > nums[mid] && target <= nums[hi]) {
                return binarySearch(nums, target, mid + 1, hi);
            } else {
                return search(nums, target, lo, mid - 1);
            }
        } else {
            return search(nums, target, lo, mid - 1) || search(nums, target, mid + 1, hi);
        }
    }
    private boolean binarySearch(int[] nums, int target, int lo, int hi) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (target == nums[mid]) {
                return true;
            } else if (target > nums[mid]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return false;
    }
}

class Test {
    public static void main(String[] args) {
        Prob0081Solution sol = new Prob0081Solution();
        int[] nums = {3, 1};
        int target = 1;
        boolean search = sol.search(nums, target);
        System.out.println(search);
    }
}
