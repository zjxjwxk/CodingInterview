package com.zjxjwxk.codinginterview._09_CQueue;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 *
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数
 * appendTail 和 deleteHead ，分别完成在队列尾部插入整数
 * 和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 
 * 操作返回 -1 )
 *
 * 示例 1：
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 *
 * 示例 2：
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 *
 * 提示：
 * 1 <= values <= 10000
 * 最多会对 appendTail、deleteHead 进行 10000 次调用
 *
 * @author zjxjwxk
 * @date 2020/7/23 8:22 下午
 */
public class Solution {
    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        System.out.println(cQueue.deleteHead());
        cQueue.appendTail(5);
        cQueue.appendTail(2);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
    }
}

class CQueue {
    int[] head;
    int[] tail;
    int headTop;
    int tailTop;

    public CQueue() {
        head = new int[10000];
        tail = new int[10000];
        headTop = -1;
        tailTop = -1;
    }

    public void appendTail(int value) {
        tail[++tailTop] = value;
    }

    public int deleteHead() {
        if (headTop == -1) {
            while (tailTop != -1) {
                head[++headTop] = tail[tailTop--];
            }
        }
        if (headTop == -1) {
            return -1;
        }
        return head[headTop--];
    }
}
