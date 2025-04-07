package com.example.neetcode.Twopointer;

import java.util.Scanner;

public class StringAddition {
	public static void main(String[] args) {
		//Scanner sc = new Scanner(System.in);
		//String s1 = sc.nextLine();
		//String s2 = sc.nextLine();
		//approach1(s1,s2);
		approach2("934", "9876");
	}
	
	//time complexity - O(n), space complexity - O(n)
	public static void approach1(String s1, String s2) {
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
				if(i <= 0 && j <= 0 && carryForward > 0)
					sb.append(String.valueOf(carryForward));
				i--;
				j--;
			}
		}
		System.out.println("sum: " + sb.reverse().toString());
	}
	
	//time complexity - O(n), space complexity - O(n)
	public static void approach2(String s3, String s4) {
		StringBuilder sb = new StringBuilder();
		int i = s3.length()-1;
		int j = s4.length()-1;
		if(i > 0 && j > 0) {
			int carryForward = 0;
			while(i>= 0 || j >= 0 || carryForward != 0) {
				Integer sum2 = 0;
				int digit1 = (i >= 0) ? s3.charAt(i) - '0' : 0;
				int digit2 = (j >= 0) ? s4.charAt(j) - '0': 0;
				
				sum2 = digit1 + digit2 + carryForward;
				carryForward = sum2/10;
				sum2 = sum2 % 10;					
				
				sb.append(String.valueOf(sum2));
				
				i--;
				j--;
			}
		}
		System.out.println("sum: " + sb.reverse().toString());
	}
}
