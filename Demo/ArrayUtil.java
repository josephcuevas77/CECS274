package Demo;

import java.util.Arrays;

public class ArrayUtil {

	
	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;		
	}
	
	/**
	 * returns the index of the smallest element beginning at given index
	 * @param a - array of integers
	 * @param start - index of the first element to consider for a min
	 */
	public static int idxMinElement(int[] a, int start) {
		int idxMIN = start;
		
		for(int i = start + 1; i < a.length; i++) {
			if(a[i] < a[idxMIN]) {
				idxMIN = i;
			}
		}
		return start;
	}
	
	public static void main(String[] args) {
		int[] ages = {34, 3, 39, 12, 9, 21};
		System.out.println(idxMinElement(ages, 0)); //Expecting a 1
		System.out.println(idxMinElement(ages, 2)); //Expecting a 4
	}
}
