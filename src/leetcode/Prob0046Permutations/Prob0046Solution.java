package leetcode.Prob0046Permutations;

import java.util.*;

public class Prob0046Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) return result;

        combinationSum(nums, result, new ArrayList<>());

        return result;
    }

    public void combinationSum(int[] nums, List<List<Integer>> result, ArrayList<Integer> subList) {
        if (subList.size() >= nums.length){
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!subList.contains(nums[i]))
                subList.add(nums[i]);
            //System.out.println("subList添加了 "+candidates[i]+"    现在是 "+subList.toString());
            if (subList.size() == nums.length){
                result.add(new ArrayList(subList));
                //System.out.println("有一个满足的是: "+ subList.toString());
            }
            combinationSum(nums, result, subList);
            //System.out.print("剪枝了： "+ subList.get(subList.size() - 1));
            subList.remove(subList.size() - 1);
            //System.out.println( "  剪枝后 "+ subList.toString() );
        }
    }
}

class Test{
    public static void main(String[] args) {
        int[] nums = {2,3,5};
        Prob0046Solution solve = new Prob0046Solution();
        List<List<Integer>> lists = solve.permute(nums);
        for (List<Integer> list : lists) {
            System.out.println(list.toString());
        }
    }
}
