package exam.problems.uncrossed.lines;

import java.util.Scanner;

/**
 * <a href="https://pintia.cn/problem-sets/2004497865353367552/exam/problems/type/7?problemSetProblemId=2004497865374339074">
 *     7.03 不相交的线</a>
 *
 * @author lihuagang
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
            int n = in.nextInt();
            int[] nums1 = new int[n];
            for (int i = 0; i < n; i++) {
                nums1[i] = in.nextInt();
            }
            int m = in.nextInt();
            int[] nums2 = new int[m];
            for (int j = 0; j < m; j++) {
                nums2[j] = in.nextInt();
            }

            int res = maxUncrossedLines(nums1, nums2);
            System.out.println(res);
        }
    }

    public static int maxUncrossedLines(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return 0;
        }
        int n = nums1.length;
        int m = nums2.length;
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[n][m];
    }
}
