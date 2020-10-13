package com.zjxjwxk.codinginterview._38_Permutation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
 * 回溯剪枝
 * @author zjxjwxk
 * @date 2020/10/12 11:03 下午
 */
public class Solution2 {

    private char[] chArr;
    private List<String> ansList;
    private int len;

    public String[] permutation(String s) {
        len = s.length();
        ansList = new ArrayList<>(len);
        chArr = s.toCharArray();
        dfs(0);
        return ansList.toArray(new String[ansList.size()]);
    }

    private void dfs(int index) {
        if (index >= len) {
            ansList.add(new String(chArr));
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = index; i < len; ++i) {
            if (!set.contains(chArr[i])) {
                set.add(chArr[i]);
                swapChar(index, i);
                dfs(index + 1);
                swapChar(index, i);
            }
        }
    }

    private void swapChar(int index1, int index2) {
        char temp = chArr[index1];
        chArr[index1] = chArr[index2];
        chArr[index2] = temp;
    }
}
