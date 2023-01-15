
public class MakingAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Minimum deletions required for the input strings to be made as anagrams::");
		System.out.println(makeAnagram("fcrxzwscanmligyxyvym","jxwtrhvujlmrpdoqbisbwhmgpmeoke"));
	}

	public static int makeAnagram(String a, String b) {
	    // Write your code here
	    int minDeletions = 0;
	        char[] aChar = a.toCharArray();
	        char[] bChar = b.toCharArray();
	        int[] tmpA = new int[26];
	        int[] tmpB = new int[26];
	        for(int i=0;i<aChar.length;i++) {
	            char c = aChar[i];
	            tmpA[c-'a']++;
	        }
	        for(int j=0;j<bChar.length;j++) {
	            char c = bChar[j];
	            tmpB[c-'a']++;
	        }        
	        for(int k=0;k<tmpA.length;k++) {
	            int tmpCount=0;
	            if(tmpA[k] > tmpB[k]) {
	                tmpCount = tmpA[k] - tmpB[k];            
	            }
	            else if(tmpA[k] < tmpB[k]) {                
	                tmpCount = tmpB[k] - tmpA[k] ;
	            }
	            minDeletions += tmpCount;             
	        }       
	        return minDeletions; 
	    }
}
