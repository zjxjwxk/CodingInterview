package com.zjxjwxk.codinginterview._06_reversePrint;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 *
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 * 限制：
 * 0 <= 链表长度 <= 10000
 *
 * @author zjxjwxk
 * @date 2020/7/21 9:43 下午
 */

import java.util.Stack;

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public static int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[]{};
        }
        ListNode node = head;
        int count = 0;
        while (node != null) {
            ++count;
            node = node.next;
        }
        int[] arr = new int[count];
        node = head;
        for (int i = count - 1; i >= 0; --i) {
            arr[i] = node.val;
            node = node.next;
        }
        return arr;
    }
}
