package leetcode.Prob0092ReverseLinkedListII;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Prob0092Solution
{
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null ) {
            return head;
        }

        Stack<Integer> stack = new Stack<>();
        Queue<Integer> preQ = new ArrayDeque<>();
        Queue<Integer> tailQ = new ArrayDeque<>();

        int cursor = 1;

        while (head != null){
            if (cursor < left ) {
                preQ.offer(head.val);
            }
            else if (cursor > right) {
                tailQ.offer(head.val);
            }
            else {
                stack.push(head.val);
            }

            cursor ++;
            head = head.next;

        }

        ListNode resultNode = new ListNode(-1);
        ListNode node = new ListNode(-1);
        resultNode.next = node;

        while (!preQ.isEmpty()){
            node.next = new ListNode(preQ.poll());
            node = node.next;
        }
        while (!stack.isEmpty()){
            node.next = new ListNode(stack.pop());
            node = node.next;
        }
        while (!tailQ.isEmpty()){
            node.next = new ListNode(tailQ.poll());
            node = node.next;
        }

       return resultNode.next.next ;

    }

}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}