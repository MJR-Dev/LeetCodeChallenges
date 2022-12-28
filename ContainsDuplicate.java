import java.util.HashMap;
import java.util.Map;

/*
 * Given an integer array nums, 
 * return true if any value appears at least twice in the array, 
 * and return false if every element is distinct.
 */

public class ContainsDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] nums = {1,2,3,1};
		int[] nums = {1,1,1,3,3,4,3,2,4,2};
		System.out.println("flag  :"+containsDuplicate(nums));
	}

	public static boolean containsDuplicate(int[] nums) {
		boolean flag = false;
        Map<Integer, Integer> valCount = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
        	if(valCount.containsKey(nums[i])) {
        		int count = valCount.get(nums[i]);
        		count = count+1;
        		if(count > 1) {
        			flag = true;
        			break;
        		}        			
        	}
        	else {
        		valCount.put(nums[i], 1);
        		flag = false;
        	}
        	if(flag)
        		break;
        }
        return flag;
    }
	
}
