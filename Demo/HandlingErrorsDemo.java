package Demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
import java.io.NumberFormatException;

public class HandlingErrorsDemo {

	public static void sumIntegers(String path)throws FileNotFoundException{

		File textfile = new File(path);
		Scanner fileReader = new Scanner (textfile);

		int sum = 0;
		while(fileReader.hasNext()) {
			//reading the next string and parsing it to an int
			int n = Integer.parseInt(fileReader.next());
			sum += n;
			System.out.print(n + " ");

		}
		System.out.println("Sum: " + sum);
		fileReader.close();

	}

	public static void main(String[] args)throws FileNotFoundException{
		System.out.println("Enter the path of the file: ");
		Scanner nani = new Scanner(System.in);
		while(true){
			try {
				sumIntegers(nani.nextLine());
				break; // this will execute only if the static method does NOT throw away any exceptions
			}

			catch(IOException e) {
				System.out.println("The file does not exist in the given location. Please try again.");
			}
			catch(NumberFormatException n) {
				System.out.println("The file contains data other than integers. Please try again.");
			}
			finally {
				System.out.println("This message will print regardless of whether an exception is thrown or not. "
						+ "In fact, anything in finally block executes always.\n");
			}
		}
	}
}
