package leetcode.Prob0109ConvertSortedListtoBinarySearchTree;


import java.util.ArrayList;
import java.util.List;

public class Prob0109Solution {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = ListNodetoArray(head);
        for (Integer i :
                list) {
            System.out.println(i);
        }
        return buildTree(list, 0, list.size() - 1);

    }
    private List<Integer> ListNodetoArray(ListNode head){
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list;
    }

    private TreeNode buildTree(List<Integer> list, int lo, int hi) {
        if (list.isEmpty() || lo > hi) {
            return null;
        }
        int length = hi - lo + 1;
        int middle = length / 2 + lo;

        TreeNode root = new TreeNode(list.get(middle));

        root.left = buildTree(list, lo, middle -1);
        root.right = buildTree(list, middle + 1, hi);

        return root;
    }



}

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

//Definition for a binary tree node.
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