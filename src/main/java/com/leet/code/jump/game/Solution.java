package com.leet.code.jump.game;

/**
 * <a href="https://leetcode.cn/problems/jump-game/description/">
 *     55. 跳跃游戏</a>
 *
 * @author lihuagang
 */
public class Solution {

    public static boolean canJump(int[] nums) {
        int dp = 0;
        int endIndex = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (i > dp) {
                return false;
            }
            dp = Math.max(dp, i + nums[i]);
            if (dp >= endIndex) {
                return true;
            }
        }
        return true;
    }

}
