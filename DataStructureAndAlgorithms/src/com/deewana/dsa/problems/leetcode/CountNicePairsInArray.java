package com.deewana.dsa.problems.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CountNicePairsInArray {
	class Solution {
	    private static int reverse(int val){
	        int ans=0;
	        while(val>0){
	            int r=val%10;
	            ans=ans*10+r;
	            val=val/10;
	        }
	        return ans;
	    }
	    public int countNicePairs(int[] nums) {
	        int n=nums.length;
	        Map<Integer,Integer> fmap=new HashMap<>();
	        for(int i=0;i<n;i++){
	           int diff=nums[i]-reverse(nums[i]);
	           if(fmap.containsKey(diff)){
	               fmap.replace(diff,fmap.get(diff)+1);
	           }
	           else{
	               fmap.put(diff,1);
	           }
	        }
	        int sum=0;
	        for(Integer i:fmap.keySet()){
	            long val=(long)fmap.get(i);
	            sum=(int)(((long)sum+(((val*(val-1l))/2l)%1000000007l))%1000000007l);
	        }
	        return sum;
	    }
	}
}
