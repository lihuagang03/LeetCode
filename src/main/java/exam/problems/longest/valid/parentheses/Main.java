package exam.problems.longest.valid.parentheses;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * <a href="https://pintia.cn/problem-sets/2004497865353367552/exam/problems/type/7?problemSetProblemId=2004497865374339078">
 *     7.07 最长有效括号</a>
 * <a href="https://leetcode.cn/problems/longest-valid-parentheses/description/">
 *     32. 最长有效括号</a>
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
        String s = in.nextLine();
        if (s == null || s.isEmpty()) {
            System.out.println(0);
            return;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        int n = s.length();
        int[] dp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                deque.addLast(i);
                dp[i + 1] = 0;
            } else {
//            } else if (s.charAt(i) == ')') {
                if (!deque.isEmpty()) {
                    int leftIndex = deque.removeLast();
                    int len = 1 + i - leftIndex + dp[leftIndex];
                    dp[i + 1] = len;
                } else {
                    dp[i + 1] = 0;
                }
            }
        }

        int ans = 0;
        for (int dpi : dp) {
            ans = Math.max(ans, dpi);
        }
        System.out.println(ans);
    }
}
