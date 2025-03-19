package com.example.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConsecutiveSeqCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 94, 93, 1000, 5, 92, 78, 79};
		int[] arr1 = {1, 5, 92, 4, 78, 6, 7};
		//Approach 1
		List<Integer> sortedList = IntStream.of(arr).boxed().sorted().collect(Collectors.toList());
		List<Integer> lst = new ArrayList<>();
		int prev = sortedList.get(0);
		int curr = 0;
		int count = 0;
		int temp = 0;
		for(int i = 0;i<sortedList.size();i++) {	
			if(i==0) {
				curr = sortedList.get(i+1);
			}				
			else {
				prev = sortedList.get(i-1);
				curr = sortedList.get(i);
			}
			if(prev + 1  == curr) {				
				count++;
				temp = count;
			} else {
				count=0;
			}
		}
		if(temp > count)
			System.out.println("count: " + (temp+1));
		else
			System.out.println("count: " + count);
		
		getConsSeqCount(arr1);
		getConsSeq(arr);
	}

	//Approach 2	
	public static void getConsSeqCount(int[] arr) {
		int count = 0;
		int maxCount = 0;
		Arrays.sort(arr); //O(n log n)
		for(int i=1;i< arr.length; i++) { //O(n)
			if(arr[i-1] + 1 == arr[i]) {
				count++;
				maxCount = count;
			} else {				
				count = 0;
			}
		}
		maxCount++;
		System.out.println("getConsSeqCount  count: " + maxCount);		
	}
		
	//Approach 3
	//getting the longest seq along with its length
	public static void getConsSeq(int[] arr) {
			Arrays.sort(arr);  //O(n log n)
			List<Integer> longestSeq = new ArrayList<>();
			List<Integer> currentSeq = new ArrayList<>();
			currentSeq.add(arr[0]);
			for (int i = 1; i < arr.length; i++) {
	            if (arr[i] == arr[i - 1] + 1) { // Consecutive
	                currentSeq.add(arr[i]);
	            } else if (arr[i] != arr[i - 1]) { // Reset sequence
	                if (currentSeq.size() > longestSeq.size()) {
	                    longestSeq = new ArrayList<>(currentSeq);
	                }
	                currentSeq.clear();
	                currentSeq.add(arr[i]);
	            }
	        }

	        if (currentSeq.size() > longestSeq.size()) {
	            longestSeq = new ArrayList<>(currentSeq);
	        }
	        System.out.println("Longest Consecutive Seeq count: " + longestSeq.size());
	        //System.out.println();
	        longestSeq.forEach(i -> System.out.print(i + " "));
		}
		
	
}


/*Input : arr[] = {1, 94, 93, 1000, 5, 92, 78};
Output : 3 
The largest set of consecutive elements is
92, 93, 94 

Input  : arr[] = {1, 5, 92, 4, 78, 6, 7};
Output : 4 
The largest set of consecutive elements is
4, 5, 6, 7*/