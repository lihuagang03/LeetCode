package exam.problems.triples.with.bitwise.and.equal.to.zero;

import java.util.Scanner;

/**
 * <a href="https://pintia.cn/problem-sets/2004497865353367552/exam/problems/type/7?problemSetProblemId=2004497865374339080">
 *     7.09 按位与为零的三元组</a>
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
        String input = in.nextLine();
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

        int D = 1 << 16;
        int[] cnt = new int[D];
        for (int x : nums) {
            for (int y : nums) {
                cnt[x & y]++;
            }
        }
        int ans = 0;
        for (int x : nums) {
            for (int y = 0; y < D; y++) {
                if ((x & y) == 0) {
                    ans += cnt[y];
                }
            }
        }
        System.out.println(ans);
    }
}
