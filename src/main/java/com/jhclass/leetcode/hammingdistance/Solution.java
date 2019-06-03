package com.jhclass.leetcode.hammingdistance;

public class Solution {

    public static void main(String[] args) {

    }

    int hammingDistance(int x,int y){
        int i = x ^ y;
        int count = 0;

        while( i != 0 ){
            count++;
            i = (i-1) & i;
        }

        return  count;
    }
}