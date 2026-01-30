package exam.problems.reverse.linked.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * <a href="https://pintia.cn/problem-sets/2004497238921478144/exam/problems/type/7?problemSetProblemId=2004497238955032580">
 *     7.05 分段反转链表</a>
 * <a href="https://leetcode.cn/problems/reverse-linked-list-ii/description/">
 *     92. 反转链表 II</a>
 *
 * @author lihuagang
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 第一行包含头节点地址，总节点数量 N 以及常数 K。
        // 1≤N≤100000，1≤K≤N 。
        // 节点地址用一个 5 位非负整数表示（可能有前导 0），NULL 用 -1 表示。
        String head = in.next();
        int n = in.nextInt();
        int k = in.nextInt();

        Map<String, Node> map = new HashMap<>();

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

        // 2.分段反转链表
        int it = n / k;
        for (int i = 0; i < it; i++) {
            int left = i * k;
            int right = left + k - 1;
            while (left < right) {
                Node ln = list.get(left);
                Node rn = list.get(right);
                list.set(left, rn);
                list.set(right, ln);
                left++;
                right--;
            }
        }

        // 3.重新设置 next 并输出
        int size = list.size();
        int end = size - 1;
        for (int i = 0; i < size; i++) {
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

    /**
     * 接下来 N 行，每行描述一个节点的信息，格式如下：
     * Address Data Next
     * 其中 Address 是节点地址，Data 是一个绝对值不超过100000的整数，Next 是下一个节点的地址。
     */
    private static class Node {
        String address;
        int data;
        String next;

        Node(String address, int data, String next) {
            this.address = address;
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return address + " " + data + " " + next;
        }
    }
}
