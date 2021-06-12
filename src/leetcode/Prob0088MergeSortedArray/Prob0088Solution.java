package leetcode.Prob0088MergeSortedArray;

import java.util.Arrays;

/**
 * 合并两个有序数组
 * 数组 nums1 的长度足够长，或者说是nums1 的后面一部分是空着的
 *
 * @author Okaeri
 */
public class Prob0088Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums1, 0, nums1, n, m);
        int left = n;
        int right = 0;
        for (int i = 0; i < m + n; i++) {
            if (left == m + n) {
                nums1[i] = nums2[right++];
            } else if (right == n) {
                nums1[i] = nums1[left++];
            } else {
                nums1[i] = nums1[left] <= nums2[right] ? nums1[left++] : nums2[right++];
            }
        }
    }
}

class Test {
    public static void main(String[] args) {
        Prob0088Solution sol = new Prob0088Solution();
        int[] nums1 = {1, 2, 3};
        int m = 3;
        int[] nums2 = {};
        int n = 0;
        sol.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
