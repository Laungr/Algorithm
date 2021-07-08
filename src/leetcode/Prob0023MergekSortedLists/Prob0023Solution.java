package leetcode.Prob0023MergekSortedLists;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 原解法是采用递归的方法，将链表两两 merge，最终达到合并所有
 *
 * @author Okaeri
 */
public class Prob0023Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    /**
     * @param lists 输入的链表数组，包含了多个链表
     * @param l     左边界
     * @param r     右边界
     * @return 返回合并后的链表头
     */

    private ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) >> 1;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    /**
     * 合并两个链表
     *
     * @param p 链表 p
     * @param q 链表 q
     * @return 合并之后的链表
     */
    private ListNode mergeTwoLists(ListNode p, ListNode q) {
        if (p == null || q == null) {
            return p == null ? q : p;
        }
        ListNode dummyNode = new ListNode(0);
        ListNode cursorNode = dummyNode;
        ListNode pNode = p, qNode = q;
        while (pNode != null && qNode != null) {
            if (pNode.val > qNode.val) {
                cursorNode = cursorNode.next = qNode;
                qNode = qNode.next;
            } else {
                cursorNode = cursorNode.next = pNode;
                pNode = pNode.next;
            }
        }
        cursorNode.next = pNode == null ? qNode : pNode;
        return dummyNode.next;
    }
}

/**
 * 用优先队列实现，与Prob0378类似
 */
class Prob0023Solution2 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1 == null) {
                return -1;
            } else if (o2 == null) {
                return 1;
            }
            return o1.val - o2.val;
        });
        for (ListNode list : lists) {
            if (list != null) {
                queue.offer(list);
            }
        }
        ListNode dummyNode = new ListNode(-1);
        ListNode cursorNode = dummyNode;
        while (!queue.isEmpty()) {
            ListNode poll = queue.poll();
            cursorNode = cursorNode.next = poll;
            if (poll.next != null){
                queue.offer(poll.next);
            }
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
        this.next = next;
    }
}
