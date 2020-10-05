package leetcode.Prob0116PopulatingNextRightPointersinEachNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class Prob0116Solution {
    public Node connect(Node root) {
        if (root == null) return null;

        Queue<Node> q = new ArrayDeque<>();
        q.offer(root);
        Node pNode;

        while (!q.isEmpty()){
            int qSize = q.size();
            for (int i = 0; i < qSize; i++){
                pNode = q.poll();
                // 前 qSize - 1 个 node 指向他后面的node，最后一个 node 默认指向 null
                if (i < qSize - 1) pNode.next = q.peek();

                if(pNode.left != null) q.offer(pNode.left);
                if(pNode.right != null) q.offer(pNode.right);
            }

        }
        return root;

    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
