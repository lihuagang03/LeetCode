package exam.problems.validate.stack.sequences;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * <a href="https://pintia.cn/problem-sets/2004497238921478144/exam/problems/type/7?problemSetProblemId=2004497238955032582">
 *     7.07 验证栈序列</a>
 * <a href="https://leetcode.cn/problems/validate-stack-sequences/description/">
 *     946. 验证栈序列</a>
 *
 * @author lihuagang
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String push = in.nextLine();
        String pop = in.nextLine();
        int[] pushed = toArray(push);
        int[] popped = toArray(pop);
        boolean result = canJump(pushed, popped);
        System.out.println(result);
    }

    private static boolean canJump(int[] pushed, int[] popped) {
        Deque<Integer> deque = new ArrayDeque<>(pushed.length);
        for (int i = 0, j = 0; i < pushed.length; i++) {
            deque.addLast(pushed[i]);
            while (!deque.isEmpty() && deque.peekLast() == popped[j]) {
                deque.pollLast();
                j++;
            }
        }
        return deque.isEmpty();
    }

    private static int[] toArray(String line) {
        String[] array = line.split(",");
        int[] nums = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            nums[i] = Integer.parseInt(array[i]);
        }
        return nums;
    }

}
