package com.example.InterviewQns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseWordsInSentence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//input: java8 is cool                      
		//Output : 8avaj si looc
		//java8 - ipAry[0]
		String input = "java8 is cool";
	
		//Approach 1 - using streams
		Arrays.stream(input.split(" ")).map(str -> new StringBuilder(str).reverse().toString()).collect(Collectors.toList()).forEach(str -> System.out.print(str+ " "));
		
		//Approach 2 - without streams
		List<String> lst = new ArrayList<>();
		String[] ipAry = input.split(" ");
		for(int i=0;i<ipAry.length;i++) {
			String str = ipAry[i];			
			StringBuilder sb = new StringBuilder();
			for(int j = str.length()-1;j>=0;j--) {				
				sb.append(str.charAt(j));
			}			
			lst.add(sb.toString());
		}
		lst.stream().forEach(str -> System.out.print(str + " "));
		
		String s2 = "12349";
		String s1 = "123";
		StringBuilder sb = new StringBuilder();
		int i = s1.length()-1;
		int j = s2.length()-1;
		if(i > 0 && j > 0) {
			int carryForward = 0;
			while(i>= 0 || j >= 0) {
				Integer sum1 = 0;
				if(i < 0 && j >= 0) {
					sum1 = Integer.parseInt(String.valueOf(s2.charAt(j))) + carryForward;
				} else if(i >= 0 && j < 0) {
					sum1 = Integer.parseInt(String.valueOf(s1.charAt(i))) + carryForward;
				} else {
					sum1 = Integer.parseInt(String.valueOf(s1.charAt(i))) +  Integer.parseInt(String.valueOf(s2.charAt(j))) + carryForward;
				}
				carryForward = 0;
				if(sum1 > 9) {
					carryForward = sum1/10;
					sum1 = sum1 % 10;					
				}
				sb.append(String.valueOf(sum1));
				i--;
				j--;
			}
		}
		System.out.println("sum: " + sb.reverse().toString());
	}

}
