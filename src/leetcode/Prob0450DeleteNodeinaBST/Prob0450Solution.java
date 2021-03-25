package leetcode.Prob0450DeleteNodeinaBST;

public class Prob0450Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        //如果二叉树为空，那么返回为空
        if (root == null) {
            return root;
        }
        //如果根节点就是 key，那么 root 就是要被删除的节点，
        if (root.val == key){
            //当root要被删除，它的左右子树都不为空，那么root=root.left,把右子树挂在root.left的最右叶子节点上
            if (root.left != null && root.right != null){
                TreeNode right = root.right;
                root = root.left;
                TreeNode node = root;
                while (node.right != null){
                    node = node.right;
                }
                node.right = right;
                return root;
            }
            //如果左子树为空，那么返回右子树
            else if (root.left == null) {
                return root.right;
            }
            //同理，如果右子树为空，返回左子树
            else {
                return root.left;
            }
        }
        //如果根节点的值大于 key，那么递归root.left
        if (root.val > key){
            root.left = deleteNode(root.left, key);
        }
        //如果根节点的值小于 key，那么递归root.right
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}