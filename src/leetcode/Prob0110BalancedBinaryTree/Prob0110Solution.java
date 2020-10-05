package leetcode.Prob0110BalancedBinaryTree;

public class Prob0110Solution {
    public boolean isBalanced(TreeNode root) {
        if  (root == null) return true;

        //左、右子树的最大深度，如果相差大于1返回false直接结束 否则递归，判断其左右子树
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        if(Math.abs(leftDepth - rightDepth) > 1) return false;

        else return isBalanced(root.left) && isBalanced(root.right);

    }
    //二叉树的最大深度
    public int maxDepth(TreeNode root){
        if (root == null) return 0;
        else return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
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
