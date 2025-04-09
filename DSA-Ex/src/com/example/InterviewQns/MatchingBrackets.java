package com.example.InterviewQns;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//Input: '(', ')', '{', '}', '[' and ']'
// Input : "()[]{}", Output: True
// Input : "()", Output: True
// Input : "()[{}", Output: false
// Input : "}", Output: false
// Input : "([{}])", Output: True
// Input : "}{", Output: false
public class MatchingBrackets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean valid = checkValidity("}{");
		System.out.println("isValid: " + valid);
	}

	public static boolean checkValidity(String input) {
		Map<String, String> map1 = new HashMap<>();
		map1.put("}", "{");
		map1.put("]", "[");
		map1.put(")", "(");
		
		boolean isValid = false;
		
		Stack brackets = new Stack();
		for(int i=0;i<input.length();i++) {
			String tmp = String.valueOf(input.charAt(i));
			if(map1.containsValue(tmp)) {
				brackets.add(tmp);
			} else if(map1.containsKey(tmp)) {
				if(!brackets.isEmpty() && (map1.get(tmp).equals(brackets.pop()))) {
					isValid = true;
				} else {
					return false;
				}
			}
		}
		return isValid && brackets.empty();
	}
}
