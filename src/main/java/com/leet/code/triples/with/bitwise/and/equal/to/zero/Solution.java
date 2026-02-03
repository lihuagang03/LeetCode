package com.leet.code.triples.with.bitwise.and.equal.to.zero;

/**
 * <a href="https://leetcode.cn/problems/triples-with-bitwise-and-equal-to-zero/description/">
 *     982. 按位与为零的三元组</a>
 *
 * @author lihuagang
 */
public class Solution {
    private static final int N = 1 << 16;

    public int countTriplets(int[] nums) {
        int[] cnt = new int[N];
        for (int x : nums) {
            for (int y : nums) {
                cnt[x & y]++;
            }
        }
        int ans = 0;
        for (int x : nums) {
            for (int y = 0; y < N; y++) {
                if ((x & y) == 0) {
                    ans += cnt[y];
                }
            }
        }
        return ans;
    }
}
