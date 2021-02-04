package com.leetcode.list;

/**
 * 链表反转
 * 1->2->3->4->5->NULL
 * 5->4->3->2->1->NULL
 *
 * @author HXY
 */
public class Solution206 {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode pre = null;

        while (null != curr) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        Solution206 solution = new Solution206();
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode listNode = solution.reverseList(node1);
    }

}
