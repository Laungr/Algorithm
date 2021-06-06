package leetcode.Prob0073Searchina2DMatrix;

/**
 * 在一个二维矩阵中找一个元素，能找到返回 true，找不到返回 false
 * 二分查找
 * 时间复杂度为 O(log(m + n))
 *
 * @author Okaeri
 */
public class Prob0073Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int[] numsAtFirstCol = new int[matrix.length];
        // 把第一列放进一个数组中
        for (int i = 0; i < matrix.length; i++) {
            numsAtFirstCol[i] = matrix[i][0];
        }
        // 查出 target 应该插入在第几行
        int targetAtRow = searchInsert(numsAtFirstCol, target);
        //考虑到 searchInsert 函数除了返回插入位置，也可以返回查找位置，所以首先验证已经找到了 target，否则就表示 matrix[targetAtRow][0] > target 的
        if (matrix[targetAtRow][0] == target) {
            return true;
        } else {
            // 除去 matrix[targetAtRow][0] == target 的情况，其他的是 target 应该插入上一行，因此targetAtRow--
            targetAtRow -= 1;
            // 第 -1 行会导致数组索引越界，进行判断
            if (targetAtRow < 0) {
                return false;
            }
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
        Prob0073Solution sol = new Prob0073Solution();
        int[][] matrix = {{1}, {3}, {5}};
        int target = 3;
        boolean b = sol.searchMatrix(matrix, target);
        System.out.println(b);
    }
}
