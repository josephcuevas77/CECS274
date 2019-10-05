package Project4;

import java.util.Random;

public class Project4 {
	
	//Sorting through Array of doubles to sort and select
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

	//Generates empty arrays to be filled later
	public static double[] GenerateDoubleArray(int size) {
		Random randInt = new Random();
		double[] List = new double[size];
		for(int i = 0; i < size; i++) {
			List[i] = randInt.nextInt(1000 + 1 - 1);
		}
		return List;
	}
	
	public static void main(String[] args) {
		//Calls the stopwatch in order to use functions within the class
		Stopwatch sW = new Stopwatch();
		
		//Create the lists by each amount filled with the doubles
		double[] tenK = GenerateDoubleArray(10000); 
		double[] twentyK = GenerateDoubleArray(20000);
		double[] thirtyK = GenerateDoubleArray(30000);
		double[] fortyK = GenerateDoubleArray(40000);
		double[] fiftyK = GenerateDoubleArray(50000);
		double[] sixtyK = GenerateDoubleArray(60000);
		
		//Test for 10,000 doubles
		sW.start();
		bubbleSort(tenK);
		sW.stop();
		System.out.println("The elapsed time for 10,000 doubles was: " + sW.elapsedTime() + " ms");
		sW.reset();
		
		//Test for 20,000 doubles
		sW.start();
		bubbleSort(twentyK);
		sW.stop();
		System.out.println("The elapsed time for 20,000 doubles was: " + sW.elapsedTime() + " ms");
		sW.reset();
		
		//Test for 30,000 doubles
		sW.start();
		bubbleSort(thirtyK);
		sW.stop();
		System.out.println("The elapsed time for 30,000 doubles was: " + sW.elapsedTime() + " ms");
		sW.reset();
		
		//Test for 40,000 doubles
		sW.start();
		bubbleSort(fortyK);
		sW.stop();
		System.out.println("The elapsed time for 40,000 doubles was: " + sW.elapsedTime() + " ms");
		sW.reset();
		
		//Test for 50,000 doubles
		sW.start();
		bubbleSort(fiftyK);
		sW.stop();
		System.out.println("The elapsed time for 50,000 doubles was: " + sW.elapsedTime() + " ms");
		sW.reset();
		
		//Test for 60,000 doubles
		sW.start();
		bubbleSort(sixtyK);
		sW.stop();
		System.out.println("The elapsed time for 60,000 doubles was: " + sW.elapsedTime() + " ms");
		sW.reset();
		
	}

	
}
