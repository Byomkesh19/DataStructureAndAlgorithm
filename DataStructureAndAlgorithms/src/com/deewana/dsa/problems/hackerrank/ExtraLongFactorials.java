package com.deewana.dsa.problems.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class ExtraLongFactorials {
	class Result {

	    /*
	     * Complete the 'extraLongFactorials' function below.
	     *
	     * The function accepts INTEGER n as parameter.
	     */

	    public static void extraLongFactorials(int n) {
	    // Write your code here
	    BigInteger bi=new BigInteger("1");//Similar to int product=1;
	    for(int i=1;i<=n;i++){
	        BigInteger bit=new BigInteger(String.valueOf(i));
	        bi=bi.multiply(bit);//Similar to product=product*i;
	    }
	    System.out.println(bi.toString());//at the end we will get the factorial

	    }

	}

	    public static void main(String[] args) throws IOException {
	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	        int n = Integer.parseInt(bufferedReader.readLine().trim());

	        Result.extraLongFactorials(n);

	        bufferedReader.close();
	    }
}
