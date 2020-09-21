package com.zjxjwxk.codinginterview._25_MergeTwoLists;

/**
 * 剑指 Offer 25. 合并两个排序的链表
 *
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 限制：
 * 0 <= 链表长度 <= 1000
 *
 * 迭代法
 *
 * @author Xinkang Wu
 * @date 2020/9/21 11:28 下午
 */
public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head, p1 = l1, p2 = l2, temp;
        if (p1.val <= p2.val) {
            head = p1;
            p1 = p1.next;
        } else {
            head = p2;
            p2 = p2.next;
        }
        temp = head;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                temp.next = p1;
                p1 = p1.next;
            } else {
                temp.next = p2;
                p2 = p2.next;
            }
            temp = temp.next;
        }
        if (p1 != null) {
            temp.next = p1;
        }
        if (p2 != null) {
            temp.next = p2;
        }
        return head;
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

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);
        l1.next.next.next = new ListNode(7);
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);
        l2.next.next.next = new ListNode(8);
        ListNode head = solution.mergeTwoLists(l1, l2);
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
