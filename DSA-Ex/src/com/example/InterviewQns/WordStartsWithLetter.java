package com.example.InterviewQns;

import java.util.Arrays;
import java.util.List;

public class WordStartsWithLetter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//list of strings - filter out strings that start with 'A'
		List<String> lst = Arrays.asList("apple","banana","arizona");
		lst.stream().filter(str -> str.matches("[a].*")).forEach(str -> System.out.println(str));
		
	}

}


