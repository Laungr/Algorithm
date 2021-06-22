package leetcode.Prob0086PartitionList;

/**
 * 快速排序中的 partition 方法，从数组的左右两边找，遇到大小相反的，然后交换。
 * 这是链表，无法用从后往前遍历，思路就是把比 target 小的，放在一个新链表中，然后把原链表中的小于 target 的元素直接剔除掉
 * 最后把两个链表链接起来
 *
 * @author Okaeri
 */
public class Prob0086Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode res = new ListNode(-1);
        ListNode leftIndexNode = res;

        ListNode dummyNode = new ListNode(-1, head);
        ListNode cursorNode = dummyNode;

        while (cursorNode.next != null) {
            ListNode node = cursorNode.next;
            // 如果下一个节点的值小，就把它加到 left 部分去，然后在原来删除
            if (node.val < x) {
                leftIndexNode = leftIndexNode.next = node;
                cursorNode.next = node.next;
            }
            // 否则的话就向后遍历
            else {
                cursorNode = cursorNode.next;
            }
        }
        leftIndexNode.next = dummyNode.next;

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
