package com.example.InterviewQns;

/*
 * Company Name: SPG-India
 * Level 1 interview for position "Java Engineer"
 * Problem: You have an array arr[] with consecutive integers in the range of [1, n],
	except there is one number missing from the array
	the task is to find the missing number from the first n integers.
	Note:There are no duplicates in the array
	[1,2,3,4,5,6,8,9,10] - 7 
	[4,2,1,6,3,7,8,10,9] - 5
 */
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindMissingElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input1 = {4,2,1,6,3,7,8,10,9};
		int[] input = {1,2,4,5,6,7,8,9,10};
		//approach1(input);	
		//approach2(input1);
		approach3(input);
		approach4(input);
	}
	
	//O(n) time complexity without using more space
	//works if the integer array is not sorted
	public static void approach1(int[] input ) {
		//if input is to be sorted using O(nlogn) - dual pivot sorting algo
		int[] freqCount = new int[input.length+1];
		for(int i=0;i<input.length;i++) {
			freqCount[input[i]-1]++;
		}
		for(int j=0;j<freqCount.length;j++) {
			if(freqCount[j] == 0) {
				System.out.println("Missing element: " + (j+1));
			}
		}
	}
	
	//If space is not a constraint, works if the integer array is not sorted
	//O(n) time complexity
	public static void approach2(int[] input) {
		Map<Integer,Long> freqMap = new HashMap<>();
		for(int i=0;i<input.length;i++) {
			freqMap.put(i+1, 0L);
		}
		Map<Integer,Long> map2 = Arrays.stream(input).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		map2.forEach((key, value) -> freqMap.merge(key, value,  Long::sum));
		//freqMap.entrySet().stream().forEach(entry -> System.out.println(entry.getKey()+ " ::: " + entry.getValue()));
		freqMap.entrySet().stream().filter(entry -> entry.getValue() == 0).forEach(entry -> System.out.println("Missing element: " + entry.getKey()));
	}
		
	//O(logn) time complexity if the array is sorted, using binary search algo
	public static void approach3(int[] input) {
		int left = 0, right = input.length - 1;

	    while (left <= right) {
	        int mid = left + (right - left) / 2;
	        if (input[mid] == mid + 1) {
	            left = mid + 1;
	        } else {
	            right = mid - 1;
	        }
	    }

	    System.out.println("Missing value:: " + (left + 1)); // since missing number is at index 'left'
	}
	
	//Doesn't matter whether the array is sorted or not	
	//time complexity - O(n)
	public static void approach4(int[] input) {
		int n = input.length+1;
		int actualSum = 0;
		int sumOfNaturalNum = n * (n+1)/2;
		for(int i=0;i<input.length;i++) {
			actualSum += input[i];
		}
		int missingNum = sumOfNaturalNum -  actualSum;
		System.out.println(" Missing number is : " + missingNum);
	}
	

}


 
