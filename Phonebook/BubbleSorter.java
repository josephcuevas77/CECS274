package Phonebook;

public class BubbleSorter {

	//Sorting through Array of doubles
	public static void bubbleSort(double[] arraySort){
		int n = arraySort.length;
		for (int i = 0; i < n-1; i++) 
			for (int j = 0; j < n-i-1; j++) 
				if (arraySort[j] > arraySort[j+1]) 
				{ 	double temp = arraySort[j]; 
					arraySort[j] = arraySort[j+1]; 
					arraySort[j+1] = temp; 
				} 
		
	}

	
}
