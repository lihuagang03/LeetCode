package exam.problems.jump.game;

import java.util.Scanner;

/**
 * <a href="https://pintia.cn/problem-sets/2004497238921478144/exam/problems/type/7?problemSetProblemId=2004497238955032581">
 *     7.06 跳跃距离</a>
 * <a href="https://leetcode.cn/problems/jump-game/description/">
 *     55. 跳跃游戏</a>
 *
 * @author lihuagang
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String line = in.nextLine();

            String[] strings = line.split(",");
            int[] nums = new int[strings.length];
            for (int i = 0; i < strings.length; i++) {
                nums[i] = Integer.parseInt(strings[i]);
            }

            boolean jump = canJump(nums);
            System.out.println(jump);
        }
    }

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
