package com.deewana.dsa.problems.hackerrank;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;



public class NonDivisbleSubset {
	class Result {

	    /*
	     * Complete the 'nonDivisibleSubset' function below.
	     *
	     * The function is expected to return an INTEGER.
	     * The function accepts following parameters:
	     *  1. INTEGER k
	     *  2. INTEGER_ARRAY s
	     */
	    
	    /*
	    Step 1: Generate the moduloListMap
	    The map signifies that for a modulo m where 0<=m<k what are the values satisfying the condition a%k=m;
	    Step 2: Using the map, find the pair of numbers which if kept together will be divisible by k and avoid keeping them together in the non-divisible subset
	    Step 3: Finally return the size of the nonDivisibleSubset
	    */
	    private static Set<Integer> nonDivisibleSet;
	    
	    /*
	    Step : 1
	    Generate the Map having key as the modulo form 0 to k-1
	    Values as the list of all elements in the array s where s[i]%k=key;
	    */
	    private static Map<Integer,List<Integer>> getListOfModuloMap(int k, List<Integer> s){
	        Map<Integer,List<Integer>> moduloListMap=new HashMap<>();
	        for(int i=0;i<s.size();i++) {
	            int mod=s.get(i)%k;
	            if(moduloListMap.containsKey(mod)) {
	                moduloListMap.get(mod).add(s.get(i));
	            }
	            else {
	                List<Integer> initialModList=new ArrayList<>();
	                initialModList.add(s.get(i));
	                moduloListMap.put(mod, initialModList);
	            }
	        }
	        return moduloListMap;
	    }
	    
	    /*
	    Step 2:
	    1.Using the modulo list map
	    2.Iterate over the keys
	    3.Get the key and k-key, since key+k-key=k and k%k==0
	    4.so the elements under these 2 keys should not be present together in the non-divisible subset
	    5.Hence adding any one of them with least frequency if formed pairs such that in the pair a,b(a+b)%k==0
	    6.when k==k-key adding any key from the moduloListMap under the key k
	    */
	    private static void getNonDivisibleValues(Map<Integer,List<Integer>> moduloListMap,int k){
	        Set<Integer> mapKeys=new HashSet<>(moduloListMap.keySet());
	        for(Integer m:mapKeys) {
	            int pm=k-m;
	            if(m==0) {
	                pm=0;
	            }
	            if(moduloListMap.containsKey(pm)) {
	            List<Integer> l1=moduloListMap.get(m);
	            List<Integer> l2=moduloListMap.get(pm);
	            for(int i=0;i<l1.size();i++) {
	                if(m==pm) {
	                    nonDivisibleSet.add(l1.get(i));
	                    break;
	                }
	                for(int j=0;j<l2.size();j++) {
	                    int v1=l1.get(i);
	                    int v2=l2.get(j);
	                    if(l2.size()<l1.size()) {
	                        nonDivisibleSet.add(v1);
	                        break;
	                    }
	                    else {
	                        nonDivisibleSet.add(v2);
	                        continue;
	                    }
	                }
	                if(l2.size()>=l1.size())
	                break;
	            }
	            moduloListMap.remove(m);
	            moduloListMap.remove(pm);
	        }
	            else {
	                if(moduloListMap.containsKey(m)) {
	                List<Integer> l1=moduloListMap.get(m);
	                for(Integer i:l1) {
	                    nonDivisibleSet.add(i);
	                }
	                moduloListMap.remove(m);
	                }
	            }
	        }
	    }
	    public static int nonDivisibleSubset(int k, List<Integer> s) {
	    // Write your code here
	    nonDivisibleSet=new HashSet<>();
	    Map<Integer,List<Integer>> moduloListMap=getListOfModuloMap(k, s);
	    getNonDivisibleValues(moduloListMap,k); 
	    
	    //Step 3:
	    //finally returning the size of the elements in non-divisble subset array       
	    return nonDivisibleSet.size();
	    }

	}

	public class Solution {
	    public static void main(String[] args) throws IOException {
	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

	        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

	        int n = Integer.parseInt(firstMultipleInput[0]);

	        int k = Integer.parseInt(firstMultipleInput[1]);

	        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
	            .map(Integer::parseInt)
	            .collect(toList());

	        int result = Result.nonDivisibleSubset(k, s);

	        bufferedWriter.write(String.valueOf(result));
	        bufferedWriter.newLine();

	        bufferedReader.close();
	        bufferedWriter.close();
	    }
	}
}
