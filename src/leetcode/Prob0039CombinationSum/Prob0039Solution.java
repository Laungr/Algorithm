package leetcode.Prob0039CombinationSum;

import java.util.*;

/**
 * @author Okaeri
 */
public class Prob0039Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<List<Integer>> result = new HashSet<>();

        if (candidates.length == 0) {
            return new ArrayList<>();
        }

        combinationSum(candidates, target, result, new ArrayList<>());

        return new ArrayList<>(result);

    }

    public void combinationSum(int[] candidates, int target, Set<List<Integer>> result, ArrayList<Integer> subList) {
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

class Prob0039Solution2 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates.length == 0) {
            return result;
        }

        combinationSum(candidates, target, 0, result, new ArrayList<>());

        return result;
    }

    public void combinationSum(int[] candidates, int target, int start, List<List<Integer>> result, ArrayList<Integer> subList) {
        if (target <= 0) {
            return;
        }

        // start 是关键，不会取到重复值了
        for (int i = start; i < candidates.length; i++) {
            subList.add(candidates[i]);
            System.out.println("subList添加了 " + candidates[i] + "    现在是 " + subList);
            if (target == candidates[i]) {
                result.add(new ArrayList<>(subList));
                System.out.println("有一个满足的是: " + subList);
            }
            combinationSum(candidates, target - candidates[i], i, result, subList);
            System.out.print("剪枝了： " + subList.get(subList.size() - 1));
            subList.remove(subList.size() - 1);
            System.out.println("  剪枝后 " + subList);
        }
    }
}

class Test {
    public static void main(String[] args) {
        int[] nums = {2, 3, 5};
        Prob0039Solution2 solve = new Prob0039Solution2();
        Solution sol = new Solution();
        List<List<Integer>> lists = sol.combinationSum(nums, 8);
        for (List<Integer> list : lists) {
            System.out.println(list.toString());
        }
    }
}

/**
 * 用回溯算法
 */
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(candidates, target, result, new ArrayList<>());
        return result;

    }

    private void combinationSum(int[] candidates, int target, List<List<Integer>> result, List<Integer> subList) {
        // 递归出口
//        if (target < 0) {
//            return;
//        }
        //递归出口
        if (target == 0) {
            List<Integer> addList = new ArrayList<>(subList);
            Collections.sort(addList);
            if (!result.contains(addList)){
                result.add(addList);
            }
            return;
        }

        for (int candidate : candidates) {
            if (target < candidate) {
                return;
            }
            subList.add(candidate);
            target = target - candidate;
            combinationSum(candidates, target, result, subList);
            int last = subList.get(subList.size() - 1);
            subList.remove(subList.size() - 1);
            target = target + last;
        }
    }
}
