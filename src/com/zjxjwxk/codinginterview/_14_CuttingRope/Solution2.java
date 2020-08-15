package com.zjxjwxk.codinginterview._14_CuttingRope;

/**
 * 剑指 Offer 14- II. 剪绳子 II
 *
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m - 1] 。请问 k[0]*k[1]*...*k[m - 1] 可能
 * 的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此
 * 时得到的最大乘积是18。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 *
 * 示例 2:
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 *
 * 提示：
 * 2 <= n <= 1000
 *
 * 贪心解法
 * @author zjxjwxk
 * @date 2020/8/9 12:04 上午
 */
public class Solution2 {

    public static int cuttingRope(int n) {
        if (n == 2) {
            return 1;
        } else if (n == 3) {
            return 2;
        }
        int timesOf3 = n / 3;
        if ((n - timesOf3 * 3) == 1) {
            --timesOf3;
        }
        int timesOf2 = (n - timesOf3 * 3) / 2;
        long res = 1, mod = (long) (1e9 + 7);
        for (int i = 0; i < timesOf3; ++i) {
            res = res * 3 % mod;
        }
        return (int) (res * (int) Math.pow(2, timesOf2) % mod);
    }

    public static void main(String[] args) {
        System.out.println(cuttingRope(120));
    }
}
