package com.leet.code.find.longest.awesome.substring;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/find-longest-awesome-substring/description/">
 *     1542. 找出最长的超赞子字符串</a>
 *
 * @author lihuagang
 */
public class Solution {
    // s 中的字符种类数
    // s 仅由数字组成
    private static final int D = 10;

    public int longestAwesome(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int n = s.length();

        int[] pos = new int[1 << D];
        Arrays.fill(pos, n);
        pos[0] = -1;
        int ans = 0;
        int pre = 0;
        for (int i = 0; i < n; i++) {
            int v = s.charAt(i) - '0';
            pre = pre ^ (1 << v);
            // s 仅由数字组成
            for (int j = 0; j < D; j++) {
                ans = Math.max(ans, i - pos[pre ^ (1 << j)]);
            }
            ans = Math.max(ans, i - pos[pre]);
            if (pos[pre] == n) {
                pos[pre] = i;
            }
        }
        return ans;
    }
}
