package leetcode.Prob0061RotateList;

public class Prob0061Solution {
    public ListNode rotateList(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        //链表的长度
        int len = 1;
        ListNode cursorNode = head;
        while (cursorNode.next != null) {
            len++;
            cursorNode = cursorNode.next;
        }
        //构造成环形链表
        cursorNode.next = head;
        cursorNode = head;
        System.out.println(len);

        //取余
        int rem = k % len;

        ListNode res = new ListNode(0);
        ListNode write = res;
        //先遍历lem - rem 次 找出头节点
        for (int i = 0; i < len - rem; i++) {
            cursorNode = cursorNode.next;
        }

        //遍历 len 次，找出所有节点
        for (int i = 0; i < len; i++) {
            write = write.next = cursorNode;
            cursorNode = cursorNode.next;
        }
        write.next = null;

        return res.next;
    }
}


/**
 * Definition for singly-linked list.
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
