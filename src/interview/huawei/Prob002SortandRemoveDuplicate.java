package interview.huawei;

import java.util.Random;
import java.util.Scanner;

/**
 * 快排 + 去重
 *
 * @author Okaeri
 */
public class Prob002SortandRemoveDuplicate {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int len = sc.nextInt();
            int[] arr = new int[len];
            for (int i = 0; i < len; i++) {
                arr[i] = sc.nextInt();
            }
            quickSort(arr);
            int count = removeDuplicate(arr);
            for (int i = 0; i <= count; i++) {
                System.out.println(arr[i]);
            }
        }

    }

    private static int removeDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] == nums[slow]) {
                fast++;
            } else {
                nums[++slow] = nums[fast++];
            }
        }
        return slow;
    }

    private static void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int part = randomPartition(nums, lo, hi);
        quickSort(nums, lo, part - 1);
        quickSort(nums, part + 1, hi);
    }

    private static int randomPartition(int[] nums, int lo, int hi) {
        int random = new Random().nextInt(hi - lo + 1) + lo;
        swap(nums, lo, random);
        int pivot = nums[lo];
        int index = lo;
        for (int i = lo + 1; i <= hi; i++) {
            if (nums[i] < pivot) {
                swap(nums, ++index, i);
            }
        }
        swap(nums, lo, index);
        return index;
    }

    private static void swap(int[] nums, int p, int q) {
        int temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;
    }
}

class Solution2{
    public void solution(){
        Scanner sc = new Scanner(System.in);
        int MAX_LENGTH = 1001;
        while (sc.hasNext()){
            int len = sc.nextInt();
            int[] arr = new int[MAX_LENGTH];
            for(int i = 0; i < len; i++) {
                arr[sc.nextInt()] = 1;
            }
            for (int i = 0; i < MAX_LENGTH; i++) {
                if (arr[i] == 1){
                    System.out.println(i);
                }
            }
        }
    }
}
