package exam.problems.merge.two.lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * <a href="https://pintia.cn/problem-sets/2004497865353367552/exam/problems/type/7?problemSetProblemId=2004497865374339072">
 *     7.01 按格式合并两个链表</a>
 *
 * @author lihuagang
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 第一行包含两个链表的第一个节点地址（不确定哪个链表更长），以及两个链表的总节点数N(≤100000)。
        // 节点地址用一个 5 位非负整数表示（可能有前导 0），空地址 NULL 用 −1 表示。
        String head1 = in.next();
        String head2 = in.next();
        int n = in.nextInt();
        if (n <= 0) {
            return;
        }

        Map<String, Node> map = new HashMap<>(n * 4 / 3 + 1);
        for (int i = 0; i < n; i++) {
            String address = in.next();
            int data = in.nextInt();
            String next = in.next();
            map.put(address, new Node(address, data, next));
        }

        // 1.按 Next 指针还原链表顺序
        // 较长的链表L1
        List<Node> longList = new ArrayList<>(n);
        String cur = head1;
        while (!cur.equals("-1")) {
            Node node = map.get(cur);
            longList.add(node);
            cur = node.next;
        }
        // 较短的链表L2
        List<Node> shortList = new ArrayList<>(n);
        cur = head2;
        while (!cur.equals("-1")) {
            Node node = map.get(cur);
            shortList.add(node);
            cur = node.next;
        }
        if (longList.size() < shortList.size()) {
            List<Node> temp = longList;
            longList = shortList;
            shortList = temp;
        }

        // 2.按格式合并两个链表
        // 将较短的链表L2反转并合并到较长的链表L1中
        // 合并规则：在长链表中每隔两个元素，将短链表中的元素倒序插入。
        List<Node> list = new ArrayList<>(n);
        int right = shortList.size() - 1;
        int left = 0;
        while (right >= 0) {
            list.add(longList.get(left++));
            list.add(longList.get(left++));
            list.add(shortList.get(right--));
        }
        while (left < longList.size()) {
            list.add(longList.get(left++));
        }

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
