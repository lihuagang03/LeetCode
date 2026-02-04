package exam.problems.superstar.palindromes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <a href="https://pintia.cn/problem-sets/2004497865353367552/exam/problems/type/7?problemSetProblemId=2004497865374339076">
 *     7.05 超级回文数</a>
 * <a href="https://leetcode.cn/problems/super-palindromes/description/">
 *     906. 超级回文数</a>
 *
 * @author lihuagang
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if (!in.hasNextLine()) {
            return;
        }
        String s = in.nextLine();
        if (s == null || s.isEmpty()) {
            return;
        }
        String[] parts = s.split(",");

        long L = Long.parseLong(parts[0]);
        long R = Long.parseLong(parts[1]);
        // 1 <= left.length, right.length <= 18
        // 同时 R=k∥k′（两串数字连接），其中 k′ 是 k 的反序（也有可能截掉了中间数字），所以 k<10^5=MAGIC，我们的神奇常数。
        int MAGIC = 100_000;
        List<Long> ans = new ArrayList<>();

        // count odd length
        // left 和 right 表示的整数在区间 [1, 10^18 - 1] 内。
        for (int k = 1; k < MAGIC; k++) {
            // 假如 k=1234 那么 R=1234321
            StringBuilder sb = new StringBuilder(Integer.toString(k));
            for (int i = sb.length() - 2; i >= 0; i--) {
                sb.append(sb.charAt(i));
            }
            // 假设 P=R^2 是超级回文数
            long v = Long.parseLong(sb.toString());
            v *= v;
            if (v > R) {
                break;
            }
            if (v >= L && isPalindrome(v)) {
                ans.add(v);
            }
        }
        // count even length
        // left 和 right 表示的整数在区间 [1, 10^18 - 1] 内。
        for (int k = 1; k < MAGIC; k++) {
            // 假如 k=1234 那么 R=12344321
            StringBuilder sb = new StringBuilder(Integer.toString(k));
            for (int i = sb.length() - 1; i >= 0; i--) {
                sb.append(sb.charAt(i));
            }
            // 假设 P=R^2 是超级回文数
            long v = Long.parseLong(sb.toString());
            v *= v;
            if (v > R) {
                break;
            }
            if (v >= L && isPalindrome(v)) {
                ans.add(v);
            }
        }
        ans.sort(Long::compareTo);
        System.out.println(ans);
    }

    private static boolean isPalindrome(long x) {
        return x == reverse(x);
    }

    private static long reverse(long x) {
        long ans = 0;
        while (x > 0) {
            ans = 10 * ans + x % 10;
            x /= 10;
        }
        return ans;
    }
}
