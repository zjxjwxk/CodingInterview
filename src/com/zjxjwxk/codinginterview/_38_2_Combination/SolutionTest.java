package com.zjxjwxk.codinginterview._38_2_Combination;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void combination() {
        String str = "abc";
        String[] result = solution.combination(str);
        String[] ans = {"a", "b", "c", "ab", "ac", "bc", "abc"};
        assertArrayEquals(ans, result);
    }
}