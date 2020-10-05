package leetcode.Prob0114FlattenBinaryTreetoLinkedList;


public class Prob0114Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;

        else {
            // 如果左子树不为空，把整个左子树加在root ~ root.right之间
            if (root.left != null) {
                TreeNode p = root.left;
                while (p.right != null) {
                    p = p.right;
                }
                TreeNode tmp = root.right;
                root.right = root.left;
                root.left = null;
                p.right = tmp;
            }
            // 如果左子树为空，那么就递归到root的右子树
            flatten(root.right);
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
