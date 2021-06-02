package leetcode.Prob0057InsertInterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 插入区间，初始提供的区间是按起始位置的大小升序排序的
 *
 * @author Okaeri
 */
public class Prob0057Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }
        int[][] result = new int[intervals.length + 1][2];
        int index = 0;
        // 作为 newInterval 是否已经被插入的标志
        boolean used = false;
        // 把 newInterval 按序插入到 intervals 中去
        while (index < intervals.length) {
            if (!used) {
                if (intervals[index][0] < newInterval[0]) {
                    result[index] = intervals[index];
                } else {
                    result[index] = newInterval;
                    used = true;
                }
            } else {
                result[index] = intervals[index - 1];
            }
            index++;
        }
        result[index] = used ? intervals[index - 1] : newInterval;
        // 合并区间
        return merge(result);
    }

    /**
     * 输入的二维数组有序
     *
     * @param intervals 输入的数组
     * @return 合并之后的结果
     */
    private int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        // 双指针，左指针小的情况下，仅移动右指针，右指针取较大值；左指针变大的情况下，将前一个闭区间加入列表,加入之后更新左右指针
        int left = intervals[0][0];
        int right = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            // 如果可以 merge，right 往右移
            if (right >= intervals[i][0]) {
                right = Math.max(intervals[i][1], right);
            } else {
                list.add(new int[]{left, right});
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }
        list.add(new int[]{left, right});
        return list.toArray(new int[list.size()][2]);
    }
}

class Test {
    public static void main(String[] args) {
        Prob0057Solution sol = new Prob0057Solution();
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        int[][] insert = sol.insert(intervals, newInterval);
        for (int[] ints : insert) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
