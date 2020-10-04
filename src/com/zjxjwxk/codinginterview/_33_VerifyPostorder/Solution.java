package com.zjxjwxk.codinginterview._33_VerifyPostorder;

/**
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
