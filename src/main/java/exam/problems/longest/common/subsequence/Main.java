package exam.problems.longest.common.subsequence;

import java.util.Scanner;

/**
 * <a href="https://pintia.cn/problem-sets/2004497238921478144/exam/problems/type/7?problemSetProblemId=2004497238955032587">
 *     7.12 字符串最长公共子序列</a>
 * <a href="https://leetcode.cn/problems/longest-common-subsequence/description/">
 *     1143. 最长公共子序列</a>
 *
 * @author lihuagang
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 读取两个字符串，注意处理可能存在的空行或空格
        if (!in.hasNextLine()) {
            System.out.println(0);
            return;
        }
        String t1 = in.next();
        if (!in.hasNextLine()) {
            System.out.println(0);
            return;
        }
        String t2 = in.next();

        System.out.println(longestCommonSubsequence(t1, t2));
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text1.isEmpty() || text2 == null || text2.isEmpty()) {
            return 0;
        }

        int m = text1.length();
        int n = text2.length();

        // dp[i][j] 表示 text1[0][i-1] 和 text2[0][j-1] 的最长公共子序列长度
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 如果当前字符相等，则长度为左上方值加1
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 如果不相等，则取上方或左方的最大值
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[m][n];
    }
}
