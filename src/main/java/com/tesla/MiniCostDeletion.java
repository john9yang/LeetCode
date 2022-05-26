package com.tesla;

public class MiniCostDeletion {

    public MiniCostDeletion(){

    }

    public int solution(String s, int[] c){
        int mincost = 0;
        int len = s.length();

        for(int i = 1; i < s.length(); i++){
            if (s.charAt(i) == s.charAt(i-1)){
                if (c[i-1] < c[i]){
                    mincost += c[i-1];
                }
                else{
                    mincost += c[i];
                    c[i] = c[i-1];
                }
            }
        }

        return mincost;
    }
}
