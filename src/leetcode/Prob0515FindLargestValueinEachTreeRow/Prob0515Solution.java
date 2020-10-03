package leetcode.Prob0515FindLargestValueinEachTreeRow;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Prob0515Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ansList = new ArrayList<>();
        if (root == null) return ansList;

        Queue<TreeNode> treeNodeQueue = new ArrayDeque<>();
        treeNodeQueue.offer(root);
        TreeNode pNode;

        while (!treeNodeQueue.isEmpty()) {
            //每一层的节点的数量，就是queue的数量
            int levelSize = treeNodeQueue.size();
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < levelSize; i++) {
                pNode = treeNodeQueue.poll();
                max = Math.max(max, pNode.val);
                if (pNode.left != null) {
                    treeNodeQueue.offer(pNode.left);
                }
                if (pNode.right != null) {
                    treeNodeQueue.offer(pNode.right);
                }
            }
            ansList.add(max);
        }
        return ansList;
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

