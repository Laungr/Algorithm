package leetcode.Prob0046Permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prob0046Solution {
    public List<List<Integer>> permute(int[] nums) {
        // result 是返回的列表
        List<List<Integer>> result = new ArrayList<>();
        // 数组为空直接返回空列表
        if (nums.length == 0) {
            return result;
        }
        // 如果数组不是空数组，就进行组合
        combinationSum(nums, result, new ArrayList<>());
        // 最后返回 result
        return result;
    }

    /**
     * 回溯算法
     * 本身是一个递归应用
     * @param nums 输入的数组
     * @param result 最终返回的结果
     * @param subList 正是一个从头用到尾的列表，给它增加元素和删除元素的
     */
    public void combinationSum(int[] nums, List<List<Integer>> result, ArrayList<Integer> subList) {
        // 递归出口，如果当前的 subList 长度正确，则是一个合适的结果，将其添加到 result
        if (subList.size() == nums.length) {
            // 需要对 subList 做一个深拷贝
            // 变量 subList 所指向的列表 在深度优先遍历的过程中只有一份 ，深度优先遍历完成以后，回到了根结点，成为空列表.
            //在 Java 中，参数传递是 值传递，对象类型变量在传参的过程中，复制的是变量的地址。这些地址被添加到 result 变量，但实际上指向的是同一块内存地址，因此我们会看到 66 个空的列表对象。解决的方法很简单，在 res.add(subList); 这里做一次拷贝即可。
            result.add(new ArrayList(subList));
//            result.add(subList);
            return;
        }

        // 
        for (int num : nums) {
            if (subList.contains(num)) {
                continue;
            }
            subList.add(num);
            combinationSum(nums, result, subList);
            // 剪枝
            subList.remove(subList.size() - 1);
        }
    }
}

class Test {
    public static void main(String[] args) {
        int[] nums = {2, 3, 5};
        Prob0046Solution solve = new Prob0046Solution();
        List<List<Integer>> lists = solve.permute(nums);
        for (List<Integer> list : lists) {
            System.out.println(list.toString());
        }
    }
}
