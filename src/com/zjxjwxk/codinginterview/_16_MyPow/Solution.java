package com.zjxjwxk.codinginterview._16_MyPow;

/**
 * 剑指 Offer 16. 数值的整数次方
 *
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。
 * 不得使用库函数，同时不需要考虑大数问题。
 *
 * 示例 1:
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 *
 * 示例 2:
 * 输入: 2.10000, 3
 * 输出: 9.26100
 *
 * 示例 3:
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2^(-2) = 1/(2^2) = 1/4 = 0.25
 *
 * 说明:
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−2^(31), 2^(31) − 1] 。
 *
 * @author Xinkang Wu
 * @date 2020/8/27 11:30 下午
 */
public class Solution {

    public static double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        long b = n;
        double result = 1.0;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b != 0) {
            if ((b & 1) == 1) {
                result *= x;
            }
            x *= x;
            b >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.00000, -2147483648));
    }
}
