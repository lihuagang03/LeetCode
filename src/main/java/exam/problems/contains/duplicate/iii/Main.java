package exam.problems.contains.duplicate.iii;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * <a href="https://pintia.cn/problem-sets/2004497238921478144/exam/problems/type/7?problemSetProblemId=2004497238955032584">
 *     7.09 存在重复元素3</a>
 * <a href="https://leetcode.cn/problems/contains-duplicate-iii/description/">
 *     220. 存在重复元素 III</a>
 *
 * @author lihuagang
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        String[] parts = input.split(",");
        int[] numbers = numbers(parts[0]);
        int indexDiff = Integer.parseInt(parts[1]);
        int valueDiff = Integer.parseInt(parts[2]);

        int result = containsNearbyAlmostDuplicate(numbers, indexDiff, valueDiff);
        System.out.println(result);
    }

    public static int[] numbers(String input) {
        String[] parts = input.split(" ");
        int len = parts.length;
        int[] numbers = new int[len];
        for (int i = 0; i < len; i++) {
            numbers[i] = Integer.parseInt(parts[i]);
        }
        return numbers;
    }

    public static int containsNearbyAlmostDuplicate(
            int[] numbers, int indexDiff, int valueDiff) {
        int len = numbers.length;
        // 使用队列维护滑动窗口内的元素
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < len; i++) {
            Integer ceiling = set.ceiling(numbers[i] - valueDiff);
            if (ceiling != null && ceiling <= (numbers[i] + valueDiff)) {
                return 1;
            }
            set.add(numbers[i]);
            // 使用队列维护滑动窗口内的元素
            if (i >= indexDiff) {
                set.remove(numbers[i - indexDiff]);
            }
        }
        return 0;
    }
}
