package com.jhclass.leetcode;

public class UniquePathObstacles {

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
//        System.out.println(new UniquePathObstacles().uniquePathsObstacles(grid));
        System.out.println(new UniquePathObstacles().uniquePathsWithObstacles2(grid));
    }

    public int uniquePathsObstacles(int[][] obstacleGrid){
        if ( obstacleGrid == null || obstacleGrid.length < 1 || obstacleGrid[0].length < 1
             || obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1]==1){
            return 0;
        }

        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        int[][] result = new int[rows][cols];

        //第一个位置有多少条路径，无障碍就是1条，有障碍就是0条
        result[0][0] = obstacleGrid[0][0]== 0 ? 1:0;

        for( int i = 1; i< cols;i++ ){
            result[0][i] = obstacleGrid[0][i] == 0 ? result[0][i-1] : 0;
        }

        for( int j = 1; j< rows;j++ ){
            result[j][0] = obstacleGrid[j][0] == 0 ? result[j-1][0] : 0;
        }

        for( int i=1;i<rows;i++ )
            for( int j=1;j<cols;j++ ){
                result[i][j] = obstacleGrid[i][j] == 0 ? result[i-1][j]+result[i][j-1] : 0;
            }

        return result[rows-1][cols-1];
    }

    // 使用递归方法会超时
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        // 输入校验
        if (obstacleGrid == null || obstacleGrid.length < 1 || obstacleGrid[0].length < 1
            || obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) {
            return 0;
        }
        int[] result = {0};
        solve(obstacleGrid, 0, 0, result);
        return result[0];
    }

    public void solve(int[][] grid, int row, int col, int[] sum) {
        // 到达终点
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            sum[0]++;
        }
        // 没有到终点，点在棋盘内，并且当前位置不是
        else if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == 0) {
            // 往右走
            solve(grid, row, col + 1, sum);
            // 往下走
            solve(grid, row + 1, col, sum);
        }
    }

}