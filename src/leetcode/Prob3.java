package leetcode;

import sun.reflect.generics.tree.Tree;

import java.util.Stack;

/**
 * @author
 *
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */


public class Prob3 {


}

class PreOrderTranverse {
    TreeNode root;

    public void preOrderTransverse() {
        Stack<TreeNode> treeNodeStack = new Stack<>();
        while (root != null || !treeNodeStack.isEmpty()) {
            if (root != null){
                System.out.println(root.val);
            }

            if (root.right != null) {
                treeNodeStack.push(root.right);
            }

            if (root.left == null){
                root = treeNodeStack.pop();
            }
            else {
                root = root.left;
            }

        }
    }
}

class TreeNode{
    int val;

    TreeNode(int x){
        this.val = x;
    }

    TreeNode left;

    TreeNode right;
}
