package leetcode.Prob0589NaryTreePreorderTraversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * n 叉树的先序遍历
 *
 * @author Okaeri
 */
public class Prob0589Solution {
    public List<Integer> iterationPreorder(Node root) {
        List<Integer> res = new ArrayList<>();
        Deque<Node> stack = new ArrayDeque<>();

        if (root == null) {
            return res;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            res.add(node.val);
            List<Node> children = node.children;
            for (int i = children.size() - 1; i >= 0; i--) {
                stack.push(children.get(i));
            }
        }
        return res;
    }
}

/**
 * n 叉树的前序遍历递归实现
 */
class RecursionPreorder {
    public List<Integer> recursionPreorder(Node root) {
        List<Integer> res = new ArrayList<>();
        recursionPreorder(root, res);
        return res;
    }

    public void recursionPreorder(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        List<Node> children = root.children;
        for (Node child : children) {
            recursionPreorder(child, list);
        }
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