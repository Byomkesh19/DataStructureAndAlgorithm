package com.deewana.dsa.problems.leetcode;

import java.util.Arrays;

public class MaxNumberOfCoinsYouCanGet {
	class Solution {
	    public int maxCoins(int[] piles) {
	        Arrays.sort(piles);
	        int n=piles.length;
	        int i2=n-1;
	        int nby3=n/3;
	        int ans=0;
	        while(i2>=nby3){
	            ans+=piles[i2-1];
	            i2-=2;
	        }
	        return ans;
	    }
	}
}
