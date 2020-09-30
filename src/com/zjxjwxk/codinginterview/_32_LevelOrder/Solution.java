package com.zjxjwxk.codinginterview._32_LevelOrder;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer 32 - I. 从上到下打印二叉树
 *
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回：
 * [3,9,20,15,7]
 *
 * 提示：
 * 节点总数 <= 1000
 *
 * @author zjxjwxk
 * @date 2020/9/30 10:08 下午
 */
public class Solution {

    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        List<Integer> levelOrderList = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.pollFirst();
            levelOrderList.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        int[] levelOrderArr = new int[levelOrderList.size()];
        for (int i = 0; i < levelOrderArr.length; ++i) {
            levelOrderArr[i] = levelOrderList.get(i);
        }
        return levelOrderArr;
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
