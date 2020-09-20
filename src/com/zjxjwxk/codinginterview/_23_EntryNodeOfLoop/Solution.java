package com.zjxjwxk.codinginterview._23_EntryNodeOfLoop;

/**
 * @author Xinkang Wu
 * @date 2020/9/20 9:20 下午
 */
public class Solution {

    public ListNode entryNodeOfLoop(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode meeting = meetingNode(head);
        if (meeting == null) {
            return null;
        }
        int count = 1;
        ListNode temp = meeting.next;
        while (temp != meeting) {
            ++count;
            temp = temp.next;
        }
        ListNode ahead = head, behind = head;
        while (count != 0) {
            ahead = ahead.next;
            --count;
        }
        while (ahead != behind) {
            ahead = ahead.next;
            behind = behind.next;
        }
        return ahead;
    }

    private ListNode meetingNode(ListNode head) {
        ListNode ahead = head, behind = head;
        while (ahead.next != null && ahead.next.next != null) {
            ahead = ahead.next.next;
            behind = behind.next;
            if (ahead == behind) {
                return ahead;
            }
        }
        return null;
    }

    private ListNode createLoopLinkedList(int num) {
        ListNode head = new ListNode(1), temp = head, entry = null;
        for (int i = 1; i <= 6; ++i) {
            temp.next = new ListNode(i);
            temp = temp.next;
            if (i == 3) {
                entry = temp;
            }
        }
        temp.next = entry;
        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = solution.createLoopLinkedList(6);
        ListNode entry = solution.entryNodeOfLoop(head);
        System.out.println(entry.val);
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
