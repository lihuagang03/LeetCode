package exam.problems.minimum.remove.to.make.valid.parentheses;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

/**
 * <a href="https://pintia.cn/problem-sets/2004497238921478144/exam/problems/type/7?problemSetProblemId=2004497238955032577">
 * 7.02 删除无效的括号</a>
 * <a href="https://leetcode.cn/problems/minimum-remove-to-make-valid-parentheses/description/">
 * 1249. 移除无效的括号</a>
 *
 * @author lihuagang
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if (!in.hasNextLine()) {
            return;
        }

        String str = in.nextLine();

        // 移除的下标
        Set<Integer> indexToRemove = new HashSet<>();
        // "(" 的索引
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else if (ch == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    indexToRemove.add(i);
                }
            }
        }

        // 多余的 "(" 的索引
        while (!stack.isEmpty()) {
            indexToRemove.add(stack.pop());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (!indexToRemove.contains(i)) {
                sb.append(str.charAt(i));
            }
        }
        System.out.println(sb);
    }

}
