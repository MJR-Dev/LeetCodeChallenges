package com.example.neetcode.Twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//SUM OF 3 VALUES  == 0
/*Given an integer array nums, find and return all unique triplets [nums[i], nums[j], nums[k]], 
 * where the indexes satisfy i≠j,i≠k, and j≠k, and the sum of the elements nums[i] + nums[j] + nums[k] == 0.*/
public class ThreeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-2,-2,-2,-2,0,0,0,0,0,2,2,2,2,2};
		List<List<Integer>> result = threeSum(nums);
		for(int i=0;i<result.size();i++) {
			List<Integer> tmp = result.get(i);
			for(int j=0;j<tmp.size();j++) {
				System.out.print(tmp.get(j) + " ");
			}
			System.out.println();
		}
	}

	//skip duplicates as adding them will not give the desired result
	public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> threeSum = new ArrayList<>();
      // Replace this placeholder return statement with your code
      Arrays.sort(nums);
      int current = 0;
      int left = 1;
      int right = nums.length - 1;
      for(int i=0;i<nums.length-2;i++){
          current = i;
          left = i+1;
          right = nums.length- 1;
          if(i>0 && nums[i] == nums[i-1])
        	  continue;
          if(nums[current] > 0)
    		  break;
          while(left < right) {
        	  
        		  if((nums[current] + nums[left] + nums[right]) == 0) {
        			  threeSum.add(Arrays.asList(nums[current], nums[left],nums[right]));
        			  while(left < right && nums[left] == nums[left+1])
        				  left++;
        			  while(left < right && nums[right] == nums[right-1])
        				  right--;
        			  left++;
        			  right--;
        		  } else if((nums[current] + nums[left] + nums[right]) < 0) {
        			  left++;
        		  } else {
        			  right--;
        		  }
        	  }
               
      }
      return threeSum;
   }
}
