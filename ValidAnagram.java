import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("anagram nagaram are Anagrams  :: "+isAnagram("anagram","nagaram"));
		System.out.println("seetha geetha are Anagrams  :: "+isAnagramUsingCharArray("seetha","geetha"));
	}
	
	public static boolean isAnagramUsingCharArray(String s, String t) {
		char[] sCharArray = s.toCharArray();
		char[] tCharArray = t.toCharArray();
		int[] tmp = new int[26];
		for(char c: sCharArray)
			tmp[c - 'a']++;
		for(char c: tCharArray)
			tmp[c - 'a']--;
		for(int i : tmp) {
			if(i != 0)
				return false;
		}
		return true;	
	}
	
	//Using HashMaps to store both the strings and compare the maps. This is taking 15ms of execution time.
	public static boolean isAnagram(String s, String t) {
		boolean flag = false;
		if(s.length() != t.length())
			return flag;
		else if((s.length() == t.length())&& s.length() > 0 && t.length() > 0){
			 Map<Character,Integer> sMap = new HashMap<>();
		     Map<Character,Integer> tMap = new HashMap<>();
		     for(int i=0;i<s.length();i++) {
		    	if(sMap.containsKey(s.charAt(i))) {
		        	int count1 = sMap.get(s.charAt(i));
		        	sMap.put(s.charAt(i), (count1+1));
		        }
		        else {
		        	sMap.put(s.charAt(i), 1);
		        }
		     }
		     for(int j=0;j<t.length();j++) {
		        if(tMap.containsKey(t.charAt(j))) {
		        	int count2 = tMap.get(t.charAt(j));
		        	tMap.put(t.charAt(j), (count2+1));
		        }
		        else {
		        	tMap.put(t.charAt(j), 1);
		        }
		     }
		     
		     if(sMap.equals(tMap))
		    	 flag = true;
		     else 
		    	 flag = false;
		}
       return flag;
    }

}
