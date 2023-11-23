package com.deewana.dsa.problems.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArithmeticSubarrays {
	class Solution {
	    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
	        List<Boolean> ans=new ArrayList<>();
	        for(int i=0;i<l.length;i++){
	            int u=l[i];
	            int v=r[i];
	            int ln=v-u+1;
	            int arr[]=new int[ln];
	            int cnt=0;
	            for(int j=u;j<=v;j++){
	                arr[cnt]=nums[j];
	                cnt++;
	            }
	            Arrays.sort(arr);
	            int diff=arr[1]-arr[0];
	            boolean flag=true;
	            for(int j=2;j<ln;j++){
	                int currDiff=arr[j]-arr[j-1];
	                if(diff!=currDiff){
	                    flag=false;
	                    break;
	                }
	            }
	            ans.add(flag);
	        }
	        return ans;
	    }
	}
}
