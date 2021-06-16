package leetcode.Prob1053PreviousPermutationWithOneSwap;

/**
 * 按字典序的前一个排列。如果是第 0 个，就直接返回
 */
public class Prob1053Solution {
    public int[] prevPermOpt1(int[] arr) {
        int index = 0;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                index = i;
                break;
            }
        }
        int min = 0;
        int swapIndex = 0;
        for (int i = index + 1; i < arr.length; i++) {
            if (arr[i] < arr[index] && arr[i] > min) {
                min = arr[i];
                swapIndex = i;
            }
        }
        swap(arr, index, swapIndex);
        return arr;
    }

    private void swap(int[] arr, int p, int q) {
        int temp = arr[p];
        arr[p] = arr[q];
        arr[q] = temp;
    }
}
