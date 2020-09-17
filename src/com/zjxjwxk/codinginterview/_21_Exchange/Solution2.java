package com.zjxjwxk.codinginterview._21_Exchange;

/**
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 *
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 * 示例：
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *
 * 提示：
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10000
 *
 * 可扩展的解法
 *
 * @author Xinkang Wu
 * @date 2020/9/16 11:24 下午
 */
public class Solution2 {

    public int[] exchange(int[] nums, FuncInterface funcInterface) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            while (!funcInterface.func(nums[i]) && i < j) {
                ++i;
            }
            while (funcInterface.func(nums[j]) && i < j) {
                --j;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }

    private interface FuncInterface {
        boolean func(int num);
    }

    private static class IsEvent implements FuncInterface {
        @Override
        public boolean func(int num) {
            return (num & 1) == 0;
        }
    }

    private static class IsPositive implements FuncInterface {
        @Override
        public boolean func(int num) {
            return num > 0;
        }
    }

    public void printArr(int[] arr) {
        for (int num : arr) {
            System.out.println(num);
        }
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] nums = new int[]{1, 2, 3, 4};
        // 奇数出现在偶数前
        solution.exchange(nums, new IsEvent());
        solution.printArr(nums);
        nums = new int[]{1, -2, 3, -4};
        // 负数出现在正数前
        solution.exchange(nums, new IsPositive());
        solution.printArr(nums);
    }
}
