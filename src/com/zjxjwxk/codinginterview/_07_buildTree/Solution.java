package com.zjxjwxk.codinginterview._07_buildTree;

/**
 * 剑指 Offer 07. 重建二叉树
 *
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 限制：
 * 0 <= 节点个数 <= 5000
 *
 * @author zjxjwxk
 * @date 2020/7/21 11:38 下午
 */
public class Solution {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        int len = preorder.length;
        return build(preorder, inorder, 0, len - 1, 0, len - 1);
    }

    public static TreeNode build(int[] preorder, int[] inorder,
                                 int preLeft, int preRight,
                                 int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }
        int root = preorder[preLeft], k, leftNum;
        TreeNode node = new TreeNode(root);
        for (k = inLeft; k <= inRight; ++k) {
            if (inorder[k] == root) {
                break;
            }
        }
        leftNum = k - inLeft;

        node.left = build(preorder, inorder, preLeft + 1, preLeft + leftNum, inLeft, k - 1);
        node.right = build(preorder, inorder, preLeft + leftNum + 1, preRight, k + 1, inRight);
        return node;
    }

    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        TreeNode node = buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        preOrder(node);
    }
}

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
