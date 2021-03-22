package leetcode.Prob0092ReverseLinkedListII;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Prob0092Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) {
            return null;
        }

        Stack<Integer> stack = new Stack<>();
        Queue<Integer> preQ = new ArrayDeque<>();
        Queue<Integer> tailQ = new ArrayDeque<>();

        int cursor = 1;

        while (head != null) {
            if (cursor < left) {
                preQ.offer(head.val);
            } else if (cursor > right) {
                tailQ.offer(head.val);
            } else {
                stack.push(head.val);
            }

            cursor++;
            head = head.next;

        }

        ListNode resultNode = new ListNode(-1);
        ListNode node = new ListNode(-1);
        resultNode.next = node;

        while (!preQ.isEmpty()) {
            node.next = new ListNode(preQ.poll());
            node = node.next;
        }
        while (!stack.isEmpty()) {
            node.next = new ListNode(stack.pop());
            node = node.next;
        }
        while (!tailQ.isEmpty()) {
            node.next = new ListNode(tailQ.poll());
            node = node.next;
        }

        return resultNode.next.next;

    }

}

class Prob0092Solution2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode cursorNode = dummyNode;

        int count = 1;

        while (count++ < left) {
            cursorNode = cursorNode.next;
        }
        ListNode prev = cursorNode;

        while (count++ <= right + 1){
            cursorNode = cursorNode.next;
        }
        ListNode rightNode = cursorNode;

        ListNode leftNode = prev.next;
        ListNode succ = rightNode.next;

        rightNode.next = null;

        reverseList(leftNode);

        prev.next = leftNode;
        rightNode.next = succ;

        return dummyNode.next;
    }

        public ListNode reverseList(ListNode head){

        ListNode prev = null;
        ListNode succ = head;

        while (succ != null){
            ListNode tempNode = succ.next;
            succ.next = prev;
            prev = succ;
            succ = tempNode;
        }

        return prev;
    }


}


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