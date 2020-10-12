package com.zjxjwxk.codinginterview._36_treeToDoublyList;

/**
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
