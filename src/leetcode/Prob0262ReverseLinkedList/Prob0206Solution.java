package leetcode.Prob0262ReverseLinkedList;

public class Prob0206Solution {
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

class Prob0206Solution2{
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return last;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
