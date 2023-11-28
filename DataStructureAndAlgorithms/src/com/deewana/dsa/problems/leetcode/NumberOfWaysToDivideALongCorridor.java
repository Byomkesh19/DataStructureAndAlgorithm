package com.deewana.dsa.problems.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NumberOfWaysToDivideALongCorridor {
	class Solution {
	    public int numberOfWays(String corridor) {
	        int scnt=0;
	        List<Integer> ulist=new ArrayList<>();
	        List<Integer> vlist=new ArrayList<>();
	        int currCnt=0;
	        int corridorLength=corridor.length();
	        for(int i=0;i<corridorLength;i++){
	            char ch=corridor.charAt(i);
	            if(ch=='S'){
	                scnt++;
	                if(currCnt==0){
	                    ulist.add(i);
	                    currCnt++;
	                }
	                else if(currCnt==1){
	                    vlist.add(i);
	                    currCnt=0;
	                }
	            }
	        }
	        if(scnt%2==1 || scnt==0){
	            return 0;
	        }
	        int ans=1;
	        int n=ulist.size();
	        int lastV=ulist.get(0)-1;
	        for(int i=0;i<n;i++){
	            int u=ulist.get(i);
	            int v=vlist.get(i);
	            int cnt=u-lastV;
	            ans=(int)(((long)((long)ans*(long)cnt))%1000000007);
	            lastV=v;
	        }
	        return ans;
	    }
	}
}
