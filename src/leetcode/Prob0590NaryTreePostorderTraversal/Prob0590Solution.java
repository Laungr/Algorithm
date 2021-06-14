package leetcode.Prob0590NaryTreePostorderTraversal;

import java.util.*;

/**
 * n 叉树的后续遍历
 * 迭代方法
 *
 * @author Okaeri
 */
public class Prob0590Solution {
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> res = new LinkedList<>();
        Deque<Node> stack = new ArrayDeque<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            Node popNode = stack.pop();
            res.addFirst(popNode.val);
            for (Node child : popNode.children) {
                if (child != null) {
                    stack.push(child);
                }
            }
        }

        return res;
    }
}

/**
 * 递归方法
 */
class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    private void postorder(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        List<Node> children = root.children;
        for (Node child : children) {
            postorder(child, list);
        }
        list.add(root.val);
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
