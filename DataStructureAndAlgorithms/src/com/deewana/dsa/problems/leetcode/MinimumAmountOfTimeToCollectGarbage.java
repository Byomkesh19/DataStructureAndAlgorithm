package com.deewana.dsa.problems.leetcode;

public class MinimumAmountOfTimeToCollectGarbage {
	class Solution {
	    public int garbageCollection(String[] garbage, int[] travel) {
	        int lastIndexM=0,lastIndexP=0,lastIndexG=0,sum=0,time=0;
	        int t=travel.length;
	        int prefixTravel[]=new int[t+1];
	        for(int i=0;i<garbage.length;i++){
	            prefixTravel[i]=sum;
	            if(i<t){
	                sum+=travel[i];
	            }
	            String str=garbage[i];
	            int l=str.length();
	            time+=l;
	            for(int j=0;j<l;j++){
	                char ch=str.charAt(j);
	                if(ch=='M'){
	                    lastIndexM=i;
	                }
	                else if(ch=='P'){
	                    lastIndexP=i;
	                }
	                else{
	                    lastIndexG=i;
	                }
	            }
	        }
	        return time+prefixTravel[lastIndexM]+prefixTravel[lastIndexP]+prefixTravel[lastIndexG];
	    }
	}
}
