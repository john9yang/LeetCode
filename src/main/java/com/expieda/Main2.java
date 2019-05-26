package com.expieda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Main2 {
    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        int n = 0;
        int lineNumber = 0;
        int[][] inputArr = null;
        while ((line = in.readLine()) != null) {
            if ( lineNumber == 0 ){
                n = Integer.parseInt(line);
                inputArr = new int[n][n];
            }
            else{
                int row = lineNumber-1;
                String[] data = line.split(",");
                 for( int j=0;j<n;j++ ){
                     inputArr[row][j] = Integer.parseInt(data[j]);
                 }
            }



            if ( (lineNumber++) == n )
                break;
        }

        System.out.println(minPath(inputArr,n));
    }

    public static int minPath(int[][] arr,int n){
        if(arr == null)
            return 0;

        int[][] dp = new int[n][n];
        dp[0][0] = arr[0][0];
        for(int i = 1; i < n;i++){
            dp[i][0] = dp[i - 1][0] + arr[i][0];
        }
        for(int i = 1; i < n; i++){
            dp[0][i] = dp[0][i - 1] + arr[0][i];
        }
        for(int i = 1; i < n; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + arr[i][j];
            }
        }
        return dp[n - 1][n - 1];
    }
}
