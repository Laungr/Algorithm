package leetcode.DailyChallenge;

/**
 * 反转链表，给出一个链表的头节点 head，头节点下标为 1，给出反转的上界 left 和下界 right，[left, right] 范围之内的链表进行反转
 *
 * @author Okaeri
 */
public class June24ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 虚拟头节点
        ListNode dummyNode = new ListNode(-1, head);
        // 游标节点
        ListNode cursorNode = dummyNode;
        // 因为加了 dummyNode，从 0 开始索引
        int index = 0;
        // 找出左边的父节点
        while (index < left - 1) {
            cursorNode = cursorNode.next;
            index++;
        }
        ListNode leftParent = cursorNode;
        cursorNode = cursorNode.next;
        // 找出右边的父节点
        ListNode rightParent = cursorNode;
        index++;
        // 是一个反转链表的程序
        ListNode prev = null;
        while (index <= right) {
            ListNode succ = cursorNode.next;
            cursorNode.next = prev;
            prev = cursorNode;
            cursorNode = succ;
            index++;
        }
        // 给 leftParent，rightParent 的后继节点赋值
        leftParent.next = prev;
        rightParent.next = cursorNode.next;
        // 返回结果为 虚拟节点的后继
        return dummyNode.next;
    }
}

/**
 * Definition for singly-linked list.
 * <p>
 * 链表的定义
 */
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
