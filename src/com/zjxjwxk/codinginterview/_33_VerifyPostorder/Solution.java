package com.zjxjwxk.codinginterview._33_VerifyPostorder;

/**
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 *
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 * 如果是则返回 true，否则返回 false。假设输入的数组的任意两个
 * 数字都互不相同。
 *
 * 参考以下这颗二叉搜索树：
 *      5
 *     / \
 *    2   6
 *   / \
 *  1   3
 *
 * 示例 1：
 * 输入: [1,6,3,2,5]
 * 输出: false
 *
 * 示例 2：
 * 输入: [1,3,2,6,5]
 * 输出: true
 *
 * 提示：
 * 数组长度 <= 1000
 *
 * @author zjxjwxk
 * @date 2020/10/4 1:54 下午
 */
public class Solution {

    public boolean verifyPostorder(int[] postorder) {
        int len;
        if (postorder == null || (len = postorder.length) == 0) {
            return true;
        }
        return verify(postorder, 0, len - 1);
    }

    private boolean verify(int[] postorder, int left, int right) {
        if (left > right) {
            return true;
        }
        int root = postorder[right], i, j;
        for (i = left; i <= right - 1; ++i) {
            if (postorder[i] > root) {
                break;
            }
        }
        for (j = i; j <= right - 1; ++j) {
            if (postorder[j] < root) {
                return false;
            }
        }
        boolean verifyLeft = true, verifyRight = true;
        if (i > left) {
            verifyLeft = verify(postorder, left, i - 1);
        }
        if (j > i) {
            verifyRight = verify(postorder, i, right - 1);
        }
        return verifyLeft && verifyRight;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.verifyPostorder(new int[]{1,3,2,6,5}));
    }
}
