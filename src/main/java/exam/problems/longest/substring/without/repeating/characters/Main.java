package exam.problems.longest.substring.without.repeating.characters;

import java.util.Scanner;

/**
 * <a href="https://pintia.cn/problem-sets/2004497865353367552/exam/problems/type/7?problemSetProblemId=2004497865374339079">
 *     7.08 无重复字符的最长子串</a>
 * <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/">
 *     3. 无重复字符的最长子串</a>
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
        int n = s.length();
        // 提示：s 由英文字母、数字、符号和空格组成
        // 滑动窗口计数器
        int[] window = new int[128];
        // 最长子串 的长度
        int maxLen = 0;

        // 左右指针
        int left = 0;
        int right = 0;
        while (right < n) {
            char c = s.charAt(right);
            right++;
            // 进行窗口内数据的一系列更新
            window[c]++;

            // 判断左侧窗口是否要收缩
            while (window[c] > 1) {
                char d = s.charAt(left);
                left++;
                window[d]--;
            }
            maxLen = Math.max(maxLen, right - left);
        }
        System.out.println(maxLen);
    }
}
