package com.leet.code.find.longest.awesome.substring;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/find-longest-awesome-substring/description/">
 *     1542. 找出最长的超赞子字符串</a>
 *
 * @author lihuagang
 */
public class Solution {
    public int longestAwesome(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int n = s.length();
        int[] pos = new int[1 << 10];
        Arrays.fill(pos, n);
        pos[0] = -1;
        int ans = 0;
        int pre = 0;
        for (int i = 0; i < n; i++) {
            pre ^= 1 << (s.charAt(i) - '0');
            for (int j = 0; j < 10; j++) {
                // 奇数
                ans = Math.max(ans, i - pos[pre ^ (1 << j)]);
            }
            // 偶数
            ans = Math.max(ans, i - pos[pre]);
            // 首次遇到值为 pre 的前缀异或和，记录其下标 i
            if (pos[pre] == n) {
                pos[pre] = i;
            }
        }
        return ans;
    }
}
