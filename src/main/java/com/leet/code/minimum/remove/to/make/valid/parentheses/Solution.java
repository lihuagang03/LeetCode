package com.leet.code.minimum.remove.to.make.valid.parentheses;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/minimum-remove-to-make-valid-parentheses/description/">
 *     1249. 移除无效的括号</a>
 *
 * @author lihuagang
 */
public class Solution {

    public String minRemoveToMakeValid(String s) {
        // 移除的索引
        Set<Integer> indexToRemove = new HashSet<>();
        // "(" 的索引
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    indexToRemove.add(i);
                } else {
                    stack.pop();
                }
            }
        }

        // Put any indexes remaining on stack into the set.
        while (!stack.isEmpty()) {
            indexToRemove.add(stack.pop());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!indexToRemove.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

}
