package com.amazon;

import java.util.LinkedList;
import java.util.List;

public class CountPossibleSegments {

    public int getCountOfPossbleSegment(int[] weights,int k){
        int result = 0;

        List<List<Integer>> seqSubsets = seqSubsets(weights);
        System.out.println("seqSubsets:"+seqSubsets);

        return result;
    }

    private List<List<Integer>> seqSubsets(int[] nums){
        List<List<Integer>> result = new LinkedList<>();

        if (nums.length == 0)
            return result;

        helper(nums, 0, new LinkedList<Integer>(), result);

        return result;
    }

    private void helper(int[] nums, int index, LinkedList<Integer> subset, List<List<Integer>> result) {
        if (index == nums.length){
            result.add(new LinkedList<>(subset));
        }
        else if(index < nums.length){
            helper(nums,index + 1,subset,result);
            subset.add(nums[index]);
            helper(nums,index + 1,subset,result);
            subset.removeLast();
        }
    }

    public static void main(String[] args) {
        CountPossibleSegments possibleSegments = new CountPossibleSegments();
        int[] weights = {1,3,6};
        int k = 3;
        possibleSegments.getCountOfPossbleSegment(weights,k);
    }
}
