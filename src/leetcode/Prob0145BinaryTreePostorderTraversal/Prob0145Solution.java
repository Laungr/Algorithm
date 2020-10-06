package leetcode.Prob0145BinaryTreePostorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树后序遍历的递归写法
 */
public class Prob0145Solution {
    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        postorderTraversal(root, result);
        return result;
    }

    public void postorderTraversal(TreeNode root, List<Integer> list){
        if (root == null) return;

        postorderTraversal(root.left, list);
        postorderTraversal(root.right, list);
        list.add(root.val);
    }

}

/**
 * 二叉树后序遍历的迭代写法
 */
class Prob0145Solution2{
     List<Integer> result = new ArrayList<>();
     public List<Integer> postorderTraversal(TreeNode root) {
         if (root == null) return result;

         Stack<TreeNode> s = new Stack<>();
         TreeNode p = root;
         TreeNode lastVisit = root;

         while (p != null || !s.isEmpty()){
             while (p != null) {
                 s.push(p);
                 p = p.left;
             }
             p = s.peek();
             if (p.right == null || p.right == lastVisit){
                 result.add(p.val);
                 lastVisit = p;
                 s.pop();
                 p = null;
             }
             else{
                 p = p.right;
             }
         }
         return result;
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

