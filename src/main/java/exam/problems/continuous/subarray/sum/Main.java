package exam.problems.continuous.subarray.sum;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * <a href="https://pintia.cn/problem-sets/2004497238921478144/exam/problems/type/7?problemSetProblemId=2004497238955032576">
 *     7.01 连续的子数组和</a>
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String numLine = in.nextLine();
            int k = in.nextInt();

            String[] numArray = numLine.split(",");

            int length = numArray.length;
            int[] nums = new int[length];
            for (int i = 0; i < length; i++) {
                nums[i] = Integer.parseInt(numArray[i]);
            }

            // 前缀和
            int[] sums = new int[length + 1];
            for (int i = 1; i <= length; i++) {
                sums[i] = sums[i - 1] + nums[i - 1];
            }

            // 同余定理
            // 哈希表
            Set<Integer> set = new HashSet<>();
            for (int i = 2; i <= length; i++) {
                set.add(sums[i - 1] % k);
                if (set.contains(sums[i] % k)) {
                    System.out.println(1);
                    return;
                }
            }
            System.out.println(0);
        }
    }

}
