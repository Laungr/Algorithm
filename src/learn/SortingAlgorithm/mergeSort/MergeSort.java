package learn.SortingAlgorithm.mergeSort;

import java.util.Arrays;
import java.util.Random;

/**
 * 归并排序的两种实现方法
 *
 * @author Okaeri
 */
public class MergeSort {
    private int[] aux;

    public void mergeSort(int[] a) {
        aux = new int[a.length];
        mergeSort(a, 0, a.length - 1);
    }

    private void mergeSort(int[] a, int lo, int hi) {
        // 递归出口
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        mergeSort(a, lo, mid);
        mergeSort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    //[lo, mid],[mid + 1， hi] 已经是排好序的数组，将它们合并在一起
    private void merge(int[] a, int lo, int mid, int hi) {
        // 新建一个数组辅助空间，把要合并的区间内的值赋值到辅助数组中取
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        // 已经排好序的两个数组的起始
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (aux[i] <= aux[j]) {
                a[k] = aux[i++];
            } else {
                a[k] = aux[j++];
            }
        }
    }
}

/**
 * 归并排序的迭代方法
 */
class MergeSortBU{
    private int[] aux;
    public void mergeSort(int[] a){
        int len = a.length;
        aux = new int[a.length];
        for(int sz = 1; sz < len; sz += sz){
            for(int lo = 0; lo <len - sz; lo += sz + sz){
                merge(a, lo, lo + sz -1, Math.min(lo + sz + sz - 1, len - 1));
            }
        }
    }
    //[lo, mid],[mid + 1， hi] 已经是排好序的数组，将它们合并在一起

    private void merge(int[] a, int lo, int mid, int hi) {
        // 新建一个数组辅助空间，把要合并的区间内的值赋值到辅助数组中取
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        // 已经排好序的两个数组的起始
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (aux[i] <= aux[j]) {
                a[k] = aux[i++];
            } else {
                a[k] = aux[j++];
            }
        }
    }
}

class Test {
    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        int[] nums = new int[10];
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(1000);
        }
        System.out.println(Arrays.toString(nums));

        sort.mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}