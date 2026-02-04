package com.leet.code.longest.substring.without.repeating.characters;

/**
 * <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/">
 *     3. 无重复字符的最长子串</a>
 *
 * @author lihuagang
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        // 提示：s 由英文字母、数字、符号和空格组成
        // 滑动窗口计数器
        int[] window = new int[128];
        // 最长子串 的长度
        int maxLen = 0;

        // 左右指针
        int left = 0;
        int right = 0;
        int n = s.length();
        while (right < n) {
            char c = s.charAt(right);
            right++;
            // 进行窗口内数据的一系列更新
            window[c]++;

            // 判断左侧窗口是否要收缩
            while (window[c] > 1) {
                char d = s.charAt(left);
                left++;
                window[d]--;
            }
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }
}
