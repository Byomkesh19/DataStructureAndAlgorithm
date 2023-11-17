package com.deewana.dsa.problems.leetcode;

import java.util.Arrays;

public class MinimizeMaximumPairSumInArray {
	class Solution {
	    public int minPairSum(int[] nums) {
	        Arrays.sort(nums);
	        int n=nums.length;
	        int i=0;
	        int maxSum=2;
	        while(i<n/2){
	            int sum=nums[i]+nums[n-i-1];
	            if(sum>maxSum){
	                maxSum=sum;
	            }
	            i++;
	        }
	        return maxSum;
	    }
	}
}
