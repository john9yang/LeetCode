package com.jhclass.leetcode.containerwithmostwater;

public class Solution {

    public int maxArea(int[] height) {

        // 参数校验
        if (height == null || height.length < 2) {
            return 0;
        }

        // 记录最大的结果
        int result = 0;

        // 左边的竖线
        int left = 0;
        // 右边的竖线
        int right = height.length - 1;

        while (left < right) {
            // 设算当前的最大值
            result = Math.max(result, Math.min(height[left], height[right]) * (right - left));
            // 如果右边线高
            if (height[left] < height[right]) {
                int k = left;
                // 从[left, right - 1]中，从左向右找，找第一个高度比height[left]高的位置
                while (k < right && height[k] <= height[left]) {
                    k++;
                }

                // 从[left, right - 1]中，记录第一个比原来height[left]高的位置
                left = k;
            }
            // 左边的线高
            else {
                int k = right;
                // 从[left + 1, right]中，从右向左找，找第一个高度比height[right]高的位置
                while (k > left && height[k] <= height[right]) {
                    k--;
                }

                // 从[left, right - 1]中，记录第一个比原来height[right]高的位置
                right = k;
            }
        }

        return result;
    }
}