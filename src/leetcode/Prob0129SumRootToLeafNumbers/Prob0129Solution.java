package leetcode.Prob0129SumRootToLeafNumbers;

import java.util.ArrayList;
import java.util.List;

public class Prob0129Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        int result = 0;

        List<List<Integer>> pathList = new ArrayList<>();
        dfs(root, new ArrayList<>(), pathList);

        for (List<Integer> integers : pathList) {
            result += listToInt(integers);
        }
        return result;

    }

    /**
     * Prob0113Solution 获取每个path并加入到list当中
     * @param root root节点
     * @param list 回溯用的list
     * @param resultList 返回的结果
     */
    public void dfs(TreeNode root, List<Integer> list, List<List<Integer>> resultList){
        if (root == null) return;

        // 在list中加入root.val
        list.add(root.val);
        // 如果是叶子节点，那么就把list加入resultList
        // 移除list中的最后一个元素
        if (root.left == null && root.right == null) {
            resultList.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        // 否则就递归到左子树和右子树
        dfs(root.left, list, resultList);
        dfs(root.right, list, resultList);
        list.remove(list.size() - 1);

    }

    /**
     * 输入一个list，返回它从左往右读的十进制数字
     * @param list 输入的list
     * @return 返回int数值
     */
    public int listToInt(List<Integer> list){
        if (list.isEmpty()){
            throw new RuntimeException("列表为空");
        }
        int result = 0;
        for (Integer integer : list) {
            result = result * 10 + integer;
        }
        return result;
    }
}

class Prob0129Solution2{
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        int result = 0;

        // subSumList 就是每个path的从根到叶的和的集合
        List<Integer> subSumList = new ArrayList<>();
        dfs(root, 0, subSumList);

        for (Integer integer : subSumList) {
            result += integer;
        }
        return result;

    }

    /**
     *
     * @param root 根节点
     * @param subSum 每个path的和
     * @param resultList 所有subSum的集合
     */

    public void dfs(TreeNode root,int subSum, List<Integer> resultList){
        if (root == null) return;

        subSum = subSum*10 + root.val;
        // 如果是叶子节点，那么就把subSum加入resultList
        // 移除list中的最后一个元素
        if (root.left == null && root.right == null) {
            resultList.add(subSum);
            //加到list之后，对subSum取模
            subSum /= 10;
            return;
        }
        // 否则就递归到左子树和右子树
        dfs(root.left, subSum, resultList);
        dfs(root.right, subSum, resultList);
        // 对subSum取模
        subSum /= 10;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

