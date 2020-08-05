package com.zjxjwxk.codinginterview._13_MovingCount;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 13. 机器人的运动范围
 *
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 * 示例 1：
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 *
 * 示例 2：
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 *
 * 提示：
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 *
 * @author zjxjwxk
 * @date 2020/8/5 11:01 下午
 */
public class Solution {

    private static int count = 0;

    public static int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            Integer index = queue.poll();
            int i = index / 100, j = index % 100;
            if (i >= 0 && i < m && j >= 0 && j < n && !visited[i][j]) {
                visited[i][j] = true;
                if ((getSum(i) + getSum(j)) <= k) {
                    ++count;
                    queue.add((i + 1) * 100 + j);
                    queue.add(i * 100 + (j + 1));
                    queue.add((i - 1) * 100 + j);
                    queue.add(i * 100 + (j - 1));
                }
            }
        }
        return count;
    }

    public static int getSum(int i) {
        int sum = 0;
        while (i != 0) {
            sum += i % 10;
            i /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(movingCount(1, 3, 11));
    }
}
