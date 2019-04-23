package com.jhclass.leetcode;

public class MinimumPathSum {

    public static void main(String[] args) {
        MinimumPathSum minimumPathSum = new MinimumPathSum();
        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};//7
//        int[][] grid = new int[][]{{1, 2}, {3, 4}};//7
//        int[][] grid = new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}};//21
//        int[][] grid = new int[][]{{1}};//1
//        int[][] grid = new int[][]{{1, 2, 5}, {3, 2, 1}};//7
        System.out.println(minPath(grid,3,3));
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

}