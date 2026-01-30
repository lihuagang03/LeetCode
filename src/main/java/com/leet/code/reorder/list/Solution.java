package com.leet.code.reorder.list;

/**
 * <a href="https://leetcode.cn/problems/reorder-list/description/">
 *     143. 重排链表</a>
 *
 * @author lihuagang
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        // 节点计数
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        // System.out.println("n = " + n);
        if (n <= 2) {
            return;
        }

        // 左右子链表
        int rn = n / 2;
        int ln = n - rn;
        // System.out.println("rn = " + rn);
        // System.out.println("ln = " + ln);

        // 反转右子链表
        ListNode le = head;
        for (int i = 1; i < ln; i++) {
            le = le.next;
        }
        ListNode rh = le.next;
        // System.out.println("le = " + le.val);
        // System.out.println("rh = " + rh.val);
        le.next = null;

        // 通用实现-迭代/顺序访问
        rh =  reverse(rh, null);
        ListNode lh = head;
        for (int i = 0; i < rn; i++) {
            ListNode leftNext = lh.next;
            ListNode rightNext = rh.next;
            lh.next = rh;
            rh.next = leftNext;
            lh = leftNext;
            rh = rightNext;
        }
    }

    /**
     * 通用实现-迭代/顺序访问
     */
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

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
