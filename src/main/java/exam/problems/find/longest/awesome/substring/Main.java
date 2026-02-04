package exam.problems.find.longest.awesome.substring;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <a href="https://pintia.cn/problem-sets/2004497865353367552/exam/problems/type/7?problemSetProblemId=2004497865374339075">
 *     7.04 最长超赞子字符串</a>
 * <a href="https://leetcode.cn/problems/find-longest-awesome-substring/description/">
 *     1542. 找出最长的超赞子字符串</a>
 *
 * @author lihuagang
 */
public class Main {
    // s 仅由数字组成
    private static final int D = 10;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if (!in.hasNextLine()) {
            System.out.println(0);
            return;
        }
        String s = in.nextLine();
        if (s == null || s.isEmpty()) {
            System.out.println(0);
            return;
        }
        int n = s.length();

        int[] pos = new int[1 << D];
        // n 表示没有找到异或前缀和
        Arrays.fill(pos, n);
        pos[0] = -1;
        int ans = 0;
        // 前缀异或和
        int pre = 0;
        for (int i = 0; i < n; i++) {
            pre ^= 1 << (s.charAt(i) - '0');
            for (int j = 0; j < D; j++) {
                ans = Math.max(ans, i - pos[pre ^ (1 << j)]);
            }
            ans = Math.max(ans, i - pos[pre]);
            if (pos[pre] == n) {
                pos[pre] = i;
            }
        }
        System.out.println(ans);
    }
}
