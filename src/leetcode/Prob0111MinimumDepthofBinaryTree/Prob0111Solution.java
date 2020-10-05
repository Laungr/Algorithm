package leetcode.Prob0111MinimumDepthofBinaryTree;

public class Prob0111Solution {
    public int minDepth(TreeNode root) {
        //如果root为null，0
        if(root == null) return 0;
            //否则，现在minDepth加1
        else {
            if (root.left == null && root.right == null) return 1;
            else if(root.left == null) return minDepth(root.right) + 1;
            else if(root.right == null) return minDepth(root.left) + 1;
            else {
                return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
            }
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

