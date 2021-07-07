package leetcode.DailyChallenge;

import java.util.*;

/**
 * 给出一个数组，其长度是偶数，要求选出数组中的几个数字，被选中的数字都要剔除掉，要使得至少一半的元素被剔除掉，需要选择多少个元素
 *
 * @author Okaeri
 */
public class July07ReduceArraySizetoTheHalf {
    public int minSetSize(int[] arr) {
        int len = arr.length;
        // 把数组中每个数字出现的次数放在 map 中
        HashMap<Integer, Integer> map = new HashMap<>(len);
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        // list 中存放每个数字出现的次数，并进行排序
        List<Integer> list = new ArrayList<>(map.values());
        // list 进行降序排序
        list.sort((o1, o2) -> o2 - o1);
        int res = 0;
        int target = len / 2;
        // 从前往后遍历 list，也就是从大到小，如果target <= 0 了，说明已经 remove 一半以上的元素了
        for (Integer integer : list) {
            if (target <= 0) {
                break;
            }
            target -= integer;
            res++;
        }
        return res;
    }
}


class July07Test {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        July07ReduceArraySizetoTheHalf sol = new July07ReduceArraySizetoTheHalf();
        int i = sol.minSetSize(arr);
        System.out.println(i);

    }
}