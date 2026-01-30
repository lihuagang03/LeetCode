package com.leet.code.contiguous.sequence;

/**
 * <a href="https://leetcode.cn/problems/contiguous-sequence-lcci/description/">
 *     16.17. 连续数列</a>
 *
 * @author lihuagang
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int n = nums.length;
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return nums[0];
        }

        int ans = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] > 0) {
                nums[i] += nums[i - 1];
            }
            ans = Math.max(ans, nums[i]);
        }
        return ans;
    }
}
