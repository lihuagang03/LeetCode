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
        Scanner in = new Scanner(System.in);
        if (!in.hasNextLine()) {
            return;
        }

        List<String> positives = new ArrayList<>();
        String negative = null;

        String line = in.nextLine();
        String[] numArray = line.split(" ");
        for (String num : numArray) {
            if (num.startsWith("-")) {
                // 只会有一个负数
                negative = num;
            } else {
                positives.add(num);
            }
        }

        StringBuilder result = new StringBuilder();
        if (negative != null) {
            // 情况一：有负数
            // 为了让负数尽量小（绝对值尽量大）
            positives.sort((a, b) -> (b + a).compareTo(a + b));

            result.append(negative);
            for (String num : positives) {
                result.append(num);
            }
        } else {
            // 情况二：全是非负数，全是正整数
            positives.sort((a, b) -> (a + b).compareTo(b + a));

            for (String num : positives) {
                result.append(num);
            }
        }

        System.out.println(result);
    }

}
