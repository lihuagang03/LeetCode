package com.leet.code.longest.valid.parentheses;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/longest-valid-parentheses/">
 *     32. 最长有效括号</a>
 *
 * @author lihuagang
 */
public class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        // 记录左括号的索引
        Deque<Integer> deque = new ArrayDeque<>();
        int n = s.length();
        // dp[i] 的定义：记录以 s[i-1] 结尾的最长合法括号子串长度
        int[] dp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                // 遇到左括号，记录索引
                deque.addLast(i);
                // 左括号不可能是合法括号子串的结尾
                dp[i + 1] = 0;
            } else if (s.charAt(i) == ')') {
                // 遇到右括号
                if (!deque.isEmpty()) {
                    // 配对的左括号对应索引
                    int leftIndex = deque.removeLast();
                    // 以这个右括号结尾的最长子串长度
                    int len = 1 + i - leftIndex + dp[leftIndex];
                    dp[i + 1] = len;
                } else {
                    // 没有配对的左括号
                    dp[i + 1] = 0;
                }
            }
        }

        // 计算最长子串的长度
        int ans = 0;
        for (int dpi : dp) {
            ans = Math.max(ans, dpi);
        }
        return ans;
    }
}
