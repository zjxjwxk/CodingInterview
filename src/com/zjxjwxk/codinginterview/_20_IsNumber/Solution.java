package com.zjxjwxk.codinginterview._20_IsNumber;

/**
 * 剑指 Offer 20. 表示数值的字符串
 *
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、
 * "0123"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"及
 * "12e+5.4"都不是。
 *
 * @author Xinkang Wu
 * @date 2020/9/14 11:23 下午
 */
public class Solution {

    public boolean isNumber(String s) {
        if (s == null || s.trim().length() == 0) {
            return false;
        }
        s = s.trim();
        boolean isNumber;
        int begin = 0, len = s.length();
        char c = s.charAt(begin);
        if (c == '+' || c == '-') {
            ++begin;
        }
        int index = scanUnsignedInteger(s, begin);
        isNumber = index > begin;
        if (index < len && s.charAt(index) == '.') {
            ++index;
            begin = index;
            index = scanUnsignedInteger(s, index);
            isNumber = index > begin || isNumber;
        }
        if (index < len - 1 && (s.charAt(index) == 'e' || s.charAt(index) == 'E')) {
            ++index;
            begin = index;
            c = s.charAt(begin);
            if (c == '+' || c == '-') {
                ++begin;
            }
            index = scanUnsignedInteger(s, begin);
            isNumber = index > begin && isNumber;
        }
        return isNumber && index == len;
    }

    private int scanUnsignedInteger(String s, int begin) {
        int i;
        for (i = begin; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') {
                break;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // true
        System.out.println(solution.isNumber("+100"));
        System.out.println(solution.isNumber("5e2"));
        System.out.println(solution.isNumber("-123"));
        System.out.println(solution.isNumber("3.1416"));
        System.out.println(solution.isNumber("-1E-16"));
        System.out.println(solution.isNumber("0123"));
        System.out.println(solution.isNumber("1 "));
        // false
        System.out.println(solution.isNumber("12e"));
        System.out.println(solution.isNumber("1a3.14"));
        System.out.println(solution.isNumber("1.2.3"));
        System.out.println(solution.isNumber("+-5"));
        System.out.println(solution.isNumber("12e+5.4"));
        System.out.println(solution.isNumber(""));
        System.out.println(solution.isNumber("4e+"));
    }
}
