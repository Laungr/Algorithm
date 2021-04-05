package leetcode.Prob0024SwapNodesinPairs;

/**
 * 给出一个链表，交换两个节点，例如节点 1，2交换位置，节点3，4交换位置，依次
 */

class Prob0026Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pNode = head;
        ListNode res = new ListNode(0);
        ListNode create = res;
        //pNode 是第一个节点，next 是 pNode 的后继节点，由于两两一组进行反转，那么 next 的后继节点 succ 就是下一次转换的头节点
        //create 是结果 res 的游标，先把 pNode 和 next 反转之后，最后指向的是 succ
        //最后把游标节点指向 succ，即下一次需要反转的开始
        while (pNode!= null && pNode.next != null) {
            ListNode next = pNode.next;
            ListNode succ = next.next;
            create = create.next = next;
            create = create.next = pNode;
            create.next = succ;
            pNode = succ;
        }
        return res.next;
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



