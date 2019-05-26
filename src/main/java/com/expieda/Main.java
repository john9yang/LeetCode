package com.expieda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Main {
    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        while ((line = in.readLine()) != null) {
            System.out.println(line);
            String prePart = line.split(";")[0];
            String data = line.split(";")[1];

            int rows = Integer.parseInt(prePart.split(",")[0]);
            int cols = Integer.parseInt(prePart.split(",")[1]);
            char[][] inputArr = new char[rows][cols];
            char[][] outputArr = new char[rows][cols];

            //initial inputArr
            for( int i=0;i<rows;i++ )
                for( int j=0;j<cols;j++ ){
                    inputArr[i][j] = data.charAt(i*cols+j);
                }

            //scan inputAtrr
            for( int i=0;i<rows;i++ )
                for( int j=0;j<cols;j++ ){
                    if (inputArr[i][j] == '*'){
                        outputArr[i][j] = '*';
                    }
                    else{
                        int count=0;
                        //up
                        if ( (i-1) >=0 && ( inputArr[i-1][j] == '*' ) ){
                            count++;
                        }
                        //right up
                        if ( (i-1)>=0 && (j+1)< cols && (inputArr[i-1][j+1]=='*') ){
                            count++;
                        }
                        //right
                        if ( (j+1)<cols && ( inputArr[i][j+1]=='*' ) ){
                            count++;
                        }
                        //right down
                        if ( (j+1)<cols && (i+1)<rows && (inputArr[i+1][j+1]=='*') ){
                           count++;
                        }
                        //down
                        if ( (i+1)<rows && inputArr[i+1][j]=='*' ){
                            count++;
                        }
                        //left down
                        if ( (j-1)>=0 && (i+1)<rows && inputArr[i+1][j-1]=='*' ){
                            count++;
                        }
                        //left
                        if ( (j-1)>=0 && inputArr[i][j-1]=='*' ){
                            count++;
                        }
                        //left up
                        if ( (i-1)>=0 && (j-1)>=0  && (inputArr[i-1][j-1]=='*')){
                            count++;
                        }

                        outputArr[i][j] = String.valueOf(count).charAt(0);
                    }
                }

            for( int i=0;i<rows;i++ )
                for( int j=0;j<cols;j++ ){
                    System.out.print(outputArr[i][j]);
                }
        }
    }
}