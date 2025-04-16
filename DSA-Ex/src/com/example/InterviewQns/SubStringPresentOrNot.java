package com.example.InterviewQns;

//Company Name: ThoughtFocus
//Level 1 interview round
//Identify a substring with out using predefined methods
public class SubStringPresentOrNot {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  String input = "hello";
	      String str = "lp";
	      System.out.println("Output: " + approach1(input,str));    
	      //Approach 2 would be KPM algorithm which would give O(m+n) time complexity
	  }	
	
	//Using Sliding Window pattern, time complexity - O(n * m)
	public static boolean approach1(String input, String str) {
		int m = input.length();
	      int n = str.length();	       
	      if(n > m) {
	    	  return false;
	      } 	     
	      for(int i=0;i<=m-n;i++) {
	    	  boolean output = true;
	    	 for(int j=0;j<n;j++) {	    		
	    		 if(input.charAt(i+j) != str.charAt(j)) {
	    			 output = false;
	    			 break;
	    		 }
	    	 }
	    	 if(output) return true;
	      }	      
	      return false;
	}
}
