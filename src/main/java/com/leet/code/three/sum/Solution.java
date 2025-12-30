package com.leet.code.three.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/3sum/description/">
 *     15. 三数之和</a>
 *
 * @author lihuagang
 */
public class Solution {

    // 方法一：排序 + 双指针

    /**
     * 排序 + 双指针
     * 本题的难点在于如何去除重复解。
     * <pre>
     * 算法流程：
     * 1. 特判，对于数组长度 n，如果数组为 null 或者数组长度小于 3，返回 []。
     * 2. 对数组进行排序。
     * 3. 遍历排序后数组：
     *    * 若 nums[i]>0：因为已经排序好，所以后面不可能有三个数加和等于 0，直接返回结果。
     *    * 对于重复元素：跳过，避免出现重复解
     *    * 令左指针 L=i+1，右指针 R=n-1，当 L<R 时，执行循环：
     *      * 当 nums[i]+nums[L]+nums[R]==0，执行循环，判断左界和右界是否和下一位置重复，去除重复解。并同时将 L,R 移到下一位置，寻找新的解
     *      * 若和大于 0，说明 nums[R] 太大，R 左移
     *      * 若和小于 0，说明 nums[L] 太小，L 右移
     * </pre>
     * <pre>
     * 复杂度分析
     * * 时间复杂度：O(n^2)，数组排序 O(N logN)，遍历数组 O(n)，双指针遍历 O(n)，总体 O(N logN)+O(n)∗O(n)，O(n^2)
     * * 空间复杂度：O(1)
     * </pre>
     *
     * @return 返回所有和为 0 且不重复的三元组
     */
    public List<List<Integer>> threeSum(int[] nums) {
        // 1. 特判，对于数组长度 n，如果数组为 null 或者数组长度小于 3，返回 []
        if (nums == null || nums.length < 3) {
            return Collections.emptyList();
        }

        // 2. 对数组进行排序
        Arrays.sort(nums);

        // 3. 遍历排序后数组
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            // 终止条件
            if (num > 0) {
                // 若 nums[i]>0：因为已经排序好，所以后面不可能有三个数加和等于 0，直接返回结果
                return result;
            }
            if (i > 0 && num == nums[i - 1]) {
                // 对于重复元素：跳过，避免出现重复解
                continue;
            }

            // 令左指针 L=i+1，右指针 R=n-1，当 L<R 时，执行循环
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = num + nums[left] + nums[right];

                if (sum == 0) {
                    // 找到一个解法
                    result.add(Arrays.asList(num, nums[left], nums[right]));

                    // 执行循环，判断左界和右界是否和下一位置重复，去除重复解
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    // 并同时将 L,R 移到下一位置，寻找新的解
                    left++;
                    right--;
                } else if (sum > 0) {
                    // 执行循环，判断左界和右界是否和下一位置重复，去除重复解
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    // 若和大于 0，说明 nums[R] 太大，R 左移
                    right--;
                } else {
                    // sum < 0
                    // 执行循环，判断左界和右界是否和下一位置重复，去除重复解
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    // 若和小于 0，说明 nums[L] 太小，L 右移
                    left++;
                }
            }
        }

        return result;
    }

}
