package exam.problems.binary.tree.inorder.traversal;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * <a href="https://pintia.cn/problem-sets/2004497238921478144/exam/problems/type/7?problemSetProblemId=2004497238955032583">
 *     7.08 二叉树的中序遍历</a>
 * <a href="https://leetcode.cn/problems/binary-tree-inorder-traversal/description/">
 *     94. 二叉树的中序遍历</a>
 *
 * @author lihuagang
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        // 构建二叉树
        TreeNode root = buildTree(input);

        // 中序遍历
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);

        // 输出结果
        for (int i = 0; i < result.size(); i++) {
            if (i > 0) {
                System.out.print(',');
            }
            System.out.print(result.get(i));
        }
        System.out.println();
    }

    // 根据层序数组构建二叉树
    private static TreeNode buildTree(String input) {
        if (input == null || input.isEmpty()) {
            return null;
        }

        String[] parts = input.split(",");
        if (parts[0].equals("null")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(parts[0]));
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);

        int index = 1;
        while (!deque.isEmpty() && index < parts.length) {
            TreeNode current = deque.poll();

            // 左子节点
            if (!parts[index].equals("null")) {
                current.left = new TreeNode(Integer.parseInt(parts[index]));
                deque.offer(current.left);
            }
            index++;

            // 右子节点
            if (index < parts.length && !parts[index].equals("null")) {
                current.right = new TreeNode(Integer.parseInt(parts[index]));
                deque.offer(current.right);
            }
            index++;
        }

        return root;
    }

    // 中序遍历（左 -> 根 -> 右）
    private static void inorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left, result);
        result.add(root.val);
        inorderTraversal(root.right, result);
    }

    // 二叉树节点定义
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
