package com.zjxjwxk.codinginterview._24_ReverseList;

/**
 * 剑指 Offer 24. 反转链表
 *
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后
 * 链表的头节点。
 *
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * 限制：
 * 0 <= 节点个数 <= 5000
 *
 * @author Xinkang Wu
 * @date 2020/9/20 9:09 下午
 */
public class Solution {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = head;
        if (pre.next == null) {
            return pre;
        }
        ListNode cur = pre.next, next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            if (pre == head) {
                pre.next = null;
            }
            pre = cur;
            cur = next;
        }
        return pre;
    }

    private void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) {
                System.out.print("->");
            }
            head = head.next;
        }
        System.out.println();
    }

    private ListNode createLinkedList(int num) {
        ListNode head = new ListNode(0), temp = head;
        for (int i = 1; i <= num; ++i) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = solution.createLinkedList(5);
        solution.printLinkedList(head);
        head = solution.reverseList(head);
        solution.printLinkedList(head);
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
