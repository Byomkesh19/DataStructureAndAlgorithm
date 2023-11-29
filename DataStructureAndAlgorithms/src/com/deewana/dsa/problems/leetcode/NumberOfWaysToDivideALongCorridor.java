package com.deewana.dsa.problems.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NumberOfWaysToDivideALongCorridor {
	class Solution {
	    public int numberOfWays(String corridor) {
	        int scnt=0;
	        int currCnt=0;
	        int lastV=corridor.indexOf('S')-1;
	        int corridorLength=corridor.length();
	        int ans=1;
	        for(int i=0;i<corridorLength;i++){
	            char ch=corridor.charAt(i);
	            if(ch=='S'){
	                scnt++;
	                if(currCnt==0){
	                    int cnt=i-lastV;
	                    ans=(int)(((long)((long)ans*(long)cnt))%1000000007);
	                    currCnt++;
	                }
	                else if(currCnt==1){
	                    lastV=i;
	                    currCnt=0;
	                }
	            }
	        }
	        if(scnt%2==1 || scnt==0){
	            return 0;
	        }
	        return ans;
	    }
	}
}
