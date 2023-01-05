/*
 * Given two integer arrays A and B of size N. There are N gas stations along a circular route, 
 * where the amount of gas at station i is A[i].You have a car with an unlimited gas tank and 
 * it costs B[i] of gas to travel from station i to its next station (i+1). You begin the 
 * journey with an empty tank at one of the gas stations.Return the minimum starting gas 
 * station's index if you can travel around the circuit once, otherwise return -1.You can only 
 * travel in one direction. i to i+1, i+2, ... n-1, 0, 1, 2.. Completing the circuit means 
 * starting at i and ending up at i again.
 * Problem Constraints
 * 1 <= |A| <= 5 * 105
 * |A| == |B|
 * 0 <= Ai <= 5 * 103
 * 0 <= Bi <= 5 * 103
 * Input Format
 * The first argument given is the integer array A. The second argument given is the integer array B.
 * Output Format
 * Return the minimum starting gas station's index if you can travel around the circuit once, 
 * otherwise return -1.

 */
public class CircularGasStation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {7,2,1,11,4};
		int[] B = {5,8,2,2,5};
		System.out.println("Minimum Index:: "+getMinIndex(A,B));
	}
	
	public static int getMinIndex(int[] A, int[] B) {
		int n = A.length;
		int minIndex = -1;
		int minCost = Integer.MAX_VALUE;
		for(int i=0;i<n;i++) {
			int cost = 0;
			for(int j=i;j<n;j++) {
				cost += A[j]-B[j];
				if(cost < 0)
					break;
			}
			for(int k=0;k<i;k++) {
				cost += A[k]-B[k];
				if(cost < 0)
					break;
			}
			if(cost >= 0 && cost < minCost) {
				minCost = cost;
				minIndex = i;
			}
		}
		return minIndex;
	}
	

}
