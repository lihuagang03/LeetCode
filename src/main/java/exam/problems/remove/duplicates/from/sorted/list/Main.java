package exam.problems.remove.duplicates.from.sorted.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * <a href="https://pintia.cn/problem-sets/2004497238921478144/exam/problems/type/7?problemSetProblemId=2004497238955032585">
 *     7.10 删除有序链表中重复2次以上元素</a>
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/description/">
 *     82. 删除排序链表中的重复元素 II</a>
 *
 * @author lihuagang
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 第一行包含头节点地址，总节点数量 N （1≤N≤100000）
        // 节点地址用一个 5 位非负整数表示（可能有前导 0），NULL 用 −1 表示。
        String head = in.next();
        int n = in.nextInt();

        Map<String, Node> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String address = in.next();
            int val = in.nextInt();
            String next = in.next();
            map.put(address, new Node(address, val, next));
        }

        // 1️⃣ 按 Next 指针还原链表顺序
        List<Node> list = new ArrayList<>(n);
        String cur = head;
        while (!cur.equals("-1")) {
            Node node = map.get(cur);
            list.add(node);
            cur = node.next;
        }

        // 2️⃣ 过滤：只保留出现 1 次或 2 次的元素
        List<Node> result = new ArrayList<>(n);
        int i = 0;
        while (i < n) {
            int j = i;
            int val = list.get(i).val;

            while (j < n && list.get(j).val == val) {
                j++;
            }
            int count = j - i;
            if (count == 1) {
                result.add(list.get(i));
            } else if (count == 2) {
                result.add(list.get(i));
                result.add(list.get(i + 1));
            }
            // count >= 3 的，直接丢弃

            i = j;
        }

        // 3️⃣ 重新设置 next 并输出
        int rn = result.size();
        for (int k = 0; k < rn; k++) {
            if (k < rn - 1) {
                result.get(k).next = result.get(k + 1).address;
            } else {
                result.get(k).next = "-1";
            }
        }
        for (Node node : result) {
            System.out.printf("%s %d %s\n", node.address, node.val, node.next);
//            System.out.println(node);
        }
    }

    /**
     * 接下来 N 行，每行描述一个节点的信息，格式如下：
     * Address Data Next
     * 其中 Address 是节点地址，Data 是一个绝对值不超过100000的整数，Next 是下一个节点的地址。
     */
    private static class Node {
        String address;
        int val;
        String next;

        Node() {
        }

        Node(String address, int val, String next) {
            this.address = address;
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return address + " " + val + " " + next;
        }
    }
}
