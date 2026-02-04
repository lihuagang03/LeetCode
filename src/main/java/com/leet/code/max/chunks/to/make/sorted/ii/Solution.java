package com.leet.code.max.chunks.to.make.sorted.ii;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <a href="https://leetcode.cn/problems/max-chunks-to-make-sorted-ii/description/">
 *     768. 最多能完成排序的块 II</a>
 *
 * @author lihuagang
 */
public class Solution {
    public int maxChunksToSorted(int[] arr) {
        Deque<Integer> stack = new LinkedList<>();
        for (int num : arr) {
            if (!stack.isEmpty() && num < stack.getLast()) {
                int head = stack.removeLast();
                // 移除堆栈中所有比 num 小的数
                while (!stack.isEmpty() && num < stack.getLast()) {
                    stack.removeLast();
                }
                // 只保留比 num 大的数
                stack.addLast(head);
            } else {
                stack.addLast(num);
            }
        }
        return stack.size();
    }
}
