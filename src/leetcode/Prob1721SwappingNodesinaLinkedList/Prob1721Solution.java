package leetcode.Prob1721SwappingNodesinaLinkedList;

/**
 * 链表的头节点标记为第一个节点，后续节点的索引依此累加，交换整数第 k 个和倒数第 k 个节点
 * 用快慢指针的思路比较厉害，遍历麻烦了
 */
public class Prob1721Solution {
    public ListNode swapNodes(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode prev = dummyNode;
        ListNode fast = dummyNode;
        ListNode slow = dummyNode;

        for (int i = 0; i < k; i++) {
            prev = prev.next;
            fast = fast.next;
        }
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        int tmp = prev.val;
        prev.val = slow.val;
        slow.val = tmp;

        return dummyNode.next;
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
