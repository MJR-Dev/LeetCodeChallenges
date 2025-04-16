package com.example.InterviewQns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * L1: 12 3 81 92 5 2 21 43 36
L2: 2 3 5 6
Output: 12 3 21 36 5 2 43 81 92
        [12, 3, 21, 36, 5, 2, 43, 81, 92]
12 81 92 21 43 36
- 3 - - 5 2 - - -

CAT, ACT, RAT, TAC, TAR, MARK, INK
 */
public class PositionPreservingSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] l1 = {12, 3, 81, 92, 5, 2, 21, 43, 36};
		int[] l2 = {2,3,5,6};
		approach1(l1,l2);
		approach2(l1, l2);
		approach3(l1, l2);
	}
	
	public static void approach1(int[] l1, int[] l2) {
		List<Integer> indicesL1 = new ArrayList<>();
		List<Integer> valuesL1 = new ArrayList<>();
		boolean present = false;
		int tmp = 0;
		for(int i=0;i<l1.length;i++) {
			for(int j=0;j<l2.length;j++) {
				if(l1[i] != l2[j]) {
					present = false;
				} else {
					present  = true;
					break;
				}
			}
			if(!present) {
				indicesL1.add(i);
				valuesL1.add(l1[i]);
			}
		}
		Collections.sort(valuesL1);
		for(int tmpIndx : indicesL1) {
			l1[tmpIndx] = valuesL1.get(tmp);
			tmp++;
		}
		Arrays.stream(l1).forEach(val -> System.out.print(val + " "));
	}
		

	public static void approach2(int[] l1, int[] l2) {
		Set<Integer> setL2 = new HashSet<>();
		Arrays.stream(l2).boxed().distinct().forEach(setL2::add);
		List<Integer> indicesL1 = new ArrayList<>();
		List<Integer> valuesL1 = new ArrayList<>();
		int tmpIndx = 0;
		for(int i=0;i<l1.length;i++) {
			if(!setL2.contains(l1[i])) {
				indicesL1.add(i);
				valuesL1.add(l1[i]);
			}
		}
		Collections.sort(valuesL1);
		for(int tmp: indicesL1) {
			l1[tmp] = valuesL1.get(tmpIndx);
			tmpIndx++;
		}
		Arrays.stream(l1).forEach(val -> System.out.print(val + " "));
	}
	
	public static void approach3(int[] l1, int[] l2) {
		List<Integer> listL1 = Arrays.stream(l1).boxed().collect(Collectors.toList());
		Set<Integer> setL2 = Arrays.stream(l2).boxed().collect(Collectors.toSet());
		List<Integer> indicesL1 = IntStream.range(0, listL1.size()).filter(indx -> !setL2.contains(listL1.get(indx)))
				.boxed().collect(Collectors.toList());
		List<Integer> valuesL1 = indicesL1.stream().map(listL1::get).sorted().collect(Collectors.toList());
		int tmpIndx = 0;
		for(int tmp : indicesL1) {
			listL1.set(tmp, valuesL1.get(tmpIndx));
			tmpIndx++;
		}
		listL1.stream().forEach(System.out::println);
	}
}




