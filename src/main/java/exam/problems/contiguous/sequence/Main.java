package exam.problems.contiguous.sequence;

import java.util.Scanner;

/**
 * <a href="https://pintia.cn/problem-sets/2004497238921478144/exam/problems/type/7?problemSetProblemId=2004497238955032588">
 *     7.13 连续数列</a>
 * <a href="https://leetcode.cn/problems/contiguous-sequence-lcci/description/">
 *     16.17. 连续数列</a>
 *
 * @author lihuagang
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        if (!in.hasNextLine()) {
            System.out.println(0);
            return;
        }

        String input = in.next();
        if (input == null || input.isEmpty()) {
            System.out.println(0);
            return;
        }
        String[] parts = input.split(",");
        int n = parts.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }

        int ans = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] > 0) {
                nums[i] += nums[i - 1];
            }
            ans = Math.max(ans, nums[i]);
        }
        System.out.println(ans);
    }
}
