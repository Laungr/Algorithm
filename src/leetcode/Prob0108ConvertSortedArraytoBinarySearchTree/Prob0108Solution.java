package leetcode.Prob0108ConvertSortedArraytoBinarySearchTree;

/**
 * 借鉴了Prob0106的解题思路，进行递归
 */
public class Prob0108Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        int N = nums.length;
        return sortedArrayToBST(nums, 0, N - 1);
    }
    public TreeNode sortedArrayToBST(int[] nums, int lo, int hi){
        if(lo > hi) return null;
        int mid = lo + (hi - lo)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, lo, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, hi);

        return root;
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
