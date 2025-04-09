package com.example.neetcode.Twopointer;

public class ReverseWords {

	/*
	 * List<String> stringsToReverse = Arrays.asList(
            "Hello World",
            "a   string   with   multiple   spaces",
            "Case Sensitive Test 1234",
            "a 1 b 2 c 3 d 4 e 5",
            "     trailing spaces",
            "case test interesting an is this"
        );
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseSentence("Hello     World"));
		System.out.println();
		System.out.println(reverseSentence("The quick brown fox jumped over a lazy dog"));
		System.out.println();
		System.out.println(reverseSentence("The"));
	}

	public static String reverseSentence(String sentence) {
		if((sentence = sentence.trim()).length() == 0) return "";
        // Replace this placeholder return statement with your code
		 String[] words = sentence.split("\\s+");
	     int start = 0;
	     int end = words.length-1;
	     while(start <= end) {
	     	String tmp = words[start];
	     	words[start] = words[end];
	     	words[end] = tmp;
	     	start++;
	     	end--;
	     }
	     return String.join(" ",words);
	}
}
