package leetcode.Prob0004MedianofTwoSortedArrays;


// 思路时把两个数组合并为一个数组
public class Prob0004Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if( m == 0) return findMedianSortedArrays(nums2);
        if (n == 0) return findMedianSortedArrays(nums1);


        int[] result = new int[m+n];


        int k = 0;//result数组的索引
        int i = 0;//nums1数组的索引
        int j = 0;//nums2数组的索引

        while(k < result.length) {
            // 当两个数组都还没有索引完，那么新数组取两个中小的那个
            if (i < m && j < n){
                if (nums1[i] <= nums2[j]){
                    result[k++] = nums1[i++];
                }
                else {
                    result[k++] = nums2[j++];
                }
            }
            // 当两个数组有其中一个已经索引完，那么只取另一个数组的值
            else if (i == m){
                result[k++] = nums2[j++];
            }
            else result[k++] = nums1[i++];
        }
        return findMedianSortedArrays(result);


    }


    // 考虑数组的长度为奇数和偶数，返回其中位数
    public static double findMedianSortedArrays(int[] nums){
        int m = nums.length;
        if ((m % 2) == 0) return ((double)nums[m/2-1] + (double)nums[m/2])/2;
        else return nums[m/2];

    }
}

class Test{
    public static void main(String[] args) {
        int[] a1 = {1, 3};
        int[] a2 = {2};
        double res = Prob0004Solution.findMedianSortedArrays(a1, a2);
        System.out.println(res);
    }
}
