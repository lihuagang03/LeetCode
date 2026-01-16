package exam.problems.reverse.linked.list;

import java.util.HashMap;
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
        String line = in.nextLine();
        String[] strings = line.split(" ");
        String headAddress = strings[0];
        int n = Integer.parseInt(strings[1]);
        int k = Integer.parseInt(strings[2]);

        Map<String, ListNode> addressNodeMap = new HashMap<>();

        while (in.hasNextLine()) {
            line = in.nextLine();
            if ("".equals(line)) {
                break;
            }
            strings = line.split(" ");
            ListNode node = new ListNode(strings[0], Integer.parseInt(strings[1]), strings[2]);
            addressNodeMap.put(node.address, node);
        }

        // 构建链表
        ListNode dummyHead = buildList(headAddress, addressNodeMap);

        // 分段反转链表
        ListNode prev = dummyHead;
        ListNode head = prev.next;
        ListNode tailNext = head.next;
        // 迭代遍历地反转
        int iterationNumber = n / k;
        for (int i = 0; i < iterationNumber; i++) {
            int j = 1;
            while (j++ < k) {
                tailNext = tailNext.next;
            }

            prev.next = reverseList(head, tailNext);
            prev.nextAddress = prev.next.address;

            prev = head;
            head = prev.next;
            if (head == null) {
                prev.nextAddress = "-1";
                break;
            }
            tailNext = head.next;
        }

        // 打印链接
        ListNode cur = dummyHead.next;
        while (cur != null) {
            System.out.print(cur);
            cur = cur.next;
            if (cur != null) {
                System.out.println();
            }
        }
    }

    private static ListNode reverseList(ListNode head, ListNode tailNext) {
        ListNode prev = tailNext;
        ListNode cur = head;
        while (cur != tailNext) {
            ListNode next = cur.next;
            cur.next = prev;
            // 下一个节点的地址
            if (prev != null) {
                cur.nextAddress = prev.address;
            }
            prev = cur;
            cur = next;
        }
        return prev;
    }

    private static ListNode buildList(String nextAddress, Map<String, ListNode> addressNodeMap) {
        // 哑结点
        ListNode dummyHead = new ListNode();
        ListNode prev = dummyHead;

        while (true) {
            // 节点地址用一个 5 位非负整数表示（可能有前导 0），NULL 用 −1 表示。
            if ("−1".equals(nextAddress)) {
                return dummyHead;
            }
            ListNode node = addressNodeMap.get(nextAddress);
            if (node == null) {
                return dummyHead;
            }
            prev.next = node;
            prev = prev.next;
            nextAddress = node.nextAddress;
        }
    }

    /**
     * 接下来 N 行，每行描述一个节点的信息，格式如下：
     * Address Data Next
     * 其中 Address 是节点地址，Data 是一个绝对值不超过100000的整数，Next 是下一个节点的地址。
     */
    private static class ListNode {
        String address;
        int data;
        String nextAddress;
        ListNode next;

        ListNode() {
        }

        ListNode(String address, int data, String nextAddress) {
            this.address = address;
            this.data = data;
            this.nextAddress = nextAddress;
        }

        @Override
        public String toString() {
            return address + " " + data + " " + nextAddress;
        }
    }

}
