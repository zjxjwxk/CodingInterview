package com.zjxjwxk.codinginterview._18_DeleteNode;

/**
 * 删除链表中重复的节点
 *
 * @author Xinkang Wu
 * @date 2020/9/11 7:30 下午
 */
public class Solution2 {

    /**
     * Definition for singly-linked list.
     */
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode deleteDupNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode preNode = null;
        ListNode node = head;
        while (node != null) {
            ListNode nextNode = node.next;
            boolean ifNeedDelete = false;
            if (nextNode != null && node.val == nextNode.val) {
                ifNeedDelete = true;
            }
            if (!ifNeedDelete) {
                preNode = node;
                node = node.next;
            } else {
                int dupVal = node.val;
                ListNode toBeDel = node;
                while (toBeDel != null && toBeDel.val == dupVal) {
                    nextNode = toBeDel.next;
                    toBeDel.next = null;
                    toBeDel = nextNode;
                }
                if (preNode == null) {
                    head = nextNode;
                } else {
                    preNode.next = nextNode;
                }
                node = nextNode;
            }
        }
        return head;
    }

    public void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) {
                System.out.print("->");
            }
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        head = solution2.deleteDupNode(head);
        solution2.printList(head);
    }
}
