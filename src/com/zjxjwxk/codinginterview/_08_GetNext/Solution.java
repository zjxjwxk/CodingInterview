package com.zjxjwxk.codinginterview._08_GetNext;

/**
 * 剑指 Offer 08. 二叉树的下一个节点
 *
 * 给定一课二叉树和其中的一个节点，如何找出中序遍历序列
 * 的下一个节点？树中的节点除了有两个分别指向左、右子节
 * 点的指针，还有一个指向父节点的指针。
 *
 * @author zjxjwxk
 * @date 2020/7/23 9:10 下午
 */
public class Solution {
    public static TreeNode getNext(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode nextNode = null, temp;
        if (node.right != null) {
            temp = node.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            nextNode = temp;
        } else if (node.parent != null) {
            temp = node;
            while (temp.parent != null && temp.parent.right == temp) {
                temp = temp.parent;
            }
            nextNode = temp.parent;
        }
        return nextNode;
    }

    /**
     * 例如：
     *       a
     *     /   \
     *    b     c
     *   / \   / \
     *  d   e f   g
     *     / \
     *    h   i
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode('a');
        root.left = new TreeNode('b');
        root.left.parent = root;
        root.left.left = new TreeNode('d');
        root.left.left.parent = root.left;
        root.left.right = new TreeNode('e');
        root.left.right.parent = root.left;
        root.left.right.left = new TreeNode('h');
        root.left.right.left.parent = root.left.right;
        root.left.right.right = new TreeNode('i');
        root.left.right.right.parent = root.left.right;

        root.right = new TreeNode('c');
        root.right.parent = root;
        root.right.left = new TreeNode('f');
        root.right.left.parent = root.right;
        root.right.right = new TreeNode('g');
        root.right.right.parent = root.right;

        // b 的下一个节点为 h
        System.out.println(getNext(root.left).val);
        // d 的下一个节点为 b
        System.out.println(getNext(root.left.left).val);
        // i 的下一个节点为 a
        System.out.println(getNext(root.left.right.right).val);
    }
}

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    char val;
    TreeNode left;
    TreeNode right;
    TreeNode parent;
    TreeNode(char x) { val = x; }
}