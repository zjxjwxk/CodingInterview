package com.zjxjwxk.codinginterview._34_PathSum;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 34. 二叉树中和为某一值的路径
 *
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数
 * 的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成
 * 一条路径。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * 提示：
 * 节点总数 <= 10000
 *
 * @author zjxjwxk
 * @date 2020/10/4 11:10 下午
 */
public class Solution {

    private final List<Integer> path = new ArrayList<>();
    private final List<List<Integer>> pathList = new ArrayList<>();
    private int sum;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        this.sum = sum;
        findPath(root, 0);
        return pathList;
    }

    private void findPath(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        sum += root.val;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == this.sum) {
                pathList.add(new ArrayList<>(path));
            }
            path.remove(path.size() - 1);
            return;
        }
        findPath(root.left, sum);
        findPath(root.right, sum);
        path.remove(path.size() - 1);
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
