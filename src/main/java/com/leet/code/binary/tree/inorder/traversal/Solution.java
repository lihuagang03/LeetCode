package com.leet.code.binary.tree.inorder.traversal;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-inorder-traversal/">
 *     94. 二叉树的中序遍历</a>
 *
 * @author lihuagang
 */
public class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        // 记录结果
        List<Integer> res = new LinkedList<>();
        traverse(root, res);
        return res;
    }

    private void traverse(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        traverse(root.left, res);
        res.add(root.val);
        traverse(root.right, res);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
