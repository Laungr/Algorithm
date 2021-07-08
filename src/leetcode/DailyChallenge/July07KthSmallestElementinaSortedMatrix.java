package leetcode.DailyChallenge;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给出一个 m*n 的二维数组，其中每个数组都是递增排序的，那么在所有的数组中第 k 个元素的值是多少?
 * 暴力解法，直接把二维数组放进一维数组中，然后进行排序
 *
 * @author Okaeri
 */
public class July07KthSmallestElementinaSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] arr = new int[m * n];
        for (int i = 0; i < m; i++) {
            System.arraycopy(matrix[i], 0, arr, i * n, n);
        }
        Arrays.sort(arr);
        return arr[k - 1];
    }
}

class July07Solution2 {
    public int kthSmallest(int[][] matrix, int k) {
        int res = 0;
        // 创建一个优先队列，list 的第一个元素小，就先poll出去，
        // 复写比较方法，以 list 的第一个元素构建最小堆
        PriorityQueue<ArrayList<Integer>> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1.isEmpty()) {
                return 1;
            } else if (o2.isEmpty()) {
                return -1;
            }
            return o1.get(0) - o2.get(0);
        });
        // 把 matrix 的每一行放进优先队列里
        for (int[] ints : matrix) {
            List<Integer> list = Arrays.stream(ints).boxed().collect(Collectors.toList());
            priorityQueue.offer((ArrayList<Integer>) list);
        }
        // 从优先队列里面取元素，去完之后删除链表第一个元素，然后再放进优先队列中去
        // 直到取到第 k 个元素就返回
        while (k > 0) {
            ArrayList<Integer> poll = priorityQueue.poll();
            assert poll != null;
            res = poll.remove(0);
            priorityQueue.offer(poll);
            k--;
        }
        return res;
    }
}

class July007Test {
    public static void main(String[] args) {
        int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        int k = 8;
        July07KthSmallestElementinaSortedMatrix sol = new July07KthSmallestElementinaSortedMatrix();
        System.out.println(sol.kthSmallest(matrix, k));

        July07Solution2 sol2 = new July07Solution2();
        System.out.println(sol2.kthSmallest(matrix, k));
    }
}
