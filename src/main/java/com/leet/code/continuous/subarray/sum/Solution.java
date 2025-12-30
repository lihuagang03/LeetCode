package com.leet.code.continuous.subarray.sum;

import java.util.HashSet;
import java.util.Set;

/**
 * TODO
 *
 * @author lihuagang
 */
public class Solution {

    public boolean checkSubarraySum(int[] nums, int k) {
        int len = nums.length;

        // 前缀和
        int[] sum = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        // 同余定理
        // 哈希表
        Set<Integer> set = new HashSet<>();
        for (int i = 2; i <= len; i++) {
            set.add(sum[i - 2] % k);
            if (set.contains(sum[i] % k)) {
                return true;
            }
        }
        return false;
    }

}
