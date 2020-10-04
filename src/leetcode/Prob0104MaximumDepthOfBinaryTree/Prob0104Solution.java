package leetcode.Prob0104MaximumDepthOfBinaryTree;

/**
 * 递归解法
 *
 */
public class Prob0104Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        else return maxDepth(root.left, root.right) + 1;
    }
    public int maxDepth(TreeNode p, TreeNode q){
        if (p == null && q == null) return 0;
        else if (p == null) return maxDepth(q);
        else if (q == null) return maxDepth(p);
        else  return Math.max(maxDepth(p.left, p.right) + 1, maxDepth(q.left, q.right) + 1);
    }

}

/**
 * 更精简的递归写法 nb！
 */
class Prob0104Solution2{
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        else {
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
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
