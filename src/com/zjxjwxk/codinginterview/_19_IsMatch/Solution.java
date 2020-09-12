package com.zjxjwxk.codinginterview._19_IsMatch;

/**
 * 剑指 Offer 19. 正则表达式匹配
 *
 * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'
 * 表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"
 * 与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
 *
 * 示例 1:
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 *
 * 示例 2:
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 *
 * 示例 3:
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 *
 * 示例 4:
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 *
 * 示例 5:
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母以及字符 . 和 *，无连续的 '*'。
 *
 * @author Xinkang Wu
 * @date 2020/9/12 9:10 上午
 */
public class Solution {

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        return isMatchRecursively(s, 0, p, 0);
    }

    private boolean isMatchRecursively(String s, int sIndex, String p, int pIndex) {
        int sLen = s.length(), pLen = p.length();
        if (pIndex == pLen) {
            return sIndex == sLen;
        }
        if (pIndex < pLen - 1 && p.charAt(pIndex + 1) == '*') {
            if (sIndex == sLen || (s.charAt(sIndex) != p.charAt(pIndex) && p.charAt(pIndex) != '.')) {
                return isMatchRecursively(s, sIndex, p, pIndex + 2);
            } else {
                return isMatchRecursively(s, sIndex + 1, p, pIndex + 2)
                        || isMatchRecursively(s, sIndex + 1, p, pIndex)
                        || isMatchRecursively(s, sIndex, p, pIndex + 2);
            }
        }
        if (sIndex < sLen && (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '.')) {
            return isMatchRecursively(s, sIndex + 1, p, pIndex + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isMatch("aa", "a"));
        System.out.println(solution.isMatch("aa", "a*"));
        System.out.println(solution.isMatch("ab", ".*"));
        System.out.println(solution.isMatch("aab", "c*a*b"));
        System.out.println(solution.isMatch("mississippi", "mis*is*p*."));
        System.out.println(solution.isMatch("mississippi", "mis*is*ip*."));
        System.out.println(solution.isMatch("a", "aa"));
        System.out.println(solution.isMatch("a", "ab*"));
        System.out.println(solution.isMatch("a", ".*..a*"));
    }
}