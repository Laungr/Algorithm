package leetcode.Prob0429NaryTreeLevelOrderTraversal;

import java.util.*;

/**
 * n 叉树的层次遍历
 * BFS
 *
 * @author Okaeri
 */

public class Prob0429Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        // queue 不能实例化成优先队列
        Queue<Node> queue = new ArrayDeque<>();
        if (root == null) {
            return res;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> addList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                addList.add(poll.val);
                List<Node> children = poll.children;
                for (Node child : children) {
                    queue.offer(child);
                }
            }
            res.add(new ArrayList<>(addList));
        }
        return res;
    }
}

/**
 * n 叉树的定义
 */
class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
