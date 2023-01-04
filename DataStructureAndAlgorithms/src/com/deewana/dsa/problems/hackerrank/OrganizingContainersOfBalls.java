package com.deewana.dsa.problems.hackerrank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class OrganizingContainersOfBalls {

	class Result {

	    /*
	     * Complete the 'organizingContainers' function below.
	     *
	     * The function is expected to return a STRING.
	     * The function accepts 2D_INTEGER_ARRAY container as parameter.
	     */

	    public static String organizingContainers(List<List<Integer>> container) {
	    // Write your code here
	    
	    //this array List have the count of which color ball occured how many times
	    List<Integer> colorList=new ArrayList<>(Collections.nCopies(container.size(), 0));
	    //conatinerMap contains the number of map of a given specific size
	    Map<Integer,Integer> containerMap=new HashMap<>();
	    for(List<Integer> li:container){
	        int sum=0;
	        for(int i=0;i<li.size();i++){
	            int color=li.get(i);
	            sum+=color;
	            colorList.set(i, colorList.get(i)+color);
	        }
	        if(containerMap.containsKey(sum)){
	            containerMap.replace(sum,containerMap.get(sum)+1);
	        }
	        else{
	            containerMap.put(sum,1);
	        }
	    }
	    
	    for(int i=0;i<colorList.size();i++){
	        int val=colorList.get(i);
	        
	        //if the number of color is equal to size of one of unused container then place it their and mark that container as used else return impossible
	        if(containerMap.containsKey(val)){
	            containerMap.replace(val,containerMap.get(val)-1);
	            if(containerMap.get(val)<=0)
	            containerMap.remove(val);
	        }
	        else{
	            return "Impossible";
	        }
	        
	    }
	    
	    //finally returning possible
	    return "Possible";

	    }

	}

	    public static void main(String[] args) throws IOException {
	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

	        int q = Integer.parseInt(bufferedReader.readLine().trim());

	        IntStream.range(0, q).forEach(qItr -> {
	            try {
	                int n = Integer.parseInt(bufferedReader.readLine().trim());

	                List<List<Integer>> container = new ArrayList<>();

	                IntStream.range(0, n).forEach(i -> {
	                    try {
	                        container.add(
	                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
	                                .map(Integer::parseInt)
	                                .collect(toList())
	                        );
	                    } catch (IOException ex) {
	                        throw new RuntimeException(ex);
	                    }
	                });

	                String result = Result.organizingContainers(container);

	                bufferedWriter.write(result);
	                bufferedWriter.newLine();
	            } catch (IOException ex) {
	                throw new RuntimeException(ex);
	            }
	        });

	        bufferedReader.close();
	        bufferedWriter.close();
	    }
}
