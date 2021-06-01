package leetcode.Prob0056MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 区间合并
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 * @author Okaeri
 */
public class Prob0056Solution {
    /**
     * 无法实时更新 list.size() 导致被merge
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        List<List<Integer>> list = new ArrayList<>(intervals.length);

        for (int[] interval : intervals) {
            List<Integer> addList2 = new ArrayList<>(2);
            addList2.add(interval[0]);
            addList2.add(interval[1]);
            list.add(addList2);

        }
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                merge(list, i, j);
            }
        }
        System.out.println(list.toString());
        return new int[][]{};
    }

    private void merge(List<List<Integer>> lists, int p, int q) {
        List<Integer> listp = lists.get(p);
        List<Integer> listq = lists.get(q);
        // listp 开口小
        if (listp.get(0) <= listq.get(0)) {
            if (listp.get(1) < listq.get(0)) {
                return;
            } else {
                lists.remove(q);
                List<Integer> addList = new ArrayList<>(2);
                addList.add(listp.get(0));
                addList.add(listq.get(1));
                lists.add(p, addList);
            }
            System.out.println(lists);
        }
        // listq 开口小
        else {
            if (listq.get(1) < listp.get(0)) {
                return;
            } else {
                lists.remove(q);
                List<Integer> addList = new ArrayList<>(2);
                addList.add(listp.get(0));
                addList.add(listq.get(1));
                lists.add(p, addList);
            }
        }
    }
}

class Prob0056Solution2 {
    public int[][] merge(int[][] intervals) {
        // 二维数组排序，排序的 compactor 是第一轮元素的大小
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> list = new ArrayList<>();
        for (int[] interval : intervals) {
            int left = interval[0];
            int right = interval[1];
            if (list.size() == 0 || list.get(list.size() - 1)[1] < left) {
                list.add(new int[]{left, right});
            } else {
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], right);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}

class Test {
    public static void main(String[] args) {
        Prob0056Solution2 sol = new Prob0056Solution2();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] intervals2 = {{1, 4}, {2, 3}};
        int[][] merge = sol.merge(intervals2);

        for (int[] ints : merge) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
