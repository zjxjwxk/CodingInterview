package com.zjxjwxk.codinginterview._22_GetKthFromEnd;

/**
 * 剑指 Offer 22. 链表中倒数第k个节点
 *
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，
 * 本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有
 * 6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表
 * 的倒数第3个节点是值为4的节点。
 *
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * 返回链表 4->5.
 *
 * @author Xinkang Wu
 * @date 2020/9/19 8:57 下午
 */
public class Solution {

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        ListNode aheadNode = head;
        int i;
        for (i = 0; i < (k - 1) && aheadNode.next != null; ++i) {
            aheadNode = aheadNode.next;
        }
        if (i != k - 1) {
            return null;
        }
        ListNode behindNode = head;
        while (aheadNode.next != null) {
            aheadNode = aheadNode.next;
            behindNode = behindNode.next;
        }
        return behindNode;
    }

    private void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) {
                System.out.print("->");
            }
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1), temp = head;
        for (int i = 1; i <= 5; ++i) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        temp.next = null;
        solution.printLinkedList(solution.getKthFromEnd(head, 2));
    }

    /**
     * Definition for singly-linked list.
     */
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
