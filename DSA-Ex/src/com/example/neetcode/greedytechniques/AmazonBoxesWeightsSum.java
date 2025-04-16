package com.example.neetcode.greedytechniques;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
 * an amazon  fulfillment asociate has a set of items that need to be packed into 2 boxes given an integer array of the item weights [arr] to be packed, divid the item weights into 2 subsets a, b, for packing into the associated boxes, while respecting the following conditions:
1. intersection of, a,b is null
2. union of a, b = arr
3. number of elements in subset a is minimal
4. sum of a's weights is > sum of b's weights

return the subset a in increasing order where the sum of a's weights is greater than the smum of b's weights. if more than 1 subset a exists, return the one with maximal total weight. 

n=5
arr= [3,7,5,6,2]
output: [7,6]
 */
//Solution using greedy technique pattern
public class AmazonBoxesWeightsSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] weights= {3,7,5,6,2,9};
		minimalSubsetWithGreaterSum(weights).stream().forEach(System.out::println);		
	}
	
	public static List<Integer> minimalSubsetWithGreaterSum(int[] arr) {
		List<Integer> sortedWeights = Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		int totalweights = sortedWeights.stream().mapToInt(Integer::valueOf).sum();
		List<Integer> subsetAWeights = new ArrayList<>();
		int sumOfWeights = 0;
		for(Integer val : sortedWeights) {
			if(sumOfWeights < totalweights/2) {
				sumOfWeights += val;
				subsetAWeights.add(val);
			} else {
				break;
			}
		}
		return subsetAWeights;
	}

}
