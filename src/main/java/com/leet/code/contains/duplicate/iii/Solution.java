package com.leet.code.contains.duplicate.iii;

import java.util.TreeSet;

/**
 * <a href="https://leetcode.cn/problems/contains-duplicate-iii/">
 *     220. 存在重复元素 III</a>
 *
 * @author lihuagang
 */
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        int len = nums.length;
        // 使用队列维护滑动窗口内的元素
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < len; i++) {
            Integer ceiling = set.ceiling(nums[i] - valueDiff);
            if (ceiling != null && ceiling <= (nums[i] + valueDiff)) {
                return true;
            }
            set.add(nums[i]);
            // 使用队列维护滑动窗口内的元素
            if (i >= indexDiff) {
                set.remove(nums[i - indexDiff]);
            }
        }
        return false;
    }
}
