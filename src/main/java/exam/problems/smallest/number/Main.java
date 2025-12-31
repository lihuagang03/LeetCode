package exam.problems.smallest.number;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <a href="https://pintia.cn/problem-sets/2004497238921478144/exam/problems/type/7?problemSetProblemId=2004497238955032579">
 *     7.04 最小数</a>
 *
 * @author lihuagang
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) {
            return;
        }

        List<String> positives = new ArrayList<>();
        // 只会有一个负数
        String negative = null;

        String line = sc.nextLine();
        String[] numArray = line.split(" ");
        // 1. 分离正数和负数
        for (String num : numArray) {
            if (num.startsWith("-")) {
                negative = num;
            } else {
                positives.add(num);
            }
        }

        // 3. 拼接结果
        StringBuilder sb = new StringBuilder();

        if (negative != null) {
            // 情况一：有负数
            // 为了让负数尽量小（绝对值尽量大）
            // 如果有负数，负数放在最前面，后面拼接最大的正数排列（因为是负值，后面数值越大整体越小）
            // 注意：题目要求组成最小整数，对于负数 -9 来说，后面接 53430 比接 30345 更小 (-953430 < -930345)
            // 因此，当存在负数时，正数部分需要按照“降序拼接”才能使整体负值最小
            positives.sort((a, b) -> (b + a).compareTo(a + b));

            sb.append(negative);
        } else {
            // 情况二：全是正数
            // 2. 对正数进行自定义排序
            // 规则：若 a + b > b + a，则把大的往后放，以组成最小数
            // 如果全是正数，按“升序拼接”
            // (已经在上面 sort 过一次，如果是全正数则无需重排)
            positives.sort((a, b) -> (a + b).compareTo(b + a));
        }
        for (String num : positives) {
            sb.append(num);
        }

        System.out.println(sb);
    }

}
