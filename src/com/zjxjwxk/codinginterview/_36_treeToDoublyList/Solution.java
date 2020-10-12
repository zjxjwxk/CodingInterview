package com.zjxjwxk.codinginterview._36_treeToDoublyList;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。
 * 要求不能创建任何新的节点，只能调整树中节点指针的指向。
 *
 * 我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有
 * 一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个
 * 节点，最后一个节点的后继是第一个节点。
 *
 * 特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的
 * 左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表
 * 中的第一个节点的指针。
 *
 * @author zjxjwxk
 * @date 2020/10/12 1:30 下午
 */
public class Solution {

    private Node head, pre;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        inorder(root);
        pre.right = head;
        head.left = pre;
        return head;
    }

    private void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (head == null) {
            head = root;
        }
        if (pre != null) {
            pre.right = root;
            root.left = pre;
        }
        pre = root;
        inorder(root.right);
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
