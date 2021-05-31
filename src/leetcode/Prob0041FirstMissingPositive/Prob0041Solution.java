package leetcode.Prob0041FirstMissingPositive;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 第一个缺失的正整数
 * 简单解法：
 * 1、给数组排序
 * 2、二分查找找出 1
 * 3、往后遍历
 * 4、数组中有重复元素 —— 使用 HashSet 去重
 * 时间复杂度为 O(N * logN)
 *
 * @author Okaeri
 */

/**
 * 之后批注： 时间复杂度和空间复杂度都超了
 */
public class Prob0041Solution {
    public int firstMissingPositive(int[] nums) {
        // 通过 HashSet 给数组去重
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        Object[] objects = set.toArray();
        // 得到无重复元素的新数组 newArray
        int[] newArray = new int[objects.length];
        for (int i = 0; i < objects.length; i++) {
            newArray[i] = (int) objects[i];
        }
        // 排序
        Arrays.sort(newArray);
        // i 是 1 在 nums 数组中的索引
        int i = binarySearch(newArray, 1);
        // i == -1，即 nums 数组中不包含第一个正整数，返回 1
        if (i == -1) {
            return 1;
        }
        int cursor = 0;
        for (int j = i; j < newArray.length; j++) {
            if (newArray[j] != ++cursor) {
                return cursor;
            }
        }
        return cursor + 1;
    }

    /**
     * 二分查找
     *
     * @param array  输入数组，其中无重复元素
     * @param target 被查找元素
     * @return 被查找元素的索引，
     */
    private int binarySearch(int[] array, int target) {
        // 如果 target 不在数组之中，返回 -1
        if (target < array[0] || target > array[array.length - 1]) {
            return -1;
        }
        int lo = 0;
        int hi = array.length - 1;
        while (lo <= hi) {
            // mid = lo + (hi - lo) >> 1; 右移一位导致死循环了
            int mid = lo + (hi - lo) / 2;
            if (target > array[mid]) {
                lo = mid + 1;
            } else if (target < array[mid]) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}

/**
 * 简单解法 2：将所有的数组元素放进 HashSet 中，从 1 ~ n + 1 遍历一次，使用 set.contains() 函数，不包含即求解的值
 * 空间复杂度为 O(N) 超出要求 ，时间复杂度 O(N) 满足要求
 */
class Prob0041Solution2 {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int result;

        for (result = 1; result <= nums.length; result++) {
            if (!set.contains(result)) {
                break;
            }
        }
        return result;
    }
}


/**
 * 官方解法，秒啊
 */
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // 把数组中的非正数，改变成 n+1
        for (int i = 0; i < n; ++i) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        // 数字 n 存在了，就把对应的索引为 n - 1 的位置变成负数
        for (int i = 0; i < n; ++i) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        // 最后遍历一次，找到第一个正数，即结果
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
class Test {
    public static void main(String[] args) {
        Prob0041Solution2 sol = new Prob0041Solution2();
        int[] nums = {1, 2, 2, 1, 3, 1, 0, 4, 0};
        int i = sol.firstMissingPositive(nums);
        System.out.println(i);
    }
}
