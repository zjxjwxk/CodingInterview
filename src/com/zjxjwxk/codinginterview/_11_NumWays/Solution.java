package com.zjxjwxk.codinginterview._11_NumWays;

/**
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该
 * 青蛙跳上一个 n 级的台阶总共有多少种跳法。答案需要取模
 * 1e9+7（1000000007），如计算初始结果为：1000000008，
 * 请返回 1。
 *
 * 示例 1：
 * 输入：n = 2
 * 输出：2
 *
 * 示例 2：
 * 输入：n = 7
 * 输出：21
 *
 * 提示：
 * 0 <= n <= 100
 *
 * @author zjxjwxk
 * @date 2020/7/26 11:10 下午
 */
public class Solution {
    public static int numWays(int n) {
        int[] result = new int[]{1, 1};
        if (n >= 0 && n <= 1) {
            return result[n];
        }
        int fibN = 0, fibA = 1, fibB = 1;
        for (int i = 2; i <= n; ++i) {
            fibN = (fibA + fibB) % 1000000007;
            fibA = fibB;
            fibB = fibN;
        }
        return fibN;
    }

    public static void main(String[] args) {
        System.out.println(numWays(7));
    }
}
