package leetcode.Prob0023MergekSortedLists;

public class Prob0023Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode resultNode = null;
        ListNode curserNode = null;

        //如果链表集合为空的话，则返回null;
        if (lists.length == 0) return null;

        //遍历链表的集合
        for (int i = 0; i < lists.length; i++) {
            int min = 0;
            //如果对应链表为空，继续循环
            if (lists[i] == null) continue;
            //如果对应链表不为空，则比较
            else if (lists[i].val < min){
                min = lists[i].val;


            }


        }


        return null;
    }

}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
