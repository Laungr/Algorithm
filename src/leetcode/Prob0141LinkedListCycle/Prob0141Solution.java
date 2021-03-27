package leetcode.Prob0141LinkedListCycle;

import java.util.HashSet;

/**
 * 使用 HashSet 没有重复元素的特性来进行判定
 */
public class Prob0141Solution {
    public boolean hasCycle(ListNode head){
        if (head == null) {
            return false;
        }

        HashSet<ListNode> set = new HashSet<>();
        set.add(head);

        while (head.next!= null){
            head = head.next;
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
        }
        return  false;
    }
}

/**
 * 开始做题的时候想到了快慢指针，但是觉得会陷入死循环，因此想到了方法1；
 * 实际上如果有环出现的话，那么最终 fast 会和 slow 相遇，没有想到这一点
 * 妙啊妙啊
 */
class Prob0141Solution2 {
    boolean hasCycle(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
