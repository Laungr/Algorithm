package leetcode.Prob0112PathSum;

public class Prob0112Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        //如果root为null, 返回false
        if (root == null) return false;
            //root不为null进行继续判断
        else {
            sum -= root.val;
            //如果root的左右子树都为空，及root是叶子节点，判断sum和rootVal相等
            if (root.left == null && root.right == null) return sum == 0;
                //其中一个子树为空，不是叶子节点，在另一条子树上递归
            else if (root.left == null) return hasPathSum(root.right, sum);
            else if(root.right == null) return hasPathSum(root.left, sum);
                //两个子树都不为空，在左右子树中查找，注意应为或
            else return hasPathSum(root.right, sum) || hasPathSum(root.left, sum);
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