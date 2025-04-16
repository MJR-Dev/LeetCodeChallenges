package com.example.InterviewQns;

import java.util.stream.IntStream;

//Company Name: CDK Global
//Level 2 interview round
//From 1 to 30, for multiple of 3 - print firstname, multiple of 5 - print lastname, 
//multiple of 3&5 - print firstname + lastname
public class NumberRangePrint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Approach 1 - using brute force");
		approach1();
		System.out.println("Approach 2 - using streams");
		approach2();
		System.out.println("Approach 3 - Optimized solution");
		approach3();		
	}

	//brute force method. Time complexity : O(n)
	public static void approach1() {
		for(int i = 1;i<=30;i++) {
			int num = i;			
			if(num%3 == 0 && num%5 == 0 ) {				
				System.out.println("FirstName LastName");
			} else if(num%3 == 0 && num%5 != 0 ) {
				System.out.println("FirstName");
			} else if(num%3 != 0 && num%5 == 0 ) {
				System.out.println("LastName");
			} else {
				System.out.println(i);
			}
		}
	}
	
	//Using Streams 
	public static void approach2() {
		IntStream.range(1, 31).forEach(num -> {
			if(num%3 == 0 && num%5 == 0 ) {				
				System.out.println("FirstName LastName");
			} else if(num%3 == 0 && num%5 != 0 ) {
				System.out.println("FirstName");
			} else if(num%3 != 0 && num%5 == 0 ) {
				System.out.println("LastName");
			} else {
				System.out.println(num);
			}
		});
	}
	
	//Using Streams - more optimized solution
	public static void approach3() {
		IntStream.rangeClosed(0, 30).mapToObj(num -> {
			if(num%3==0 && num%5==0)
				return "FirstName LastName";
			else if(num%3 == 0 && num%5 != 0 )
				return "FirstName";
			 else if(num%3 != 0 && num%5 == 0 ) 
				 return "LastName";
			 else 
				 return num;
		}).forEach(System.out::println);
	}			
}