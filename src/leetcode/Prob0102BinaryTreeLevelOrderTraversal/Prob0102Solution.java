package leetcode.Prob0102BinaryTreeLevelOrderTraversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Prob0102Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ansList = new ArrayList<>();
        //如果root为null，返回空列表
        if (root == null) return ansList;

        //层次遍历，使用queue，压入root
        Queue<TreeNode> treeNodeQueue = new ArrayDeque<>();
        treeNodeQueue.offer(root);

        while (!treeNodeQueue.isEmpty()){
            //levelList，每层所有node的val的集合
            List<Integer> levelList = new ArrayList<>();
            //借用treeNodeQueue的大小size，刚好与每层levelList的长度一致
            int queueSize = treeNodeQueue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode pollNode = treeNodeQueue.poll();
                levelList.add(pollNode.val);
                if (pollNode.left != null) treeNodeQueue.offer(pollNode.left);
                if (pollNode.right != null) treeNodeQueue.offer(pollNode.right);
            }
            ansList.add(levelList);
        }
        return ansList;
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