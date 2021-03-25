package leetcode.Prob0538ConvertBSTtoGreaterTree;

import java.util.Stack;

/**
 * 思路：BST 的中序遍历是递增的，要把 BST 的每个节点的值更新为不小于该节点数值的总和；
 * 相当于从中序遍历的最后一个值往前，类加上当前节点值即可。
 */

public class Prob0538Solution {
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        //定义一个 stack，这个 stack 中以中序遍历压入每个节点的值
        Stack<Integer> stack = new Stack<>();
        inorderTanversal(root, stack);

        //定义一个greaterSumStack，压入 stack 的前 n 个pop 出来数值的和
        Stack<Integer> greaterSumStack = new Stack<>();
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
            greaterSumStack.push(sum);
        }

        //中序遍历 root，并赋新的值给二叉树
        assignGreaterSum(root, greaterSumStack);

        return root;
    }

    private void inorderTanversal(TreeNode root, Stack<Integer> stack) {
        if (root == null) {
            return;
        }
        inorderTanversal(root.left, stack);
        stack.push(root.val);
        inorderTanversal(root.right, stack);

    }

    private void assignGreaterSum(TreeNode root, Stack<Integer> stack) {
        if (root == null || stack.isEmpty()) {
            return;
        }
        assignGreaterSum(root.left, stack);
        root.val = stack.pop();
        assignGreaterSum(root.right, stack);
    }

}


/**
 * 优化了第一种解法，stack 中直接存储节点
 */
class Prob0538Solution2 {
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        //定义一个 stack，这个 stack 中以中序遍历压入每个节点
        Stack<TreeNode> stack = new Stack<>();
        inorderTanversal(root, stack);

        int sum = 0;
        //节点从栈中弹出，并且重新赋值
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            sum += pop.val;
            pop.val = sum;
        }
        return root;
    }

    private void inorderTanversal(TreeNode root, Stack<TreeNode> stack) {
        if (root == null) {
            return;
        }
        inorderTanversal(root.left, stack);
        stack.push(root);
        inorderTanversal(root.right, stack);

    }
}

/**
 * 反中序遍历，有点东西哦
 */
class Prob0538Solution3 {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
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
