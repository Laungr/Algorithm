package leetcode.Prob0101SymmetricTree;


import java.util.*;

/**
 * 迭代解法，与递归解法思路一样，用BFS来遍历
 */
public class Prob0101Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }
}

/**
 * 递归解法
 */
class Prob0101Solution2{
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        else return isSymmetric(root.left, root.right);
    }
    //对称二叉树的特征是：左右子树值相等，且左子树的左节点==右子树的右节点&& 左子树的右节点==右子树的左节点
    public boolean isSymmetric(TreeNode p, TreeNode q){
        if (p == null && q == null) return true;
        else if (p == null || q == null) return false;
        else if(p.val != q.val) return false;
        else return isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
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
