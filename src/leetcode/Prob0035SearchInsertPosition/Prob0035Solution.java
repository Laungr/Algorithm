package leetcode.Prob0035SearchInsertPosition;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置
 *
 * @author Okaeri
 */
public class Prob0035Solution {
    public int searchInsert(int[] nums, int target) {
        int res;
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        res = searchInsert(nums, target, 0, nums.length - 1);

        return res;
    }

    public int searchInsert(int[] nums, int target, int lo, int hi) {
        int mid = (hi + lo) / 2;
        // 如果命中，就返回
        if (target == nums[mid] || hi == lo) {
            return mid;
        }
        //利用二分查找，
        else if (target < nums[mid]) {
            return searchInsert(nums, target, lo, mid);
        } else {
            return searchInsert(nums, target, mid + 1, hi);
        }
    }

}

class Prob0035Solution2 {
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1, mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (target > nums[mid]) {
                low = mid + 1;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        if (target > nums[mid]) {
            return mid + 1;
        }
        return mid;
    }
}

class Test {
    public static void main(String[] args) {
        Prob0035Solution sol = new Prob0035Solution();
        int[] nums = {1, 3, 5};
        int target = 4;
        int i = sol.searchInsert(nums, target);
        System.out.println(i);
    }
}


