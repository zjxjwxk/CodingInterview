package com.zjxjwxk.codinginterview._03_FindRepeatNumber;

/**
 * 剑指 Offer 03. 数组中重复的数字
 *
 * 题目二：不修改数组找出重复的数字。
 * 在一个长度为 n+1 的数组里的所有数字都在 1～n 的范围内，所以数
 * 组中至少有一个数字是重复的。请找出数组中任意一个重复的数字，但
 * 不能修改输入的数组。例如，如果输入长度为 8 的数组 {2, 3, 5,
 * 4, 3, 2, 6, 7}，那么对应的输出是重复的数字 2 或者 3。
 *
 * @author zjxjwxk
 * @date 2020/7/18 9:39 下午
 */
public class Solution2 {
    public static int findRepeatNumber(int[] nums) {
        int left = 1, right = nums.length - 1, mid, count;
        while (left < right) {
            mid = ((right - left) >> 1) + left;
            count = countNumber(nums, left, mid);
            if (count > mid - left + 1) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static int countNumber(int[] nums, int left, int right) {
        int count = 0;
        for (int num : nums) {
            if (num >= left && num <= right) {
                ++count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(findRepeatNumber(new int[]{2, 3, 5, 4, 3, 2, 6, 7}));
    }
}
