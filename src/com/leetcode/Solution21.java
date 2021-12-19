package com.leetcode;

/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * @author HXY
 */
public class Solution21 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode currNode = dummyHead;
        while(l1 != null && l2 != null) {
            if(l1.val >= l2.val) {
                currNode.next = l2;
                l2 = l2.next;
            } else {
                currNode.next = l1;
                l1 = l1.next;
            }
            currNode = currNode.next;
        }
        currNode.next = l1 != null ? l1 : l2;
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode( 1);
        l1.next = new ListNode(2 , new ListNode(4));

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3 , new ListNode(4));
        ListNode listNode = mergeTwoLists(l1, l2);
    }
}
