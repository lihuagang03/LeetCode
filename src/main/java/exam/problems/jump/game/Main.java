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
        String input = in.nextLine();

        String[] parts = input.split(",");
        int[] numbers = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            numbers[i] = Integer.parseInt(parts[i]);
        }

        boolean jump = canJump(numbers);
        System.out.println(jump);
    }

    public static boolean canJump(int[] numbers) {
        int dp = 0;
        int endIndex = numbers.length - 1;
        for (int i = 0; i < numbers.length; i++) {
            if (i > dp) {
                return false;
            }
            dp = Math.max(dp, i + numbers[i]);
            if (dp >= endIndex) {
                return true;
            }
        }
        return true;
    }
}
