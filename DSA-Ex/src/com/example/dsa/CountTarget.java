package com.example.dsa;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CountTarget {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str[] = {"hello","jaisingh","durable","jolly","justice","peacock"};
		int[] arr = {1,2,4,4,4,4,3,7,8,4};
		 String[] words = { "Apple", "Banana", "Cherry", "Dog", "Elephant", "Fish", "Giraffe", "House", "Ice", "Jaguar",
                 "Kite", "Lion", "Monkey", "Nest", "Orange", "Pineapple", "Queen", "Rabbit", "Snake", "Tiger",
                 "Umbrella", "Violin", "Watermelon", "Xylophone", "Yak", "Zebra" };
		String[] testData = generateTestData(1000);
		System.out.println("count of 4: " + checkTargetOcc(arr, 4));
		System.out.println("count of str starting with j: " + checkStrStartsWith(str, 'j'));
		getLetterCount(testData);
	}

	//given an array of integers, find the count of 'target' occurrences
	public static long checkTargetOcc(int[] arr, int target) {
		long count =	IntStream.of(arr).filter(i -> (i==target)).count();
		long count1 = Arrays.stream(arr).boxed().filter(i -> (i== target)).count();
		return count;
	}
	
	//returns count of str starting with the character
	public static long checkStrStartsWith(String[] strs, char ch) {
		return Arrays.stream(strs).filter(str -> str.charAt(0) == 'j').count();
	}
	
	public static void getLetterCount(String[] strs){
		Map<Character,Long> map1 = new HashMap<>();
		map1 = Arrays.stream(strs).collect(Collectors.groupingBy(word -> word.charAt(0), Collectors.counting()));
		map1.entrySet().forEach(entry -> System.out.println(entry.getKey() +" :: " + entry.getValue()));
	}
	
	public static String[] generateTestData(int size) {
        String[] words = { "Apple", "Banana", "Cherry", "Dog", "Elephant", "Fish", "Giraffe", "House", "Ice", "Jaguar",
                           "Kite", "Lion", "Monkey", "Nest", "Orange", "Pineapple", "Queen", "Rabbit", "Snake", "Tiger",
                           "Umbrella", "Violin", "Wate rmelon", "Xylophone", "Yak", "Zebra" };
        Random random = new Random();
        String[] result = new String[size+1];

        for (int i = 0; i < size; i++) {
            char firstChar = (char) ('A' + (i % 26));  // Ensures A-Z cyclically
            String randomWord = words[random.nextInt(words.length)];
            result[i] = firstChar + randomWord;
        }
        result[size] = "ZZZZZZEBRA";
        return result;
    }
}
