package leetcode.Prob0025ReverseNodesinkGroup;

public class Prob0025Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        //如果链表为空，或者k==1，直接返回head
        if (head == null || k == 1){
            return head;
        }
        //设置一个虚拟节点，来作为head的前驱节点
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        //设置一个游标节点，用来遍历
        ListNode cursor = dummyNode;
        //设置一个前驱节点，表示要被反转节点的前驱节点
        ListNode prev = dummyNode;
        //设置一个left节点，表示要被反转节点的第一个
        ListNode left = prev.next;
        //设置一个right节点，表示要被反转节点的最后一个
        ListNode right = null;
        ListNode succ = null;

        //设置一个计数器，从 0 开始
        int count = 0;

        while (cursor.next != null ){
            cursor = cursor.next;
            count++;

            //当累加满k一组时进入判断
            if (count == k){
                //right为当前游标节点
                right = cursor;
                succ = right.next;
                reverseList(left, right);

                prev.next = right;
                left.next = succ;

                cursor = left;
                left = succ;
                count = 0;
            }

        }
        return dummyNode.next;
    }

    private void reverseList(ListNode left, ListNode right) {
        if (left == null) {
            return;
        }
        ListNode cursor = left;
        ListNode prev = right.next;
        while (cursor != right) {
            ListNode tmp = cursor.next;
            cursor.next = prev;
            prev = cursor;
            cursor = tmp;
        }
        right = prev;
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