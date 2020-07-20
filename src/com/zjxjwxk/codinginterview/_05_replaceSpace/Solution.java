package com.zjxjwxk.codinginterview._05_replaceSpace;

import java.util.Arrays;

/**
 * 剑指 Offer 05. 替换空格
 *
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * 示例 1：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 * 限制：
 * 0 <= s 的长度 <= 10000
 *
 * @author zjxjwxk
 * @date 2020/7/19 10:56 下午
 */
public class Solution {
    public static String replaceSpace(String s) {
        if (s == null) {
            return null;
        }
        if (s.length() == 0) {
            return s;
        }
        char[] str = s.toCharArray();
        int blankCount = 0, newLength;
        for (int i = 0; i < str.length; ++i) {
            if (str[i] == ' ') {
                ++blankCount;
            }
        }
        newLength = str.length + blankCount * 2;
        char[] newStr = Arrays.copyOf(str, newLength);
        int i = str.length - 1, j = newLength - 1;
        while (i != j) {
            if (newStr[i] != ' ') {
                newStr[j--] = newStr[i];
            } else {
                newStr[j--] = '0';
                newStr[j--] = '2';
                newStr[j--] = '%';
            }
            --i;
        }
        return String.valueOf(newStr);
    }

    public static void main(String[] args) {
        System.out.println(replaceSpace("We are happy."));
    }
}
