package com.deewana.dsa.problems.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class DiagonalTraverse2 {
	class Solution {
	    public int[] findDiagonalOrder(List<List<Integer>> nums) {
	        TreeMap<Integer,TreeSet<Integer>> sumYMap=new TreeMap<>();
	        for(int i=0;i<nums.size();i++){
	            for(int j=0;j<nums.get(i).size();j++){
	                int sum=i+j;
	                if(sumYMap.containsKey(sum)){
	                    sumYMap.get(sum).add(j);
	                }
	                else{
	                    TreeSet<Integer> iset=new TreeSet<>();
	                    iset.add(j);
	                    sumYMap.put(sum,iset);
	                }
	            }
	        }
	        List<Integer> ansList=new ArrayList<>();
	        for(Integer i:sumYMap.keySet()){
	            for(Integer y:sumYMap.get(i)){
	                int x=i-y;
	                ansList.add(nums.get(x).get(y));
	            }
	        }
	        int ans[]=new int[ansList.size()];
	        for(int i=0;i<ansList.size();i++){
	            ans[i]=ansList.get(i);
	        }
	        return ans;
	    }
	}
}
