package com.zjxjwxk.codinginterview._12_Exist;

/**
 * 剑指 Offer 12. 矩阵中的路径
 *
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串
 * 所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在
 * 矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一
 * 格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中
 * 包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 *
 * [["a","_b_","c","e"],
 * ["s","_f_","_c_","s"],
 * ["a","d","_e_","e"]]
 *
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据
 * 了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 *
 * 示例 1：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 *
 * 示例 2：
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 *
 * 提示：
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 *
 * @author zjxjwxk
 * @date 2020/8/4 11:51 下午
 */
public class Solution {

    private static int index = 0;

    public static boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        int row = board.length, col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (existDFS(board, row, col, i, j, word, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean existDFS(char[][] board, int row, int col, int i, int j, String word, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        boolean exist = false;
        if (i >= 0 && i < row && j >= 0 && j < col && !visited[i][j] && board[i][j] == word.charAt(index)) {
            ++index;
            visited[i][j] = true;
            exist = existDFS(board, row, col, i + 1, j, word, visited)
                    || existDFS(board, row, col, i, j + 1, word, visited)
                    || existDFS(board, row, col, i - 1, j, word, visited)
                    || existDFS(board, row, col, i, j - 1, word, visited);
            if (!exist) {
                --index;
                visited[i][j] = false;
            }
        }
        return exist;
    }

    public static void main(String[] args) {
        char[][] board = new char[][] {
            {'a','b','c','e'},
            {'s','f','c','s'},
            {'a','d','e','e'}
        };
        System.out.println(exist(board, "bfce"));
    }
}
