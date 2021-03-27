package leetcode.Prob0098ValidateBinarySearchTree;

import java.util.Stack;

/**
 * 中序遍历，如果不是递增则 return false；
 */
public class Prob0098Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        long lastPopVal = Long.MIN_VALUE;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            if (node.val <= lastPopVal) {
                return false;
            } else {
                lastPopVal = node.val;
            }
            node = node.right;

        }

        return true;
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

