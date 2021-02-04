package com.leetcode.list;

/**
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 * 移除链表元素
 *
 * @author HXY
 * @since 2020-1-28
 */
public class Solution203 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }

        // 以当前节点为头结点的链表信息字符串
        @Override
        public String toString(){

            StringBuilder s = new StringBuilder();
            ListNode cur = this;
            while(cur != null){
                s.append(cur.val + "->");
                cur = cur.next;
            }
            s.append("NULL");
            return s.toString();
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        // 方案1：这种也能通过，没有第二种方案好，感觉第二种思路更清晰，代码更少
        /*if (head == null) {
            return null;
        }

        if (head != null && head.val == val){
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }

        ListNode prev = head;
        while (prev != null && prev.next != null) {
            if (val == prev.next.val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            } else {
                prev = prev.next;
            }
        }*/

        // 方案2：建立哨兵节点，官方解答
        /*ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode prev = sentinel, cur = head;
        while (cur != null) {
            if (cur.val == val) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }
            cur = cur.next;
        }
        return head;*/

        // 方案3：通过递归解决是真牛逼
        if (head == null) {
            return null;
        }

        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        Solution203 solution = new Solution203();
        System.out.println(solution.removeElements(solution.test(), 2));
    }

    public ListNode test() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        return node1;
    }
}
