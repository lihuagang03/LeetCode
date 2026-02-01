package exam.problems.longest.substring.without.repeating.characters;

import java.util.Scanner;

/**
 * TODO
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

        int[] window = new int[128];
        int maxLen = 0;

        int left = 0;
        int right = 0;
        while (right < n) {
            char c = s.charAt(right);
            right++;
            window[c]++;

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
