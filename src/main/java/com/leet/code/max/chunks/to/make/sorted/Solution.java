package com.leet.code.max.chunks.to.make.sorted;

/**
 * <a href="https://leetcode.cn/problems/max-chunks-to-make-sorted/description/">
 *     769. 最多能完成排序的块</a>
 *
 * @author lihuagang
 */
public class Solution {
    public int maxChunksToSorted(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int n = arr.length;
        int ans = 0;
        int min = n;
        int max = -1;
        for (int i = 0, j = 0; i < n; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
            if (j == min && i == max) {
                ans++;
                j = i + 1;
                min = n;
                max = -1;
            }
        }
        return ans;
    }
}
