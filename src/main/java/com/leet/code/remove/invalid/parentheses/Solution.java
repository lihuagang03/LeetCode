package com.leet.code.remove.invalid.parentheses;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 删除无效的括号
 *
 * @author lihuagang
 */
public class Solution {

    /**
     * 所有可能的结果
     */
    private final Set<String> set = new HashSet<>();
    /**
     * 原始字符串
     */
    String s;
    /**
     * 原始字符串的长度
     */
    int n;
    /**
     * 最大的括号得分
     */
    int max;
    /**
     * 最终结果的有效长度
     */
    int len;

    public List<String> removeInvalidParentheses(String s) {
        this.s = s;
        n = s.length();

        // 多余的括号数量
        int l = 0, r = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                l++;
            } else if (c == ')') {
                if (l != 0) {
                    l--;
                } else {
                    r++;
                }
            }
        }
        // 最终结果的有效长度
        len = n - l - r;

        int c1 = 0, c2 = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                c1++;
            } else if (c == ')') {
                c2++;
            }
        }
        // 最大的括号得分
        max = Math.min(c1, c2);

        dfs(0, "", l, r, 0);
        return new ArrayList<>(set);
    }

    void dfs(int u, String cur, int l, int r, int score) {
        // 递归终止条件
        if (l < 0 || r < 0 || score < 0 || score > max) {
            return;
        }
        if (l == 0 && r == 0) {
            // 一种解法
            if (cur.length() == len) {
                set.add(cur);
            }
        }
        // 循环终止条件
        if (u == n) {
            return;
        }

        char c = s.charAt(u);
        if (c == '(') {
            // 左括号，有效
            dfs(u + 1, cur + c, l, r, score + 1);
            // 多余
            dfs(u + 1, cur, l - 1, r, score);
        } else if (c == ')') {
            // 右括号，有效
            dfs(u + 1, cur + c, l, r, score - 1);
            // 多余
            dfs(u + 1, cur, l, r - 1, score);
        } else {
            // 不是括号字符
            dfs(u + 1, cur + c, l, r, score);
        }
    }

}
