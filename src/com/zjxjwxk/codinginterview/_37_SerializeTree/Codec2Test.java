package com.zjxjwxk.codinginterview._37_SerializeTree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Codec2Test {

    private final Codec2 codec2 = new Codec2();

    @Test
    void serialize() {

    }

    @Test
    void deserialize() {
        String str = "1,2,4,$,$,$,3,5,$,$,6,$,$,";
        Codec2.TreeNode head = codec2.deserialize(str);
        assertEquals(str, codec2.serialize(head));
    }
}