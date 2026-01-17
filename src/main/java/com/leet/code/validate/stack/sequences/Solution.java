package com.leet.code.validate.stack.sequences;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/validate-stack-sequences/">
 *     946. 验证栈序列</a>
 *
 * @author lihuagang
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 示例 1：
//        int[] pushed = new int[]{1, 2, 3, 4, 5};
//        int[] popped = new int[]{4, 5, 3, 2, 1};
        // 示例 2：
        int[] pushed = new int[]{1, 2, 3, 4, 5};
        int[] popped = new int[]{4, 3, 5, 1, 2};

        boolean result = solution.validateStackSequences(pushed, popped);
        System.out.println(result);
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> deque = new ArrayDeque<>(pushed.length);

        for (int i = 0, j = 0; i < pushed.length; i++) {
            deque.addLast(pushed[i]);
            while (!deque.isEmpty() && deque.peekLast() == popped[j]) {
                deque.pollLast();
                j++;
            }
        }

        return deque.isEmpty();
    }

}
