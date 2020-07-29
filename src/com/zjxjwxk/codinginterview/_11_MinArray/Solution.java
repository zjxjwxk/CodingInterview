package com.zjxjwxk.codinginterview._11_MinArray;

/**
 * 剑指 Offer 11. 旋转数组的最小数字
 *
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 *
 * 示例 1：
 * 输入：[3,4,5,1,2]
 * 输出：1
 *
 * 示例 2：
 * 输入：[2,2,2,0,1]
 * 输出：0
 *
 * @author zjxjwxk
 * @date 2020/7/29 11:43 下午
 */
public class Solution {
    public static int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return -1;
        }
        int left = 0, right = numbers.length - 1, mid = left;
        while (numbers[left] >= numbers[right]) {
            if (right - left == 1) {
                mid = right;
                break;
            }
            mid = left + ((right - left) >> 1);
            if (numbers[left] == numbers[right] && numbers[mid] == numbers[left]) {
                return minInOrder(numbers, left, right);
            }
            if (numbers[mid] >= numbers[left]) {
                left = mid;
            } else if (numbers[mid] <= numbers[right]) {
                right = mid;
            }
        }
        return numbers[mid];
    }

    public static int minInOrder(int[] numbers, int left, int right) {
        int min = numbers[left];
        for (int i = left + 1; i <= right; ++i) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(minArray(new int[]{1, 0, 1, 1, 1}));
        System.out.println(minArray(new int[]{1, 1, 1, 0, 1}));
    }
}
