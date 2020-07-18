package com.zjxjwxk.codinginterview._03_FindRepeatNumber;

/**
 * 剑指 Offer 03. 数组中重复的数字
 *
 * 题目一：找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个
 * 数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * @author zjxjwxk
 * @date 2020/7/18 7:57 下午
 */
public class Solution {
    public static int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            while (i != nums[i]) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                int temp = nums[i];
                nums[i] = nums[nums[i]];
                nums[temp] = temp;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }
}
