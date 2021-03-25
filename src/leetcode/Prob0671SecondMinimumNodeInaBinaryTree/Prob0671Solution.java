package leetcode.Prob0671SecondMinimumNodeInaBinaryTree;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 因为考虑到有重复的数字，所以用HashSet来接收遍历结果
 */
public class Prob0671Solution {
    public int findSecondMinimumValue(TreeNode root) {
        HashSet<Integer> set = new HashSet<>();
        traversal(root, set);

        Object[] objects = set.toArray();
        Arrays.sort(objects);

        return objects.length > 1 ? (int) objects[1] : -1;
    }
    
    private void traversal(TreeNode root, HashSet<Integer> set){
        if (root == null) {
            return;
        }
        set.add(root.val);
        traversal(root.left, set);
        traversal(root.right, set);
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
