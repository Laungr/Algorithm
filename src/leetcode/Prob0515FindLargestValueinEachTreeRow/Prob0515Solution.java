package leetcode.Prob0515FindLargestValueinEachTreeRow;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class Prob0515Solution {
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) return null;

        List<Integer> ansList = new ArrayList<>();

        ansList.add(root.val);

        TreeNode rootLeft = root.left;
        TreeNode rootRight = root.right;

        return null;
    }


    public int largerChild(TreeNode root){
        if (root.left == null && root.right != null) return root.right.val;
        else if (root.left != null && root.right == null) return root.left.val;
        else return Math.min(root.left.val, root.right.val);
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

