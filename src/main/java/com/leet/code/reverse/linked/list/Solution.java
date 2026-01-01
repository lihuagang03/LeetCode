package com.leet.code.reverse.linked.list;

/**
 * <a href="https://leetcode.cn/problems/reverse-linked-list-ii/description/">
 *     92. 反转链表 II</a>
 */
public class Solution {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        // 哑结点
        ListNode dummyHead = new ListNode(-1, head);

        ListNode prev = dummyHead;
        ListNode cur = head;
        int i = 1;
        while (i++ < left) {
            prev = cur;
            cur = cur.next;
        }
        ListNode tailNext = cur.next;
        while (i++ <= right) {
            tailNext = tailNext.next;
        }
        // System.out.println(cur.val + "," + tailNext.val);
        prev.next = reverse(cur, tailNext);
        return dummyHead.next;
    }

    private ListNode reverse(ListNode head, ListNode tailNext) {
        ListNode prev = tailNext;
        ListNode cur = head;
        while (cur != tailNext) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    private static class ListNode {
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

}
