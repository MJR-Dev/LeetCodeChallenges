package com.example.dsa;

public class AllWrong {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getWrongAnswers(3,"ABA");
		System.out.println(String.format("%.8f", (double)(3/6)));
	}

	public static void getWrongAnswers(int N, String C) {
	    // Write your code here
		StringBuilder sb  = new StringBuilder();
	    C.chars().mapToObj(i -> (char)i).forEach(ch -> {
	    	if(ch == 'A')
	    		sb.append('B');
	    	else if(ch == 'B')
	    		sb.append('A');
	    });
	    System.out.println(("final wrong answer: " + sb.toString()));
	    
	  }
}
