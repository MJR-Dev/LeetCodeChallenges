import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BackSpaceStringCompare {

	public static String s;
	public static String t;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Enter the first string");
			s = br.readLine();
			System.out.println("Enter the second string");
			t = br.readLine();
			br.close();
			if(backspaceRemove(s).equals(backspaceRemove(t)))
				System.out.println("True");
			else
				System.out.println("False");
			
		} 
		catch(IOException ioe) {
			System.out.println("Invalid Input.");
		}		
		finally {
			System.out.println("finally exec.");			
		}
	}
	
	public static String backspaceRemove(String s) {
		String tmpS = new String();
		Stack<Character> st = new Stack<>();
        if(checkChars(s)) {
        	for(int i=0;i<s.length();i++) {
        		if(s.charAt(i)== '#') {
            		if(!st.empty())
            			st.pop(); 
        		}
        		else 
        			st.add(s.charAt(i));
        	}	
        }
        if(!st.empty())
        	tmpS =  stackToString(st);
        System.out.println("String after backspace removal:: "+tmpS);
        return tmpS;
    }
	
	//Check if the input strings contain any characters
	public static boolean checkChars(String str) {
		for(int start =0;start<str.length();start++) {
			char c = str.charAt(start);
			if(c >= 'a' && c <= 'z')
				return true;
		}
		return false;
	}
	
	public static String stackToString(Stack st) {
		StringBuilder sb = new StringBuilder();
		for(int k=0;k<st.size();k++) {
			sb.append(st.elementAt(k));
		}
		return sb.toString();
	}
}
