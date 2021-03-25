package leetcode.Prob0230KthSmallestElementinaBST;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * BST 的中序遍历是递增的，第 k 个数，就是结果
 */
public class Prob0230Solution {
    public int kthSmallest(TreeNode root, int k) {

        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);

        return list.get(k - 1);
    }

    private void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }
}

/**
 * 使用迭代的方式，打印第 k 个元素时就退出，打印完成
 */
 class Prob0230Solution2 {
     public int kthSmallest(TreeNode root, int k) {
         Stack<TreeNode> stack = new Stack<>();
         TreeNode node = root;
         while (node != null || !stack.isEmpty()){
             if (node != null){
                 stack.push(node);
                 node = node.left;
             }

             else {
                 node = stack.pop();
                 if (k-- == 1){
                     break;
                 }
                 node = node.right;
             }
         }
         return node.val;
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
