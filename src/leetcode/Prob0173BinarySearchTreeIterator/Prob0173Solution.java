package leetcode.Prob0173BinarySearchTreeIterator;

import java.util.Iterator;

public class Prob0173Solution {
    //BSTIterator it = new BSTIterator(root);

}

class BSTIterator {
    public BSTIterator(TreeNode root) {

    }

    /** @return the next smallest number */
    public int next() {
        return 0;

    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {

        return false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

/**
 * 二叉树的定义
 */
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
