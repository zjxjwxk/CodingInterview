package com.zjxjwxk.codinginterview._30_MinStack;

/**
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
