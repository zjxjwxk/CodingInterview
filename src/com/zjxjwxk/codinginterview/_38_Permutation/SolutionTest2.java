package com.zjxjwxk.codinginterview._38_Permutation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest2 {

    private final Solution2 solution2 = new Solution2();

    @Test
    void permutation() {
        String s = "abcc";
        String[] ans = {"abcc", "acbc", "accb", "bacc", "bcac", "bcca", "cabc", "cacb", "cbac", "cbca", "ccab", "ccba"};
        String[] result = solution2.permutation(s);
        assertArrayEquals(ans, result);
    }
}