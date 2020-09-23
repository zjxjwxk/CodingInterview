package com.zjxjwxk.codinginterview._27_MirrorTree;

/**
 * @author Xinkang Wu
 * @date 2020/9/23 6:50 下午
 */
public class Solution {

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode node = new TreeNode(root.val);
        node.left = mirrorTree(root.right);
        node.right = mirrorTree(root.left);
        return node;
    }

    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
