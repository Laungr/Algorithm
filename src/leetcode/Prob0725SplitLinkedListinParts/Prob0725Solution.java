package leetcode.Prob0725SplitLinkedListinParts;

/**
 * 把链表分成 k 份
 * 思路有，却不能清晰得写出来
 *
 */

public class Prob0725Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        //求链表的长度 len
        int len = 0;
        ListNode[] res = new ListNode[k];
        ListNode cursorNode = root;
        while (cursorNode != null) {
            len++;
            cursorNode = cursorNode.next;
        }
        //取模和取余
        int mod = len / k;
        int rem = len % k;

        cursorNode = root;
        for (int i = 0; i < k; i++) {
            ListNode head = new ListNode(0);
            ListNode write = head;
            //这个三元运算符比较巧妙
            for (int j = 0; j < mod + (i < rem ? 1 : 0); j++) {
                write.next = new ListNode(cursorNode.val);
                write = write.next;
                if (cursorNode != null) {
                    cursorNode = cursorNode.next;
                }
            }
            res[i] = head.next;
        }
        return res;
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

