package com.zjxjwxk.codinginterview._30_MinStack;

/**
 * 剑指 Offer 30. 包含min函数的栈
 *
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min
 * 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 * 示例:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 *
 * 提示：
 * 各函数的调用总次数不超过 20000 次
 *
 * @author zjxjwxk
 * @date 2020/9/28 8:19 下午
 */
public class MinStack {

    int[] stack, min;
    int index = -1;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new int[20000];
        min = new int[20000];
    }

    public void push(int x) {
        if (index == -1 || x < min[index]) {
            min[index + 1] = x;
        } else {
            min[index + 1] = min[index];
        }
        stack[++index] = x;
    }

    public void pop() {
        --index;
    }

    public int top() {
        return stack[index];
    }

    public int min() {
        return min[index];
    }
}
