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
	}

}
