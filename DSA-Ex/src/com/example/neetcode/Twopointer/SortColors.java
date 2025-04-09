package com.example.neetcode.Twopointer;

import java.util.stream.IntStream;

public class SortColors {

	//input: {1,0,2,1,2,2}, {2,2,1,1,0},{2,2,0,1,2,2,0,2},
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] colors = {0,1,0};
		int[] result = new int[colors.length];
		result = sortColors(colors);
		IntStream.of(result).forEach(val -> System.out.print("  " + val));		
	}
	
	public static int[] sortColors (int[] colors) {
        if(colors.length == 0){
            return colors;
        } else {
            int current = 0;
            int left = 0;
            int right = colors.length-1;
            while(right >= current) {
                if(colors[current] == 0) {
                    int tmp = colors[current];
                    colors[current] = colors[left];
                    colors[left] = tmp;
                    current++;
                    left++;
                } else if(colors[current]==1){
                    current++;
                } else if(colors[current]==2){
                    int tmp1 = colors[current];
                    colors[current] = colors[right];
                    colors[right] = tmp1;
                    right--;
                }
            }
        }
        
        return colors;
    }

}
