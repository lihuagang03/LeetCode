package exam.problems.max.chunks.to.make.sorted.ii;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * <a href="https://pintia.cn/problem-sets/2004497865353367552/exam/problems/type/7?problemSetProblemId=2004497865374339077">
 *     7.06 最多能完成排序的块</a>
 * <a href="https://leetcode.cn/problems/max-chunks-to-make-sorted-ii/description/">
 *     768. 最多能完成排序的块 II</a>
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
        String[] parts = s.split(" ");
        int n = parts.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }

        Deque<Integer> stack = new LinkedList<>();
        for (int num : nums) {
            if (!stack.isEmpty() && num < stack.getLast()) {
                int head = stack.removeLast();
                // 移除堆栈中所有比 num 小的数
                while (!stack.isEmpty() && num < stack.getLast()) {
                    stack.removeLast();
                }
                // 只保留比 num 大的数
                stack.addLast(head);
            } else {
                stack.addLast(num);
            }
        }
        System.out.println(stack.size());
    }
}
