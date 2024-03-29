package leetcode.Prob0002AddTwoNumbers;

import java.util.Stack;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */

//
//    /**
//     * Definition for singly-linked list.
//     * public class ListNode {
//     *     int val;
//     *     ListNode next;
//     *     ListNode() {}
//     *     ListNode(int val) { this.val = val; }
//     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//     * }
//     */
//    class Solution {
//        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//
//
//        }
//    }
public class Prob0002Solution {

    public static void main(String[] args) {


    }

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int addNum1, addNum2, sum;
            addNum1 = ListNodeToInt(l1);
            addNum2 = ListNodeToInt(l2);
            sum = addNum1 + addNum2;
            System.out.println(sum);
            return IntToListNode(sum);

        }

        public int ListNodeToInt(ListNode l) {
            int num = 0;
            Stack<Integer> stackNum = new Stack<>();
            while (l.next != null) {
                stackNum.add(l.val);
                l = l.next;
            }
            stackNum.add(l.val);
            for (int i = stackNum.size() - 1; !stackNum.empty(); i--) {
                num += stackNum.pop() * Math.pow(10, i);
            }
            System.out.println(num);
            return num;
        }

        public ListNode IntToListNode(int n) {
            ListNode l = null;
            int mod = 10;
            while (n / mod > 0) {
                mod *= 10;
                l = new ListNode(n % mod, l);
                //l.next.next.next.val
            }
            return l = new ListNode(n / (mod / 10), l);
        }

    }

}

class ListNode {
    int val;//节点的数据
    ListNode next;//指向下一个节点

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

class Prob0002Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //进位标志位
        int carry = 0;
        //结果Node
        ListNode resultNode = new ListNode(0);
        ListNode curserNode = resultNode;

        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;

            int sum = x + y + carry;
            carry = sum / 10;
            curserNode.next = new ListNode(sum % 10);


            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

            curserNode = curserNode.next;
        }

        if (carry > 0) {
            curserNode.next = new ListNode(carry);
        }
        return resultNode.next;

    }

}




