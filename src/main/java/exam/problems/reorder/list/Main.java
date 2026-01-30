package exam.problems.reorder.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * <a href="https://pintia.cn/problem-sets/2004497238921478144/exam/problems/type/7?problemSetProblemId=2004497238955032586">
 *     7.11 按格式重排链表</a>
 *
 * @author lihuagang
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 第一行包含头节点地址，总节点数量 N （1≤N≤100000）
        // 节点地址用一个 5 位非负整数表示（可能有前导 0），空地址 NULL 用 −1 表示。
        String head = in.next();
        int n = in.nextInt();

        Map<String, Node> map = new HashMap<>(n * 4 / 3 + 1);

        for (int i = 0; i < n; i++) {
            String address = in.next();
            int data = in.nextInt();
            String next = in.next();
            map.put(address, new Node(address, data, next));
        }

        // 1.按 Next 指针还原链表顺序
        List<Node> list = new ArrayList<>(n);
        String cur = head;
        while (!cur.equals("-1")) {
            Node node = map.get(cur);
            list.add(node);
            cur = node.next;
        }

        // 2.按格式重排链表
        List<Node> result = new ArrayList<>(n);
        int left = 0;
        int right = n - 1;
        while (left < right) {
            Node ln = list.get(left);
            Node rn = list.get(right);
            result.add(rn);
            result.add(ln);
            left++;
            right--;
        }
        // 奇数个
        if (left == right) {
            result.add(list.get(left));
        }
        list = result;

        // 3.重新设置 next 并输出
        int end = n - 1;
        for (int i = 0; i < n; i++) {
            if (i < end) {
                list.get(i).next = list.get(i + 1).address;
            } else {
                list.get(i).next = "-1";
            }
        }
        for (Node node : list) {
            System.out.printf("%s %d %s\n", node.address, node.data, node.next);
        }
    }

    private static class Node {
        String address;
        int data;
        String next;

        public Node(String address, int data, String next) {
            this.address = address;
            this.data = data;
            this.next = next;
        }
    }
}
