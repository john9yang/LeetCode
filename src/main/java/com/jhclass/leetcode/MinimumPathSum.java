package com.jhclass.leetcode;

public class MinimumPathSum {

    public static void main(String[] args) {
        MinimumPathSum minimumPathSum = new MinimumPathSum();
//        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};//7
        int[][] grid = new int[][]{{1, 2}, {3, 4}};//7
//        int[][] grid = new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}};//21
//        int[][] grid = new int[][]{{1}};//1
//        int[][] grid = new int[][]{{1, 2, 5}, {3, 2, 1}};//7
        //System.out.println(minPath(grid,3,3));
        System.out.println(minPathSum2(grid));
    }

    public static int minPath(int[][] arr,int n,int m){
        if(arr == null)
            return 0;

        int[][] dp = new int[n][m];
        dp[0][0] = arr[0][0];
        for(int i = 1; i < n;i++){
            dp[i][0] = dp[i - 1][0] + arr[i][0];
        }
        for(int i = 1; i < m; i++){
            dp[0][i] = dp[0][i - 1] + arr[0][i];
        }
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + arr[i][j];
            }
        }
        return dp[n - 1][m - 1];
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // 动态归划和分枝限界，下面的方法会超时
    ////////////////////////////////////////////////////////////////////////////////////////////////
    public static int minPathSum2(int[][] grid) {
        // 参数检验
        if (grid == null || grid.length < 1 || grid[0].length < 1) {
            return 0;
        }

        // 用于记录最小的路径各
        int[] minSum = {Integer.MAX_VALUE};
        int[] curSum = {0};
        // 解题
        solve(grid, 0, 0, curSum, minSum);

        // 返回结果
        return minSum[0];
    }

    public static void solve(int[][] grid, int row, int col, int[] curSum, int[] minSum) {
        // 如果已经到达终点
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            curSum[0] += grid[row][col];

            // 更新最小的和
            if (curSum[0] < minSum[0]) {
                minSum[0] = curSum[0];
            }

            //curSum[0] -= grid[row][col];
        }
        // 还未到达终点，并且在网格内
        else if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length) {
            curSum[0] += grid[row][col];
            // 当前的和只有不小于记录到的最小路径值才能进行下一步操作
            if (curSum[0] <= minSum[0]) {
                // 向右走
                solve(grid, row, col + 1, curSum, minSum);
                // 向下走
                solve(grid, row + 1, col, curSum, minSum);
            }
            //curSum[0] -= grid[row][col];
        }
    }
}