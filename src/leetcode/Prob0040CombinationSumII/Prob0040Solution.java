package leetcode.Prob0040CombinationSumII;


import java.util.*;

public class Prob0040Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> result = new HashSet<>();
        // 如果预备数组为空，或者target值为0，返回一个空的list
        if (candidates.length == 0 || target < 0) return new ArrayList<>();

        // 对预备数组进行排序，方便如果target小于预备数组只，直接return
        Arrays.sort(candidates);

        backTrack(candidates, target, result, 0, new ArrayList<>());
        return new ArrayList<>(result);
    }

    public void backTrack(int[] candidates, int target, Set<List<Integer>> result, int start, List<Integer> subList){
        // 如果target < 该索引到的预设数组的值，就直接return
        if (start < candidates.length && target < candidates[start]){
            return;
        }

        for (int i = start; i < candidates.length; i++){
            subList.add(candidates[i]);
            if (target == candidates[i]) result.add(new ArrayList<>(subList));
            backTrack(candidates, target - candidates[i], result, i + 1, subList);
            subList.remove(subList.size() - 1);
        }
    }

}

class Test{
    public static void main(String[] args) {
        int[] nums = {2,3,5};
        int[] nums1 = {10,1,2,7,6,1,5};
        int[] nums2 = {2,5,2,1,2};
        Prob0040Solution solve = new Prob0040Solution();
        List<List<Integer>> lists = solve.combinationSum2(nums1, 30);
        for (List<Integer> list : lists) {
            System.out.println(list.toString());
        }
    }
}

