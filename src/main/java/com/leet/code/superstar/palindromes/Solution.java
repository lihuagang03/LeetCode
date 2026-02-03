package com.leet.code.superstar.palindromes;

/**
 * <a href="https://leetcode.cn/problems/super-palindromes/description/">
 *     906. 超级回文数</a>
 *
 * @author lihuagang
 */
public class Solution {
    public int superPalindromesInRange(String left, String right) {
        long L = Long.parseLong(left);
        long R = Long.parseLong(right);
        int MAGIC = 100_000;
        int ans = 0;

        // count odd length
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
                ans++;
            }
        }

        // count even length
        for (int k = 1; k < MAGIC; k++) {
            // 假如 k=1234 那么 R=12344321
            StringBuilder sb = new StringBuilder(Integer.toString(k));
            for (int i = sb.length() - 1; i >= 0; i--) {
                sb.append(sb.charAt(i));
            }
            long v = Long.parseLong(sb.toString());
            v *= v;
            if (v > R) {
                break;
            }
            if (v >= L && isPalindrome(v)) {
                ans++;
            }
        }

        return ans;
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
