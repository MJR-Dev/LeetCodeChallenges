import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.function.Predicate;

public class SherloackAndValidString {

	//aabbccddeefghi
	//
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isValid("abcchhd"));
	}

	//Test Case1: all characters have same frequencies
	//Test Case2: All characters except 1,have same frequencies. The excluded character has just 1 frequency
	//Test Case3: All characters except 1,have same frequencies. The excluded character has 1+ frequency when
	//				when compared to all other characters
	
	public static String isValid(String s) {
	    // Write your code here
		Predicate<Integer> pred1 = (x) -> x==1;
		String validOrNot = "NO";
		Map<Character,Integer> mapFreq = getFreq(s);		
		
		if(mapFreq.values().stream().distinct().count()==1) {
			validOrNot = "YES";
		}
		else if(mapFreq.values().stream().distinct().count()==2) {				
			if(mapFreq.values().stream().filter(pred1).count()==1)
				validOrNot = "YES";
			else if(mapFreq.values().stream().filter(pred1).count()>1) {				
				int otherValCount = (int) mapFreq.values().stream().filter(pred1.negate()).count();
				if(otherValCount ==1) {
					Optional<Integer> opt1 = mapFreq.values().stream().filter(pred1.negate()).findFirst();
					if(opt1.get() - 1 == 1)
						validOrNot = "YES";
				}
			}
			else {
				Optional<Integer> maxFreq = mapFreq.values().stream().max(Comparator.naturalOrder());
				Optional<Integer> minFreq = mapFreq.values().stream().min(Comparator.naturalOrder());
				if((maxFreq.get() - minFreq.get())==1)
					validOrNot = "YES";
			}
				
		}
		
		return validOrNot;
	}
	
	public static Map<Character,Integer> getFreq(String s){
		Map<Character,Integer> mapFreq = new TreeMap<>();
		for(int i=0;i<s.length();i++) {
			Character c = s.charAt(i);
			if(mapFreq.containsKey(c)) {
				int count = mapFreq.get(c);
				mapFreq.put(c, (count+1));
			}
			else
				mapFreq.put(c, 1);
		}
		return mapFreq;
	}
}
