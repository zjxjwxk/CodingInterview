package com.zjxjwxk.codinginterview._37_SerializeTree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CodecTest {

    private final Codec codec = new Codec();

    @Test
    void deserialize() {
        String str = "1,2,3,2147483647,2147483647,4,5,2147483647,2147483647,2147483647,2147483647";
        Codec.TreeNode head = codec.deserialize(str);
        assertEquals(codec.serialize(head), str);
    }
}