package leetcode.Prob0031NextPermutation;

import java.util.Arrays;

/**
 * 顾名思义，下一个排列
 * 最直接的想法是，已经求出了全排列，即可找出下一个排列
 * 题目要求使用原地算法，
 * 在 leetcode 的 solution 中有人这样说，这个题如果知道解法，确实是难度 medium；但如果不知道解法，那比 hard 还要难。XDD
 * @author Okaeri
 */
public class Prob0031Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int cursor = -1;
        // 数组中从右向左找，第一个非递增的元素索引
        for (int i = len - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                cursor = i;
                break;
            }

        }
        // 数组从右向左找，第一个大于 nums[cursor] 的值，并与 nums[cursor] 进行交换
        for (int i = len - 1; cursor >= 0 && i >= 0; i--) {
            if (nums[i] > nums[cursor]) {
                swap(nums, cursor, i);
                break;
            }
        }
        // 从 cursor 之后进行逆序翻转
        reverse(nums, cursor + 1);

        System.out.println(Arrays.toString(nums));

    }

    /**
     * 反翻一个数组的尾部
     *
     * @param array 输入数组
     * @param start 开始翻转起始位置
     */
    public void reverse(int[] array, int start) {
        int i = start, j = array.length - 1;
        while (i < j) {
            swap(array, i++, j--);
        }
    }

    /**
     * 交换数组中两个位置的元素
     *
     * @param array 数组
     * @param p     位置 p
     * @param q     位置 q
     */
    public void swap(int[] array, int p, int q) {
        int temp = array[p];
        array[p] = array[q];
        array[q] = temp;
    }
}


class Test{
    public static void main(String[] args) {
        Prob0031Solution sol = new Prob0031Solution();
        int[] nums = {1, 2, 3};
        sol.nextPermutation(nums);
    }
}
