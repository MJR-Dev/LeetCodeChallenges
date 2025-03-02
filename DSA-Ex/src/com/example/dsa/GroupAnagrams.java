package com.example.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class GroupAnagrams {

	public static int[] PRIME_NUMBERS = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<Long, List<String>> map2 = new HashMap<>();
		Map<Long,List<String>> map3 = new ConcurrentHashMap<>();
		String[] strs = {"act","pots","tops","cat","stop","hat"};
		String[] strAn = {"henry","rynhe","rhy","hyr","yhr","yyy"};
		String[] strAn1 = {"eat","tea","tan","ate","nat","bat"};
		approach1(strs);
		approach2(strAn,map2);		
		approach3(strAn1, map3);
	}

	//time complexity - O(m*k log k)
	public static void approach1(String[] strs) {
		Map<String, List<String>> map1 = new HashMap<>();
		for(String val : strs) {
			String s1=sortStr(val);
			if(map1.containsKey(s1)) {
				List<String> tmp = map1.get(s1);
				tmp.add(val);
				map1.put(s1, tmp);
			} else {
				List<String> tmp = new ArrayList<>();
				tmp.add(val);
				map1.put(s1, tmp);
			}
		}
		map1.values().forEach(entry -> System.out.print(entry + "\n"));
	}
	
	public static String sortStr(String s) {
		String tmp = s.chars().sorted().mapToObj(c -> String.valueOf((char)c)).collect(Collectors.joining());
		//System.out.println("tmp:: " + tmp);
		return tmp;
	} 
	
	//time complexity - O(m * k)
	public static void approach2(String[] strs, Map<Long, List<String>> map2) {
		for(String val: strs) {
			Long hashVal = 1L;
			for(char c : val.toCharArray()) {
				hashVal *= PRIME_NUMBERS[c - 'a'];
			}
			map2.computeIfAbsent(hashVal, k -> new ArrayList<String>()).add(val);
		}
		map2.values().forEach(input -> System.out.print(input + "\n"));
	}
	
	//time complexity - O(m*k) - also depends on the CPU cores available in the system
	public static void approach3(String[] strs, Map<Long, List<String>> map3) {
		Arrays.stream(strs).parallel().forEach(str -> {
			Long hashVal1 = 1L;
			for(char c : str.toCharArray()) {
				hashVal1 *= PRIME_NUMBERS[c - 'a'];
			}
			map3.compute(hashVal1, (K,V) -> {
				if(V == null)
					V = Collections.synchronizedList(new ArrayList<>());
				V.add(str);
				return V;
			});
		});
		map3.values().forEach(System.out::println);
	}
}
