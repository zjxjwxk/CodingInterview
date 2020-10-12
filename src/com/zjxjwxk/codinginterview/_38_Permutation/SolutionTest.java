package com.zjxjwxk.codinginterview._38_Permutation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void permutation() {
        String s = "abc";
        String[] ans = {"abc", "acb", "bac", "bca", "cab", "cba"};
        String[] result = solution.permutation(s);
        assertArrayEquals(ans, result);
    }
}