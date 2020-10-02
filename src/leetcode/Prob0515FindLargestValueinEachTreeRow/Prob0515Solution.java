package leetcode.Prob0515FindLargestValueinEachTreeRow;

import java.util.ArrayList;
import java.util.List;

public class Prob0515Solution {
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) return null;

        List<Integer> numList = new ArrayList<>();


        return null;
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

