package com.jhclass.leetcode;

public class MinimumPathSum {

    public static void main(String[] args) {
        MinimumPathSum lertCode_64_minimumPathSum = new MinimumPathSum();
        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};//7
//        int[][] grid = new int[][]{{1, 2}, {3, 4}};//7
//        int[][] grid = new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}};//21
//        int[][] grid = new int[][]{{1}};//1
//        int[][] grid = new int[][]{{1, 2, 5}, {3, 2, 1}};//7
        System.out.println(lertCode_64_minimumPathSum.minPathSum(grid));
    }

    public int minPathSum(int[][] grid) {
        int rows = grid.length;//行数
        int columns = grid[0].length;//列数

        int r, c;

        //先向右移动
        for (r = 0, c = 1; c < columns; c++) {
            topRight2BottomLeft(grid, r, c);
        }

        r++;//从最右上角的下面的那个元素即是向下遍历的起始处
        c--;//前面最后有c++所以需要再减回来

        //先向下移动
        for (; r < rows; r++) {
            topRight2BottomLeft(grid, r, c);
        }
        return grid[rows - 1][columns - 1];
    }

    //斜对角线计算
    public void topRight2BottomLeft(int[][] grid, int r, int c) {
        while (c >= 0 && r < grid.length) {//元素到此次最左边的元素时不能再往左下角遍历。到最右下角的元素时，停止计算，此时r++后会大于columns-1。
            if (r - 1 < 0) {//第一行 特殊处理
                grid[r][c] = grid[r][c] + grid[r][c - 1];
            } else if (c - 1 < 0) {//第一列 特殊处理
                grid[r][c] = grid[r][c] + grid[r - 1][c];
            } else {
                grid[r][c] = Math.min(grid[r][c] + grid[r][c - 1], grid[r][c] + grid[r - 1][c]);
            }
            r++;
            c--;
        }
    }
}