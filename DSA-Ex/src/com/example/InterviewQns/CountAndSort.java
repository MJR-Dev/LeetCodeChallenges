package com.example.InterviewQns;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountAndSort {	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "aa bb cc bb cc aa cc aa cc";		
		Stream.of(str.split(" ")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(entry -> System.out.println(entry.getKey() + " ** " + entry.getValue()));
		
	}

}

/*
Output:
bb 2
aa 3
cc 4
*/