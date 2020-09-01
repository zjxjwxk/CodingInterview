package com.zjxjwxk.codinginterview._17_PrintNumbers;

import java.util.Arrays;

/**
 * 剑指 Offer 17. 打印从1到最大的n位数
 *
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，
 * 则打印出 1、2、3 一直到最大的 3 位数 999。
 *
 * 示例 1:
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 *
 * 说明：
 * 用返回一个整数列表来代替打印
 * n 为正整数
 *
 * @author Xinkang Wu
 * @date 2020/9/2 12:06 上午
 */
public class Solution {

    public static void printNumbers(int n) {
        char[] number = new char[n];
        Arrays.fill(number, '0');
        System.out.print('[');
        boolean firstFlag = true;
        while (increment(number)) {
            if (!firstFlag) {
                System.out.print(',');
            }
            printNumber(number);
            firstFlag = false;
        }
        System.out.print(']');
    }

    public static boolean increment(char[] number) {
        int nTakeOver = 0, len = number.length;
        for (int i = len - 1; i >= 0; --i) {
            int sum = number[i] - '0' + nTakeOver;
            if (i == len - 1) {
                ++sum;
            }
            if (sum >= 10) {
                if (i == 0) {
                    return false;
                }
                sum -= 10;
                nTakeOver = 1;
                number[i] = (char) ('0' + sum);
            } else {
                number[i] = (char) ('0' + sum);
                break;
            }
        }
        return true;
    }

    public static void printNumber(char[] number) {
        boolean beginZeroFlag = true;
        for (char c : number) {
            if (beginZeroFlag && c != '0') {
                beginZeroFlag = false;
            }
            if (!beginZeroFlag) {
                System.out.print(c);
            }
        }
    }

    public static void main(String[] args) {
        printNumbers(2);
    }
}
