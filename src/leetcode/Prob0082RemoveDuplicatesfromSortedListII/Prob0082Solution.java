package leetcode.Prob0082RemoveDuplicatesfromSortedListII;

public class Prob0082Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyNode = new ListNode(-101);
        dummyNode.next = head;

        ListNode parent = dummyNode;
        ListNode left = dummyNode.next;
        ListNode right = left.next;

        boolean flag = false;

        while (right != null) {
            if (left.val == right.val) {
                right = right.next;
                left.next = right;
                flag = true;
            }
            else if (flag){
                flag = false;
                parent.next = right;
                left = right;
                right = right.next;
            }
            else {
                parent = left;
                left = left.next;
                right = right.next;
            }
        }

        if(flag){

            parent.next = null;
        }
        return dummyNode.next;

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
