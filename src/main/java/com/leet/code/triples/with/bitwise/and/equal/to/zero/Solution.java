package com.leet.code.triples.with.bitwise.and.equal.to.zero;

/**
 * <a href="https://leetcode.cn/problems/triples-with-bitwise-and-equal-to-zero/description/">
 *     982. 按位与为零的三元组</a>
 *
 * @author lihuagang
 */
public class Solution {
    // 0 <= nums[i] < 216
    private static final int N = 1 << 16;

    public int countTriplets(int[] nums) {
        // 用哈希表实现的 cnt 要枚举所有 key；用数组实现的 cnt 要枚举区间 [0,2^16) 内的所有数（根据题目的数据范围得出）。
        int[] cnt = new int[N];
        // 可以先写一个 O(n^2) 的枚举，预处理所有 nums[i] AND nums[j] 的出现次数，存到一个哈希表（或者数组）cnt 中。
        for (int x : nums) {
            for (int y : nums) {
                // nums[i] & nums[j] & nums[k] == 0
                cnt[x & y]++;
            }
        }
        // 然后枚举 nums[k] 和 x，如果 nums[k] AND x 等于 0，那就把 cnt[x] 加到答案中。
        int ans = 0;
        for (int x : nums) {
            for (int y = 0; y < N; y++) {
                // nums[i] & nums[j] & nums[k] == 0
                if ((x & y) == 0) {
                    ans += cnt[y];
                }
            }
        }
        return ans;
    }
}
