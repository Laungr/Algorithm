package leetcode.Prob0078Subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 与 Prob0077 思路相同，进行回溯。先看 Prob0077
 *
 * @author Okaeri
 */
public class Prob0078Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            helper(result, new ArrayList<>(), nums, i, 0);
        }
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> subList, int[] nums, int k, int start) {
        if (subList.size() == k) {
            result.add(new ArrayList<>(subList));
            return;
        }
        for (int i = start; i < nums.length - (k - subList.size() - 1); i++) {
            subList.add(nums[i]);
            helper(result, subList, nums, k, i + 1);
            subList.remove(subList.size() - 1);
        }
    }
}

class Test {
    public static void main(String[] args) {
        Prob0078Solution sol = new Prob0078Solution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = sol.subsets(nums);
        for (List<Integer> subset : subsets) {
            System.out.println(subset.toString());
        }
    }
}
