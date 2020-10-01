package leetcode.Prob0019RemoveNthNode;

public class Prob0019Solution {

    public ListNode removeNthFromEnd(ListNode head, int n){
        if(head == null || n == 0) return head;

        int length = getListNodeLength(head);

        if(n >= length) return head.next;

        ListNode curserNode = head;
        head = curserNode;
        int curser = 0;

        while (curserNode != null && curser < length - n -1){
            curser++;
            curserNode = curserNode.next;
        }
        curserNode.next = curserNode.next.next;


        return head;
    }

    public int getListNodeLength(ListNode l){
        int length = 0;
        while (l != null){
            l = l.next;
            length ++;
        }
        return length;
    }


    public  class ListNode{
        int val;
        ListNode next;
        ListNode(){};
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }
}
