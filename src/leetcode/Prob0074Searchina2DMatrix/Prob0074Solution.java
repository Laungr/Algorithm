package leetcode.Prob0074Searchina2DMatrix;

/**
 * 在一个二维矩阵中找一个元素，能找到返回 true，找不到返回 false
 * 二分查找
 * 时间复杂度为 O(log(m + n))
 *
 * @author Okaeri
 */
public class Prob0074Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int[] numsAtFirstCol = new int[matrix.length];
        // 把第一列放进一个数组中
        for (int i = 0; i < matrix.length; i++) {
            numsAtFirstCol[i] = matrix[i][0];
        }
        // 如果在第一列，直接返回
        if (binarySearch(numsAtFirstCol, target)) {
            return true;
        }
        // 查出 target 应该插入在第几行
        int targetAtRow = searchInsert(numsAtFirstCol, target) - 1;
        // 查出 targetAtRow 这一行是否存在 target
        if (targetAtRow < 0) {
            return false;
        }
        return binarySearch(matrix[targetAtRow], target);
    }

    /**
     * 给出一个数组和一个数字，如果数组中包含这个数字，返回其索引，否则返回这个数字应当插入位置的索引
     *
     * @param nums   数组
     * @param target 目标数字
     * @return 应当插入的索引
     */
    private int searchInsert(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }

    private boolean binarySearch(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
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
        Prob0074Solution sol = new Prob0074Solution();
        int[][] matrix = {{1}, {3}, {5}};
        int target = 3;
        boolean b = sol.searchMatrix(matrix, target);
        System.out.println(b);
    }
}
