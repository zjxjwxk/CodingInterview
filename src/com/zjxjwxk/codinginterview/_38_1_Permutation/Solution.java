package com.zjxjwxk.codinginterview._38_1_Permutation;

import java.util.HashSet;
import java.util.Set;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 *
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 * 示例:
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 *
 * 限制：
 * 1 <= s 的长度 <= 8
 *
 * 暴力枚举
 * @author zjxjwxk
 * @date 2020/10/12 3:42 下午
 */
public class Solution {

    private final Set<String> ansSet = new HashSet<>();
    private boolean[] visited;
    private int len;

    public String[] permutation(String s) {
        len = s.length();
        visited = new boolean[len];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; ++i) {
            recursive(sb, s, i);
            visited[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
        int ansLen = ansSet.size(), index = 0;
        String[] ans = new String[ansLen];
        for (String str : ansSet) {
            ans[index++] = str;
        }
        return ans;
    }

    private void recursive(StringBuilder sb, String s, int index) {
        visited[index] = true;
        sb.append(s.charAt(index));
        if (sb.length() == len) {
            ansSet.add(sb.toString());
            return;
        }
        for (int i = 0; i < len; ++i) {
            if (!visited[i]) {
                recursive(sb, s, i);
                visited[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
