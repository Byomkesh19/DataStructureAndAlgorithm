package com.deewana.dsa.problems.hackerrank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Encryption {

	public class Result {
		/*
		 * Complete the 'encryption' function below.
		 *
		 * The function is expected to return a STRING. The function accepts STRING s as
		 * parameter.
		 */

		/*
		 * Steps: 
		 * 1. Remove all the spaces of the string and store the length 
		 * 2. calculate srqt(lenght) find floor and ceil 
		 * 3. create a grid with floorXceil rows and columns 
		 * 4. insert one character in each cell of the grid 
		 * 5. form the word of one column at a time and add a space with the next column word
		 */
		public static String encryption(String s) {
			// Write your code here
			s = s.replaceAll(" ", "");
			int l = s.length();
			double sqrtL = Math.sqrt(l);
			int ceilSqrtL = (int) Math.ceil(sqrtL);
			String eString = "";
			for (int i = 0; i < ceilSqrtL; i++) {
				for (int j = i; j < l; j += ceilSqrtL) {
					eString += s.charAt(j);
				}
				eString += " ";
			}

			return eString;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String s = bufferedReader.readLine();

		String result = Result.encryption(s);

		bufferedWriter.write(result);
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
