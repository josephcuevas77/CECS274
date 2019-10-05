package Demo;

import java.util.Arrays;

public class SelectionSorter {
	
	public static void sort(int[] a) {
		for(int i = 0; i < a.length; i++) {
			
			//index of the minimum element at the tail
			int idxMIN = ArrayUtil.idxMinElement(a, i);
			if(a[i] > a[idxMIN]) { //if the current element is larger than teh min element
				ArrayUtil.swap(a, i, idxMIN);//swap them
			}
		}
	}

	public static void main(String[] args) {
		int[] ages = {4, 5, 1, 42, 9};
		System.out.println("BEFORE: " + Arrays.toString(ages));
		sort(ages);
		System.out.println("AFTER: " + Arrays.toString(ages));

	}

}
	
	
