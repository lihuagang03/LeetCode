package com.leet.code.longest.increasing.subsequence;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/longest-increasing-subsequence/">
 *     300. 最长递增子序列</a>
 *
 * @author lihuagang
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int n = nums.length;
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // max(dp[i])
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
