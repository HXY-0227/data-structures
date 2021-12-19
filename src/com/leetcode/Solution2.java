package com.leetcode;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 * 开始想着转化成两个整数相加来做，哎，链表白学了
 *
 * @author HXY
 */
public class Solution2 {

    public static class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if ( p!= null) {
                p = p.next;
            }
            if ( q!= null) {
                q = q.next;
            }
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;

        ListNode r1 = new ListNode(5);
        ListNode r2 = new ListNode(6);
        ListNode r3 = new ListNode(4);
        r1.next = r2;
        r2.next = r3;
        ListNode listNode = addTwoNumbers(l1, r1);
    }
}
