package leetcode.Prob0113PathSumII;

import java.util.*;

public class Prob0113Solution {
    List<List<Integer>> ansList = new ArrayList<>();
    List<Integer> subList = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        pathSumI(root, sum);
        return ansList;
    }
    public void pathSumI(TreeNode root, int sum){
        //如果root为null, 返回false
        if (root == null) return ;
            //root不为null进行继续判断
        else {
            sum -= root.val;
            subList.add(root.val);
            //如果root的左右子树都为空，及root是叶子节点，判断sum和rootVal相等
            if (root.left == null && root.right == null && sum == 0) ansList.add(new ArrayList<>(subList));
            //递归
            pathSumI(root.left, sum);
            pathSumI(root.right, sum);
            subList.remove(subList.size() - 1);
        }
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
