package com.zjxjwxk.codinginterview._37_SerializeTree;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 *
 * 示例: 
 * 你可以将以下二叉树：
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 * 序列化为 "[1,2,3,null,null,4,5]"
 *
 * 前序遍历
 * @author zjxjwxk
 * @date 2020/10/12 9:42 下午
 */
public class Codec2 {

    /**
     * Encodes a tree to a single string.
     * @param root Tree root to serialize
     * @return Serialized string
     */
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializePreOrder(root, sb);
        return sb.toString();
    }

    private void serializePreOrder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("$").append(",");
            return;
        }
        sb.append(root.val).append(",");
        serializePreOrder(root.left, sb);
        serializePreOrder(root.right, sb);
    }

    /**
     * Decodes your encoded data to tree.
     * @param data String to deserialize
     * @return Tree root
     */
    public TreeNode deserialize(String data) {
        String[] strArr = data.split(",");
        int[] index = new int[1];
        index[0] = -1;
        return deserializePreOrder(strArr, index);
    }

    private TreeNode deserializePreOrder(String[] strArr, int[] index) {
        ++index[0];
        String str = strArr[index[0]];
        if ("$".endsWith(str)) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(str));
        node.left = deserializePreOrder(strArr, index);
        node.right = deserializePreOrder(strArr, index);
        return node;
    }

    /**
     * Definition for a binary tree node.
     */
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
