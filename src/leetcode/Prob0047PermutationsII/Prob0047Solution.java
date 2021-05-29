package leetcode.Prob0047PermutationsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Prob0047Solution {
    public List<List<Integer>> uniquePermute(int[] nums) {
        // result 是返回的列表
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        // 数组为空直接返回空列表
        if (nums.length == 0) {
            return result;
        }

        // 保证数组是有序的
        Arrays.sort(nums);
        System.out.println("sorted " + Arrays.toString(nums));
        // 如果数组不是空数组，就进行组合
        permute(nums, used, result, new ArrayList<>());
        // 最后返回 result
        return result;
    }

    /**
     * 回溯算法
     * 本身是一个递归应用
     *
     * @param nums    输入的数组
     * @param result  最终返回的结果
     * @param subList 正是一个从头用到尾的列表，给它增加元素和删除元素的
     */
    public void permute(int[] nums, boolean[] used,List<List<Integer>> result, ArrayList<Integer> subList) {
        // 递归出口，如果当前的 subList 长度正确，则是一个合适的结果，将其添加到 result。
        // 简单的做法是在添加到 result 中进行判断，如果已经包含这个 subList 就跳过。
        //
        if (subList.size() == nums.length) {
            // 需要对 subList 做一个深拷贝
            // 变量 subList 所指向的列表 在深度优先遍历的过程中只有一份 ，深度优先遍历完成以后，回到了根结点，成为空列表.
            //在 Java 中，参数传递是 值传递，对象类型变量在传参的过程中，复制的是变量的地址。这些地址被添加到 result 变量，但实际上指向的是同一块内存地址，因此我们会看到 66 个空的列表对象。解决的方法很简单，在 res.add(subList); 这里做一次拷贝即可。
            result.add(new ArrayList(subList));
            return;
        }

        // lastUse 变量表示的是上一个加入 subList 的数字，因为 nums 中有重复的元素，相当于在二叉树的每一层过滤掉重复的元素
        for (int i = 0, lastUse = -101; i < nums.length; i++) {
            int num = nums[i];
            // 如果当前这个元素与上一个加入的元素相同，直接跳过
            // 另一种情况就与 0046 问题中一样，当前位置的元素已经被选过了
            if (lastUse == num ||  used[i]) {
                continue;
            }
            // 加入 subList 之中
            subList.add(num);
            used[i] = true;
            lastUse = num;

            permute(nums, used, result, subList);
            //退回
            subList.remove(subList.size() - 1);
            used[i] = false;
        }
    }
}

/**
 * 包含重复元素的全排列问题
 * 与 Prob0046 相比增加了一个判断是否需要交换的函数
 */
class Prob0047Solution2 {
    public List<List<Integer>> uniquePermute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }

        permute(nums, 0, nums.length - 1, result);
        return result;
    }

    /**
     * @param nums   输入的数组
     * @param cursor 递归遍历到的位置
     * @param k      冗余变量，nums.length - 1，并不需要
     * @param result 返回结果
     */
    public void permute(int[] nums, int cursor, int k, List<List<Integer>> result) {
        if (cursor == k) {
            result.add(Arrays.stream(nums)
                    .boxed()
                    .collect(Collectors.toList()));
        }
        for (int i = cursor; i <= k; i++) {
            if (!needSwap(nums, cursor, i)){
                continue;
            }
            swap(nums, cursor, i);
            permute(nums, cursor + 1, k, result);
            swap(nums, cursor, i);
        }
    }

    public boolean needSwap(int[] array, int cursor, int i) {
        for (int j = cursor ; j < i ; j++) {
            if (array[j] == array[i]){
                return false;
            }
        }
        return true;
    }

    /**
     * 交换数组中的两个位置的元素
     *
     * @param array 输入数组
     * @param p     位置 p
     * @param q     位置 q
     */
    public void swap(int[] array, int p, int q) {
        int temp = array[p];
        array[p] = array[q];
        array[q] = temp;
    }
}

class Test {
    public static void main(String[] args) {
        int[] nums = {2, 2, 0, 2};
        Prob0047Solution sol = new Prob0047Solution();
        Prob0047Solution2 sol2 = new Prob0047Solution2();
        List<List<Integer>> lists = sol.uniquePermute(nums);
        for (List<Integer> list : lists) {
            System.out.println(list.toString());
        }
    }
}
