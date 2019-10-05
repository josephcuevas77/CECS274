package Project4;

import java.util.Arrays;

import Phonebook.BubbleSorter;

public class Test {

	public static void main(String[] args) {
		double[] test = {6.1, 4.2, 3.3, 7.4, 5.5, 2.6, 8.7, 1.8};
		BubbleSorter.bubbleSort(test);
		
		System.out.println(Arrays.toString(test));
	}
}
