package learn.SortingAlgorithm.quickSort;

/**
 * 快速排序 递归
 *
 * @author Okaeri
 */
public class QuickSort {
    public void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int partition = partition(arr, lo, hi);
        quickSort(arr, lo, partition - 1);
        quickSort(arr, partition + 1, hi);
    }

    /**
     * partition 以左的元素都是小于 pivot
     * @param arr 输入数组
     * @param lo 下界
     * @param hi 上界
     * @return partition
     */
    private int partition(int[] arr, int lo, int hi) {
        int pivot = arr[lo];
        int index = lo;
        for (int i = lo + 1; i <= hi; i++) {
            if (arr[i] < pivot) {
                swap(arr, i, ++index);
            }
        }
        //最后一交换，以左是小于的，以右大于等于的
        swap(arr, lo, index);
        return index;
    }

    private void swap(int[] arr, int p, int q) {
        int temp = arr[p];
        arr[p] = arr[q];
        arr[q] = temp;
    }
}