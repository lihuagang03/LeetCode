package com.leet.code.remove.duplicates.from.sorted.list.ii;

/**
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/description/">
 *     82. 删除排序链表中的重复元素 II</a>
 *
 * @author lihuagang
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 虚拟头结点，哑结点
        ListNode dummy = new ListNode(-1, head);
        // 快慢指针
        ListNode slow = dummy;
        ListNode prev = head;
        ListNode fast = head.next;
        // 重复数字计数器
        int dupNum = 0;
        while (fast != null) {
            if (fast.val == prev.val) {
                // 出现重复数字，待删除
                dupNum++;
            } else {
                if (dupNum > 0) {
                    // 新数字与旧数字不相同，看到新的希望
                    dupNum = 0;
                } else {
                    // 发现不重复的数字
                    // 维护 list[0..slow] 无重复
                    slow.next = prev;
                    slow = slow.next;
                }
            }
            prev = fast;
            fast = fast.next;
        }
        // 尾节点数字不重复处理
        if (dupNum <= 0) {
            slow.next = prev;
            slow = slow.next;
        }
        // 删除后序所有重复的元素
        slow.next = null;

        return dummy.next;
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
