package com.zjxjwxk.codinginterview._38_2_Combination;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个字符串，打印出该字符串中字符的所有组合。
 * @author zjxjwxk
 * @date 2020/10/13 7:20 下午
 */
public class Solution {

    private final List<String> ansList = new ArrayList<>();
    private char[] chArr;

    public String[] combination(String s) {
        chArr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int n = 1; n <= chArr.length; ++n) {
            dfs(sb, 0, n);
        }
        return ansList.toArray(new String[0]);
    }

    private void dfs(StringBuilder sb, int index, int n) {
        if (chArr.length - index == n) {
            sb.append(new String(chArr, index, n));
            ansList.add(sb.toString());
            sb.delete(sb.length() - n, sb.length());
            return;
        }
        if (n == 0) {
            ansList.add(sb.toString());
            return;
        }
        sb.append(chArr[index]);
        dfs(sb, index + 1, n - 1);
        sb.deleteCharAt(sb.length() - 1);
        dfs(sb, index + 1, n);
    }
}
