package leetcode.Prob0039CombinationSum;

import java.util.*;

public class Prob0039Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<List<Integer>> result = new HashSet<>();

        if (candidates.length == 0) return new ArrayList<>();

        combinationSum(candidates, target, result, new ArrayList<>());

        return new ArrayList<>(result);

    }

    private void combinationSum(int[] candidates, int target, Set<List<Integer>> result, ArrayList<Integer> subList) {
        if (target <= 0) {
            return;
        }
        for (int candidate : candidates) {
            subList.add(candidate);
            if (target == candidate) {
                List<Integer> addList = new ArrayList<>(subList);
                Collections.sort(addList);
                result.add(new ArrayList<>(addList));
            }
            combinationSum(candidates, target - candidate, result, subList);
            subList.remove(subList.size() - 1);
        }
    }
}

class Test{
    public static void main(String[] args) {
        int[] nums = {2,3,5};
        Prob0039Solution solve = new Prob0039Solution();
        List<List<Integer>> lists = solve.combinationSum(nums, 8);
        for (List<Integer> list : lists) {
            System.out.println(list.toString());

        }
    }
}
