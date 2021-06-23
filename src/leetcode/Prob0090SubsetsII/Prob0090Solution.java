package leetcode.Prob0090SubsetsII;


import java.util.*;

/**
 * 官方解法
 *
 * @author Okaeri
 */
public class Prob0090Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backTrack(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private void backTrack(List<List<Integer>> res, List<Integer> subList, int[] nums, int start) {
        res.add(new ArrayList<>(subList));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            subList.add(nums[i]);
            backTrack(res, subList, nums, i + 1);
            subList.remove(subList.size() - 1);
        }
    }
}

/**
 * 回溯算法，用了 HashSet 去重，简单粗暴
 */
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> set = new HashSet<>();
        backTrack(set, new ArrayList<>(), nums, 0);
        List<List<Integer>> res = new ArrayList<>(set);
        res.add(new ArrayList<>());
        return res;
    }

    private void backTrack(HashSet<List<Integer>> res, List<Integer> subList, int[] nums, int start) {
        if (start == nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            subList.add(nums[i]);
            res.add(new ArrayList<>(subList));
            backTrack(res, subList, nums, i + 1);
            subList.remove(subList.size() - 1);
        }
    }
}

class Test {
    public static void main(String[] args) {
        Prob0090Solution sol = new Prob0090Solution();
        int[] nums = {1, 2, 2, 2};
        List<List<Integer>> lists = sol.subsetsWithDup(nums);
        for (List<Integer> list : lists) {
            System.out.println(list.toString());
        }

    }
}
