package com.zjxjwxk.codinginterview._31_ValidateStackSequences;

/**
 * @author zjxjwxk
 * @date 2020/9/28 8:33 下午
 */
public class Solution {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int[] stack = new int[1000];
        int len = popped.length, j = 0, index = -1;
        for (int popNum : popped) {
            if (index == -1 || stack[index] != popNum) {
                while (index == -1 || stack[index] != popNum) {
                    if (j == len) {
                        return false;
                    }
                    stack[++index] = pushed[j++];
                }
            }
            --index;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] pushed = new int[]{1, 2, 3, 4, 5}, popped = new int[]{4,3,5,1,2};
//        int[] pushed = new int[]{1, 2, 3, 4, 5}, popped = new int[]{4, 5, 3, 2, 1};
        System.out.println(solution.validateStackSequences(pushed, popped));
    }
}
