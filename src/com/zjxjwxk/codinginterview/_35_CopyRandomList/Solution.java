package com.zjxjwxk.codinginterview._35_CopyRandomList;

/**
 * @author zjxjwxk
 * @date 2020/10/4 11:20 下午
 */
public class Solution {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        copyOriginalList(head);
        setRandom(head);
        return getRandomList(head);
    }

    private void copyOriginalList(Node head) {
        while (head != null) {
            Node newNode = new Node(head.val);
            newNode.next = head.next;
            head.next = newNode;
            head = newNode.next;
        }
    }

    private void setRandom(Node head) {
        while (head != null) {
            if (head.random != null) {
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
    }

    private Node getRandomList(Node head) {
        Node dummyHead = new Node(-1), temp = dummyHead;
        while (head != null) {
            Node newNode = head.next;
            head.next = newNode.next;
            head = head.next;
            temp.next = newNode;
            temp = temp.next;
        }
        return dummyHead.next;
    }

    /**
     * Definition for a Node.
     */
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
