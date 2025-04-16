package com.example.neetcode.greedytechniques;

import java.util.ArrayList;
import java.util.List;

public class ItemsCount {

	public static List<Integer> itemsCountPerComp = new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "|**|*|*";
		String input1 = "*|**||";
		String input2 = "*||*|***|*|";
		getItemsCountPerCompartment(input2,1,5);
		itemsCountPerComp.stream().forEach(System.out::println);
	}
	
	public static void getItemsCountPerCompartment(String input, int startIndx, int endIndx) {		
		input = input.trim();
		if(endIndx > startIndx && (!input.isEmpty())) {			
			int stIndx = startIndx-1;
			int enIndx = stIndx+1;
			int tmp = stIndx;
			while(stIndx >= startIndx-1 && enIndx <= endIndx-1) {
				while(stIndx < enIndx) {
					if(input.charAt(stIndx) == '*') {
						stIndx++;
						enIndx++;
					}
					if(input.charAt(enIndx) == '*') {
						enIndx++;
					}
					if(input.charAt(stIndx) == '|' && input.charAt(enIndx) == '|') {
						break;
					}
				}
				getItems(input.substring(stIndx,enIndx+1));
				stIndx = enIndx;
				enIndx = stIndx+1;
			}			
		}
	}
	
	public static void getItems(String input) {
		int count = 0;
		int curr = 0;
		while(curr < input.length()) {
			if(input.charAt(curr) == '*') {
				count++;
			}
			curr++;
		}
		itemsCountPerComp.add(count);
	}

}
