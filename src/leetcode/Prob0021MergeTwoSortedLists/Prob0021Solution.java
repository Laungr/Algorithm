package leetcode.Prob0021MergeTwoSortedLists;

public class Prob0021Solution {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode curser = null, root = new ListNode(0);
        curser = root;

        while (true){
            if (l1 == null) {curser.next = l2; break;}
            else if (l2 == null) {curser.next = l1;break;}
            else if(l1 != null & l2 != null){
                ListNode newNode = null;
                if(l1.val <= l2.val){
                    newNode = new ListNode(l1.val);
                    curser.next = newNode;
                    curser = newNode;
                    l1 = l1.next;
                }
                else{
                    newNode = new ListNode(l2.val);
                    curser.next = newNode;
                    curser = newNode;
                    l2 = l2.next;
                }
            }            
        }
        return root.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}


