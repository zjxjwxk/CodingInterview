package com.zjxjwxk.codinginterview._29_SpiralOrder;

/**
 * 剑指 Offer 29. 顺时针打印矩阵
 *
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 *
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * 限制：
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 *
 * @author zjxjwxk
 * @date 2020/9/26 10:23 下午
 */
public class Solution {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return new int[]{};
        }
        int[] spiral = new int[matrix.length * matrix[0].length];
        int row1 = 0, row2 = matrix.length - 1, col1 = 0, col2 = matrix[0].length - 1, index = 0, count = 0;
        while (row1 <= row2 && col1 <= col2) {
            for (int x = col1; x <= col2; ++x) {
                spiral[index++] = matrix[row1][x];
            }
            for (int y = row1 + 1; y <= row2; ++y) {
                spiral[index++] = matrix[y][col2];
            }
            for (int x = col2 - 1; x >= col1 && row1 != row2; --x) {
                spiral[index++] = matrix[row2][x];
            }
            for (int y = row2 - 1; y >= row1 + 1 && col1 != col2; --y) {
                spiral[index++] = matrix[y][col1];
            }
            ++row1;
            --row2;
            ++col1;
            --col2;
        }
        return spiral;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9,10,11,12}
        };
        int[] spiral = solution.spiralOrder(matrix);
        for (int j : spiral) {
            System.out.print(j + " ");
        }
    }
}
