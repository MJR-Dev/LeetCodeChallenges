package com.example.dsa;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatingChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Get the first non repeating character in a string
		String input = "swiss";
		Map<Character, Long> map1 = input.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
		map1.entrySet().stream().filter(entry -> entry.getValue() == 1).findFirst().ifPresentOrElse(entry -> System.out.println(entry.getKey()), () -> System.out.println("None"));
	
		//most frequently occurring letter
		String str = "kjshwfiusekfjhwoeijfckwheajvgfwehcjwheriulegwpewsijvladnhkjbhkjhkhhhhhhhhhhhhhhhhhhhhhhjkkkkkkkkkkkkkkkkkkkkkk";
		str.chars().mapToObj(c ->(char)c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
					.entrySet().stream().max(Comparator.comparing(entry -> entry.getValue())).ifPresent(entry -> System.out.println(entry.getKey()));
	
		//str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + " ** " + entry.getValue()));
	}

}
