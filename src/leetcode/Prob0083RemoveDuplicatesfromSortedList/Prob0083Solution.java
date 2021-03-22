package leetcode.Prob0083RemoveDuplicatesfromSortedList;

public class Prob0083Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode left = head;
        ListNode right = head.next;

        while (right != null){
            if (left.val == right.val){
                right = right.next;
                left.next = right;
            }
            else {
                left = left.next;
                right = right.next;
            }
        }
        return head;

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
    }
}
