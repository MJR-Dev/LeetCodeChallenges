package com.example.InterviewQns;

//Company Name: Ratna Global Tech
//Level 2 interview round
//Find the non-repeating characters in the above string - it can be a letter, number, special character
//Without using any built-in methods like contains, substring, or collections
public class NonRepeatingChars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "quick brown fox jumped 34nd###$2323nesdk";
		System.out.println("Approach 1 - using brute force");
		approach1(input);
		System.out.println("Approach 2 - Optimized solution");
		approach2(input);
	
	}
	
	//Brute force method. Time complexity - O(n*(n-1)) = O(n^2)
	public static void approach1(String input) {
		boolean repeatingChar = false;
		for(int i=0;i<input.length()-1;i++) {
			repeatingChar = false;
			char ch1 = input.charAt(i);
			for(int j=0;j<input.length();j++) {
				if(i != j) {
					char ch2 = input.charAt(j);
					if(ch1==ch2) {
						repeatingChar = true;
						break;
					}
				}				
			}
			if(!repeatingChar)
				System.out.println(input.charAt(i));			
		}		
	}
	
	//Optimized solution. time complexity - O(n)+O(n) = O(n)
	public static void approach2(String input) {
		int[] countChar = new int[256];
		for(int i=0;i<input.length();i++) {
			char ch = input.charAt(i);
			countChar[ch]++;
		}
		for(int j=0;j<input.length();j++) {
			char tmp = input.charAt(j);
			if(countChar[tmp] ==1)
				System.out.println(tmp);
		}
	}
		
}


