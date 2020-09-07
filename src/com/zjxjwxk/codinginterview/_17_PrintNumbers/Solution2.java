package com.zjxjwxk.codinginterview._17_PrintNumbers;

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
 * @date 2020/9/7 10:50 下午
 */
public class Solution2 {

    public static void printNumbers(int n) {
        char[] number = new char[n];
        for (int i = 0; i < n; ++i) {
            number[i] = '0';
        }
        printNumbersRecursively(number, 0);
    }

    private static void printNumbersRecursively(char[] number, int index) {
        if (index == number.length) {
            return;
        }
        for (int i = 0; i <= 9; ++i) {
            number[index] = (char) ('0' + i);
            if (index == number.length - 1) {
                printNumber(number);
            } else {
                printNumbersRecursively(number, index + 1);
            }
        }
    }

    private static void printNumber(char[] number) {
        for (int i = 0; i < number.length; ++i) {
            if (number[i] != '0') {
                System.out.println(number[i]);
            }
        }
    }

    public static void main(String[] args) {
        printNumbers(1);
    }
}
