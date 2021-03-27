package leetcode.Prob0142LinkedListCycleII;

import java.util.HashSet;

public class Prob0142Solution {
    public ListNode detectCycle(ListNode head){
        if (head == null) {
            return null;
        }

        HashSet<ListNode> set = new HashSet<>();
        set.add(head);

        while (head.next!= null){
            head = head.next;
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
        }
        return null;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

