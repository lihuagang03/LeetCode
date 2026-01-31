package exam.problems.longest.increasing.subsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * <a href="https://pintia.cn/problem-sets/2004497865353367552/exam/problems/type/7?problemSetProblemId=2004497865374339073">
 *     7.02 最长递增子序列</a>
 * <a href="https://leetcode.cn/problems/longest-increasing-subsequence/description/">
 *     300. 最长递增子序列</a>
 *
 * @author lihuagang
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<Integer> list = new ArrayList<>();
        while (in.hasNextInt()) {
            list.add(in.nextInt());
        }
        if (list.isEmpty()) {
            return;
        }
        int[] nums = list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        int n = nums.length;

//        if (!in.hasNextLine()) {
//            return;
//        }
//        String input = in.nextLine();
//        if (input == null || input.isEmpty()) {
//            return;
//        }
//        String[] parts = input.split(" ");
//        int n = parts.length;
//        int[] nums = new int[n];
//        for (int i = 0; i < n; i++) {
//            nums[i] = Integer.parseInt(parts[i]);
//        }

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}
