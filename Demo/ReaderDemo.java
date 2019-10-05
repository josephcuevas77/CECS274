package Demo;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.File;
import java.io.FileNotFoundException;

public class ReaderDemo {
	
	//throws FileNotFoundException tells the compiler that if the files is not found in the location given,
	//then it should display an error message (Exception) and terminate the program
	public static void main(String[] args) throws FileNotFoundException {
		File txtFile =  new File("C:\\Users\\Joseph\\Desktop\\School Resources\\\\CECS 274\\tollfreecomplete.txt");
		
		Scanner fileReader = new Scanner(txtFile);
		
		//Create a Pattern object to represent the regex
		Pattern p = Pattern.compile("([\\w|\\s|-]+)\\s[.]+\\s([\\d|-]+)");
		//Declare a Matcher OBJECT
		Matcher m;
		
		//Read the file using the Scanner method
		while(fileReader.hasNextLine()) {
			String currentLine = fileReader.nextLine();
			m = p.matcher(currentLine);
			
			if(m.find()) {
				
				String wholeLine = m.group(0);//this is the whole line that matched the pattern
				String companyName = m.group(1);//this is the first group
				String companyPh = m.group(2);//this is the second group we captured
				
				System.out.println("Line matched: " + wholeLine);
				System.out.println("Company Name: " + companyName + "Ph " + companyPh + "\n");
			}
		}
		
		//Close the Reader to prevent unwanted changes to the external file
		fileReader.close();
	}
}
